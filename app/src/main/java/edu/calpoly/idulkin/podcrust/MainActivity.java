package edu.calpoly.idulkin.podcrust;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import audiosearch.Audiosearch;
import audiosearch.exception.CredentialsNotFoundException;
import audiosearch.model.TrendResult;

public class MainActivity extends AppCompatActivity {

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
                    for (TrendResult trendResult : body) {
                        Log.d("trend", trendResult.getTrend());
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
}
