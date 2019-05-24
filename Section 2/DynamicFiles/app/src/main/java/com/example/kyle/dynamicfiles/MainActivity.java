package com.example.kyle.dynamicfiles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String fspc = "comments.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
    }

    public void loadFile(View view) {

        try {
            InputStream stream = openFileInput(fspc);

            if (stream != null) {
                InputStreamReader inputReader = new InputStreamReader(stream);
                BufferedReader bufferedReader = new BufferedReader(inputReader);
                String line;
                StringBuilder builder = new StringBuilder();

                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line)
                            .append("\n");
                }

                stream.close();
                editText.setText(builder.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(View view) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(openFileOutput(fspc, 0));
            writer.write(editText.getText().toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
