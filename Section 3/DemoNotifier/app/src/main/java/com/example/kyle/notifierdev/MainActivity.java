package com.example.kyle.notifierdev;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_stat_note)
                        .setContentTitle("Cheese and pickle on rye")
                        .setContentText("8 people like your sandwich");

        // Sets an ID for the notification
        int id = 001;

        // Gets an instance of the NotificationManager service
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Builds the notification and issues it.
        manager.notify(id, builder.build());
    }
}
