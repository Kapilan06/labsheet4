package com.example.labsheet4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "notification";

    Button sign;
    EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign=findViewById(R.id.button);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value=(EditText) findViewById(R.id.editText);

                String name= value.getText().toString();

                Intent intent=new Intent(MainActivity.this,Notification.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this, 0,intent,0);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Click on to Register")
                        .setContentText("Hello "+name+ " ! Welcome to the MAD team")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

                NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(MainActivity.this);
                notificationManagerCompat.notify(0,builder.build());
            }
        } );

    }
}
