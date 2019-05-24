package com.mew.kyle.turnstile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button buttonCoin;
    Button buttonPush;

    Context context = new Context();
   // Output output = new Output();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);

        buttonCoin = (Button) findViewById(R.id.action_coin);
        buttonPush = (Button) findViewById(R.id.action_push);
        buttonCoin.setOnClickListener(this);
        buttonPush.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.action_coin:
                context.execute("coin");
                break;

            case R.id.action_push:
                context.execute("push");
                break;
        }

        textView.setText(Output.getOutput());
    }
}
