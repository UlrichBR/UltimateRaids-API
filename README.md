# RaidWeaver API

Public Java API for **RaidWeaver**.

This repository contains the supported public contracts used by plugins, addons and extensions that integrate with UltimateRaids.

The API intentionally exposes only the public integration surface. Internal runtime managers, persistence implementations, GUI internals, EntityWizard internals, WorldEdit/FAWE implementation code and mutable Core collections are not part of this artifact.

---

## Maven

The Maven coordinate intentionally keeps the historical artifact id for compatibility.

```xml
<dependency>
    <groupId>io.github.ulrichbr</groupId>
    <artifactId>UltimateRaids-API</artifactId>
    <version>VERSIONE</version>
    <scope>provided</scope>
</dependency>
```

RaidWeaver provides the implementation at runtime, so the API should normally remain `provided`.

For a normal Bukkit/Paper plugin:

```yaml
depend: [RaidWeaver]
```

For addons and extensions, use the corresponding `addon.yml` or `extension.yml` metadata.

---

## Root Access

```java
RaidWeaverAPI api = RaidWeaverProvider.get();

RaidAPI raids = api.getRaidAPI();
IntegrationAPI integrations = api.getIntegrationAPI();
RegistryAPI registry = api.getRegistryAPI();
```

From an RaidWeaver addon/extension, the same public services are also available through the Raid Core exposed to the addon runtime.

---

## Reading Raid Data

```java
RaidAPI raids = RaidWeaverProvider.get().getRaidAPI();

raids.getRaid("forgottencrypt").ifPresent(raid -> {
    getLogger().info("Raid ID: " + raid.getId());
    getLogger().info("Raid Name: " + raid.getName());
});
```

The public API exposes read-only Raid/runtime views rather than mutable internal Core objects.

---

## Queue a Player

```java
RaidAPI raids = RaidWeaverProvider.get().getRaidAPI();

RaidQueueResult result = raids.queueRaidFromTrigger(player, "forgottencrypt");

if (!result.isSuccess()) {
    player.sendMessage(result.getMessage());
}
```

Queue, join, leave, ready and vote operations are exposed through the public Raid API.

---

## Listen for Raid Events

```java
@EventHandler
public void onRaidComplete(RaidCompleteEvent event) {
    UUID instanceId = event.getInstance().getId();
    String raidId = event.getInstance().getDefinition().getId();

    getLogger().info(
        "Raid completed: " + raidId + " / " + instanceId
    );
}
```

UltimateRaids exposes Bukkit lifecycle events so integrations can react to Raid activity without depending on internal managers.

---

## Addons

RaidWeaver addons extend the Raid ecosystem while running directly on the RaidWeaver addon runtime.

Example:

```java
public final class MyAddon extends RaidAddon {

    @Override
    public void onEnable() {
        getRaidCore()
            .getRegistryAPI()
            .registerAction(new MyAction());
    }

    @Override
    public void onDisable() {
        getRaidCore()
            .getRegistryAPI()
            .unregisterAction("MY_ACTION");
    }
}
```

Example `addon.yml`:

```yaml
name: MyRaidAddon
main: com.example.raids.MyAddon
version: 1.0.0
author: Example
min-version: 0.12.0
depend: []
softdepend: []
```

---

## Extensions

Extensions are intended for integrations with external plugins and providers.

Example:

```java
public final class MyExtension extends RaidAddon {

    @Override
    public void onEnable() {
        getRaidCore()
            .getIntegrationAPI()
            .registerItem(new MyItemProvider());
    }

    @Override
    public void onDisable() {
        getRaidCore()
            .getIntegrationAPI()
            .unregisterAll("MYPLUGIN");
    }
}
```

Example `extension.yml`:

```yaml
name: MyIntegration
main: com.example.raids.MyExtension
version: 1.0.0
author: Example
min-version: 0.12.0
depend: [MyPlugin]
softdepend: []
```

---

## Public Extension Points

The public SDK includes contracts such as:

- `ItemParseImplement`
- `EntityImplement`
- `GroupImplement`
- `EconomyImplement`
- `BorderImplement`
- `SchematicImplement`
- `RaidActionImplement`
- `RaidRewardImplement`
- `RaidObjectiveImplement`
- `RaidRequirementImplement`

Implementations remain inside external addons/extensions. RaidWeaver owns the registries and invokes those public contracts.

---

## Public API Scope

The public API exposes supported contracts and read-only runtime views for systems such as:

- Raids
- Raid Instances
- Lobbies
- Stages
- Queue / Join / Leave
- Ready flow
- Voting
- Start / Stop
- Validation and completion queries
- Integrations
- Public registries
- Bukkit lifecycle events

The API deliberately does **not** expose:

- Core internal managers
- Persistence/storage implementations
- Mutable internal runtime collections
- GUI implementation details
- Raw YAML configuration objects
- Scheduler implementation internals
- EntityWizard implementation internals
- WorldEdit/FAWE implementation internals

This separation allows the Core to evolve without forcing external integrations to depend on implementation details.

---

## Official RaidWeaver Examples

Ready-to-use Raid configurations are maintained separately from the API:

**UltimateRaids-Examples**

https://github.com/UlrichBR/UltimateRaids-Examples

The examples repository contains complete configurations for:

- `DYNAMIC` Raids
- `DISCOVERY` progression
- `INSTANCE + SCHEMATIC`
- `INSTANCE + WORLD`
- Raid-based Minigames
- Bosses, phases, minions and enrage
- Kits
- Loot Tables
- Skills
- Schedulers
- Scoreboards and BossBars
- NPC/display examples
- Provider-backed holograms

The featured `forgottencrypt` example includes a complete dungeon schematic and a full DISCOVERY Raid configuration.

Examples are intentionally kept outside this API repository so the Java SDK remains focused on public integration contracts.

---

## Related Projects

**RaidWeaver Examples**  
https://github.com/UlrichBR/UltimateRaids-Examples

**RaidWeaver Documentation**  
https://wiki.tribecraft.com.br/en/ultimateraids/1/

**RaidWeaver Builder**  
https://tribecraft.com.br/raids-builder/

---

## Compatibility

The API version used by your project should match the public API version expected by the RaidWeaver Core you target.

Do not compile against internal Core classes when a public API contract exists.

---

## License / Usage

This repository contains the public integration API for UltimateRaids.

The API may be used by third-party plugins, addons and extensions to integrate with UltimateRaids without depending on private Core implementation.
