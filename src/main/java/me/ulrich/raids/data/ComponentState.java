package me.ulrich.raids.data;

/** Lifecycle state shared by addons and extensions. */
public enum ComponentState {
    DISCOVERED,
    LOADED,
    ENABLED,
    DISABLED,
    FAILED
}
