package me.ulrich.raids.data;

public final class CommandData_show {

    private final String on_help;
    private final String on_success;
    private final String on_error;
    private final String on_usage;

    public CommandData_show(String onHelp, String onSuccess, String onError, String onUsage) {
        this.on_help = onHelp == null ? "" : onHelp;
        this.on_success = onSuccess == null ? "" : onSuccess;
        this.on_error = onError == null ? "" : onError;
        this.on_usage = onUsage == null ? "" : onUsage;
    }

    public String getOn_help() {
        return on_help;
    }

    public String getOn_success() {
        return on_success;
    }

    public String getOn_error() {
        return on_error;
    }

    public String getOn_usage() {
        return on_usage;
    }
}
