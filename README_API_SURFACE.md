# UltimateRaids Public API Surface

This source tree is the public SDK for UltimateRaids.

It intentionally contains contracts, data objects and Bukkit events only. Core managers, persistence, GUI implementation, EntityWizard internals, WorldEdit/FAWE implementation code and runtime engine internals are not part of this artifact.

Current integration target:

```text
UltimateRaids-API 0.12.0-BETA-2.0-RELEASE
```

---

## Root Access

```java
UltimateRaidsAPI api = UltimateRaidsProvider.get();

RaidAPI raids = api.getRaidAPI();
IntegrationAPI integrations = api.getIntegrationAPI();
RegistryAPI registry = api.getRegistryAPI();
```

Inside an UltimateRaids addon/extension:

```java
public final class MyAddon extends RaidAddon {

    @Override
    public void onEnable() {
        getRaidCore()
            .getIntegrationAPI()
            .registerItem(new MyItemProvider());

        getRaidCore()
            .getRegistryAPI()
            .registerAction(new MyAction());
    }

    @Override
    public void onDisable() {
        getRaidCore()
            .getIntegrationAPI()
            .unregisterAll("MYPLUGIN");

        getRaidCore()
            .getRegistryAPI()
            .unregisterAction("MY_ACTION");
    }
}
```

---

## addon.yml

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

## extension.yml

```yaml
name: MyIntegration
main: com.example.raids.MyExtension
version: 1.0.0
author: Example
min-version: 0.12.0
depend: [MythicMobs]
softdepend: []
```

---

## Public Extension Points

The current public SDK includes extension contracts such as:

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

The implementation of these contracts remains in external addons/extensions. UltimateRaids only owns the public registries and invokes the registered contracts.

---

## Public Runtime Surface

The API may expose supported public views and operations for:

- Raids
- Raid Instances
- Lobbies
- Stages
- Queue / Join / Leave
- Ready state
- Voting
- Start / Stop
- Validation/completion queries
- Public integrations
- Public registries
- Bukkit lifecycle events

These surfaces should be preferred over direct access to internal Core implementation.

---

## Intentionally Not Public

The API does not expose implementation-specific systems such as:

- Internal Core managers
- Storage implementations
- Mutable internal runtime collections
- Raw YAML configuration objects
- GUI implementation details
- Scheduler implementation internals
- EntityWizard implementation internals
- WorldEdit/FAWE implementation internals

This keeps external integrations isolated from Core implementation changes.

---

## Examples Repository

Ready-to-use Raid configurations are maintained separately:

https://github.com/UlrichBR/UltimateRaids-Examples

That repository contains working examples for:

- `DYNAMIC`
- `DISCOVERY`
- `INSTANCE + SCHEMATIC`
- `INSTANCE + WORLD`
- Minigame Raid flow
- Bosses and phases
- Loot Tables
- Skills
- Schedulers
- Scoreboard/BossBar presentation
- NPC/display and hologram integrations

The API repository should remain focused on Java integration contracts; example Raid content belongs in `UltimateRaids-Examples`.

---

## Documentation

UltimateRaids documentation:

https://wiki.tribecraft.com.br/en/ultimateraids/1/
