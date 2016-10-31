package edu.calpoly.idulkin.podcrust;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchPlayPodcastActivity(View view){
        Context context = getApplicationContext();
        Intent intent = new Intent(context, PlayPodcastActivity.class);

        context.startActivity(intent);
    }
}
