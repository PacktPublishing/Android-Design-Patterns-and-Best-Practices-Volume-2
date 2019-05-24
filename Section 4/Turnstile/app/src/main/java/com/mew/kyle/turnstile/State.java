package com.mew.kyle.turnstile;

public interface State {

    void execute(Context context, String input);
}
