package com.example.kyle.statictextfiles;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static String readFile(Context context, int resId) {

        InputStream stream = context.getResources()
                .openRawResource(R.raw.wiki);
        InputStreamReader inputReader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        String line;
        StringBuilder builder = new StringBuilder();

        try {
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line)
                        .append('\n');
            }
        } catch (IOException e) {

            return null;
        }

        return builder.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text_view);
        String data = readFile(this, R.raw.wiki);
        textView.setText(data);
    }
}
