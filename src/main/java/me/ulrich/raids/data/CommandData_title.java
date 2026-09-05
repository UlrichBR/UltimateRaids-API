package me.ulrich.raids.data;

public final class CommandData_title {

    private final String on_help;
    private final String on_success;
    private final String on_error;

    public CommandData_title(String onHelp, String onSuccess, String onError) {
        this.on_help = onHelp == null ? "" : onHelp;
        this.on_success = onSuccess == null ? "" : onSuccess;
        this.on_error = onError == null ? "" : onError;
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
}
