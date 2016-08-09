package com.example.raymour.myapplication;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Network Status");
        builder.setContentText("Checking for service...");
        NotificationCompat.BigPictureStyle pictureStyle = new NotificationCompat.BigPictureStyle();


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            intent.putExtra("status", true);
            pictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.network_connected));
            builder.setStyle(pictureStyle);
        } else {
            intent.putExtra("status", false);
            pictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.network_disconnected));
            builder.setStyle(pictureStyle);
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 123, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManagerCompat.from(MainActivity.this).notify(678, builder.build());


    }
}