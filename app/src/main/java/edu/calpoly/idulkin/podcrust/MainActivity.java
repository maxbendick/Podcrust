package edu.calpoly.idulkin.podcrust;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import audiosearch.Audiosearch;
import audiosearch.exception.CredentialsNotFoundException;
import audiosearch.model.AudioFile;
import audiosearch.model.RelatedEpisodes;
import audiosearch.model.TrendResult;

public class MainActivity extends AppCompatActivity {
    private Button b1,b2,b3,b4;
    private ImageView iv;
    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();;
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private TextView tx1,tx2,tx3;

    public static int oneTimeOnly = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doRestTest();
    }

    private void doRestTest() {
        Log.d("doRestTest", "starting...");

        final String callbackUrl = "urn:ietf:wg:oauth:2.0:oob";
        final String applicationId = "c2b235f2620e362157a40aec609e737fe5a2547784933e00201ff90358e092c5";
        final String secret = "bee75fbb20ce6b45b64113b44208d12aeca02121fee8ea40f1bd9f44b491ba1c";
        final String authorizationCode = "ad2311b2860d224f89c32b7dfd4cb99550ba358aef412fae9ad11b52957a8930";

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Audiosearch client = new Audiosearch()
                            .setApplicationId(applicationId)
                            .setSecret(secret)
                            .build();

                    List<TrendResult> body = client.getTrending().execute().body();

                    // Getting every single mp3 link from every RelatedEpisodes from each trend
                    for (TrendResult trendResult : body) {
                        String relatedEpisodes = "";
                        for (RelatedEpisodes episode : trendResult.getRelatedEpisodes()) {
                            for (AudioFile audiofile : episode.getAudioFiles()) {
//                                relatedEpisodes += episode.getTitle() + " " + audiofile.getMp3() + " ";
                                AudioDescription audioDescription = new AudioDescription(episode, audiofile);
                                Log.d("trend", audioDescription.toString());
                            }
                        }
                        if (relatedEpisodes.isEmpty()) {
                            relatedEpisodes = "EMPTY";
                        }
                        Log.d("trend", trendResult.getTrend() + " " + relatedEpisodes + " " );
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("rest test","IOException");
                } catch (CredentialsNotFoundException e) {
                    e.printStackTrace();
                    Log.d("rest test","CredentialsNotFoundException");
                }
            }
        });
        thread.start();
        Log.d("doRestTest", "initialized thread...");
    }

    public void launchPlayPodcastActivity(View view){
        Context context = getApplicationContext();
        Intent intent = new Intent(context, PlayPodcastActivity.class);

        context.startActivity(intent);
    }
}
