package me.ulrich.raids.api.model;

/** Read-only contribution metrics for one participant in one raid instance. */
public interface RaidContributionView {
    double getDamage();
    double getBossDamage();
    double getHealing();
    int getKills();
    int getObjectives();
    int getDeaths();
    double getScore();
}
