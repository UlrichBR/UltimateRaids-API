# UltimateRaids Public API Surface

This source tree is the public SDK for UltimateRaids. It intentionally contains contracts, data objects and Bukkit events only. Core managers, persistence, GUI implementation, EntityWizard, WorldEdit/FAWE implementation code and runtime engine internals are not part of this artifact.

## Root access

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
        getRaidCore().getIntegrationAPI().registerItem(new MyItemProvider());
        getRaidCore().getRegistryAPI().registerAction(new MyAction());
    }

    @Override
    public void onDisable() {
        getRaidCore().getIntegrationAPI().unregisterAll("MYPLUGIN");
        getRaidCore().getRegistryAPI().unregisterAction("MY_ACTION");
    }
}
```

## addon.yml

```yaml
name: MyRaidAddon
main: com.example.raids.MyAddon
version: 1.0.0
author: Example
min-version: 0.10.0
depend: []
softdepend: []
```

## extension.yml

```yaml
name: MyIntegration
main: com.example.raids.MyExtension
version: 1.0.0
author: Example
min-version: 0.10.0
depend: [MythicMobs]
softdepend: []
```

## Public extension points

- ItemParseImplement
- EntityImplement
- GroupImplement
- EconomyImplement
- BorderImplement
- SchematicImplement
- RaidActionImplement
- RaidRewardImplement
- RaidObjectiveImplement
- RaidRequirementImplement

The implementation of these contracts remains in external addons/extensions. UltimateRaids only owns the registries and invokes the public contracts.
