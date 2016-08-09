package com.example.raymour.myapplication;

import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = (ImageView) findViewById(R.id.imageview);
        textView = (TextView) findViewById(R.id.textview);


        Intent intent = getIntent();
        boolean check = intent.getBooleanExtra("status", false);
        if(check) {
            imageView.setImageResource(R.drawable.network_connected);
            textView.setText("You are connected");

            NotificationManagerCompat.from(Main2Activity.this).cancel(678);

        } else {
            imageView.setImageResource(R.drawable.network_disconnected);
            textView.setText("No connection found...");
        }


    }

}
