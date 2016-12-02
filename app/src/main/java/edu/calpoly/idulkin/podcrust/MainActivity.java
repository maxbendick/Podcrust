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
import audiosearch.model.EpisodeQueryResult;
import audiosearch.model.EpisodeResult;
import audiosearch.model.RelatedEpisodes;
import audiosearch.model.TrendResult;
import edu.calpoly.idulkin.podcrust.rest.SearchShowResult.SearchShowResult;
import retrofit2.Call;
import retrofit2.Response;

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
    private static final String TAG = "MainActivity";

    public static int oneTimeOnly = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        doRestTest();
//        doSearchTest();
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

                    SearchShowResult searchShowResult = client.searchShows("startup").execute().body();

                    // Getting every single mp3 link from every RelatedEpisodes from each trend
                    for (TrendResult trendResult : body) {
                        String relatedEpisodes = "";
                        for (RelatedEpisodes episode : trendResult.getRelatedEpisodes()) {
                            for (AudioFile audiofile : episode.getAudioFiles()) {
//                                relatedEpisodes += episode.getTitle() + " " + audiofile.getMp3() + " ";
                                TrendAudio audioDescription = new TrendAudio(episode, audiofile);
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

    private void doSearchTest() {
        // Similar to doRestTest()
        // Difference starts about initializing the Audiosearch object (client)
        Log.d(TAG, "doSearchTest: called; waiting for user input");

        final String callbackUrl = "urn:ietf:wg:oauth:2.0:oob";
        final String applicationId = "c2b235f2620e362157a40aec609e737fe5a2547784933e00201ff90358e092c5";
        final String secret = "bee75fbb20ce6b45b64113b44208d12aeca02121fee8ea40f1bd9f44b491ba1c";
        final String authorizationCode = "ad2311b2860d224f89c32b7dfd4cb99550ba358aef412fae9ad11b52957a8930";
//        final String callbackUrl = "urn:ietf:wg:oauth:2.0:oob";
//        final String applicationId = "ed87cdb095b49b1fab3231f69ea86311365528aa3e8b3a499666a1030ef58c56";
//        final String secret = "89ddacc015dab3471b73bbe45ebdb2a57ae44a9cb7ec3f0e08fb4dca0aaa37fa";
//        final String authorizationCode = "5dd588086e5decedad948d1def60f8853b494ba14642a2942cc5761bd44ad97c";

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Audiosearch client = new Audiosearch().setApplicationId(applicationId).setSecret(secret).build();
//                    Audiosearch client = new Audiosearch(applicationId, secret).setSignature(authorizationCode).build();
//                            .setApplicationId(applicationId)
//                            .setSecret(secret)
//                            .build();

                    Call<EpisodeQueryResult> call = client.searchEpisodes("Obama");
                    Log.d(TAG, "run: Call<EpisodeQueryResult> " + call);
                    Response response = call.execute();
                    EpisodeQueryResult eqr = (EpisodeQueryResult) response.body();
                    Log.d(TAG, "run: " + eqr.getQuery());
                    Log.d(TAG, "run: " + call.isExecuted());
                    Log.d(TAG, "run: " + response.message());
                    Log.d(TAG, "run: " + response.isSuccessful());
                    List<EpisodeResult> list = eqr.getResults();
                    for (EpisodeResult episodeResult : list) {
                        for (AudioFile audiofile : episodeResult.getAudioFiles()) {
//                                relatedEpisodes += episode.getTitle() + " " + audiofile.getMp3() + " ";
                            SearchAudio sa = new SearchAudio(episodeResult, audiofile);
                            Log.d("searched", sa.getShow_title());
                            // sa.getMp3() gets the mp3 in String format
                            Log.d("searched", sa.getMp3());
                        }
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("search test","IOException");
                } catch (CredentialsNotFoundException e) {
                    e.printStackTrace();
                    Log.d("search test","CredentialsNotFoundException");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("search test", "Exception");
                }
            }
        });
        thread.start();
        Log.d("doSearchTest", "initialized thread...");
    }

    public void launchPlayPodcastActivity(View view){
        Context context = getApplicationContext();
        Intent intent = new Intent(context, EpisodeListActivity.class);

        context.startActivity(intent);
    }
}
