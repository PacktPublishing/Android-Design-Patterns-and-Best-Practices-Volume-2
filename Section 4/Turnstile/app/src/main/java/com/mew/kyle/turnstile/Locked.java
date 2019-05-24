package com.mew.kyle.turnstile;

import java.util.Objects;

public class Locked implements State {

    @Override
    public void execute(Context context, String input) {

        if (Objects.equals(input, "coin")) {
            Output.setOutput("Please push");
            context.setState(new Unlocked());

        } else {
            Output.setOutput("Insert coin");
        }
    }
}
