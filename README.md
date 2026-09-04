# UltimateRaids-API

Public Maven API for integrating plugins and addons with UltimateRaids.

This project intentionally contains **only the stable public surface**. Runtime managers,
storage implementations, GUI code, EntityWizard/WorldEdit integrations and internal raid
definitions are not part of the API artifact.

## Maven

```xml
<dependency>
    <groupId>io.github.ulrichbr</groupId>
    <artifactId>UltimateRaids-API</artifactId>
    <version>0.10.0</version>
    <scope>provided</scope>
</dependency>
```

Your plugin should declare UltimateRaids as a dependency/soft dependency in `plugin.yml`.

```yaml
depend: [UltimateRaids]
```

## Access

```java
UltimateRaidsAPI ultimateRaids = UltimateRaidsProvider.get();
RaidAPI raids = ultimateRaids.getRaidAPI();

raids.getRaid("ancient_crypt").ifPresent(raid -> {
    getLogger().info("Raid: " + raid.getId() + " / " + raid.getName());
});
```

## Queue a player

```java
RaidQueueResult result = raids.queueRaidFromTrigger(player, "ancient_crypt");

if (!result.isSuccess()) {
    player.sendMessage(result.getMessage());
}
```

## Listen for events

```java
@EventHandler
public void onRaidComplete(RaidCompleteEvent event) {
    UUID instanceId = event.getInstance().getId();
    String raidId = event.getInstance().getDefinition().getId();
}
```

## Public design

The API exposes:
- raid/lobby/instance/stage read-only views;
- queue, join, leave, ready and vote operations;
- start/stop operations;
- validation/completion queries;
- lifecycle Bukkit events.

It deliberately does **not** expose internal managers, YAML objects, storage, GUI, scheduler
implementation, EntityWizard internals, WorldEdit internals or mutable runtime collections.
