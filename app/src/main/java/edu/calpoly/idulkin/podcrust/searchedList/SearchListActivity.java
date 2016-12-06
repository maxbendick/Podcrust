package edu.calpoly.idulkin.podcrust.searchedList;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import audiosearch.Audiosearch;
import edu.calpoly.idulkin.podcrust.rest.SearchShowResult.SearchShowResult;

/**
 * Created by Max on 12/1/2016.
 */

public class SearchListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SearchListView(this));
// pass SearchShowResult to have query
        final String callbackUrl = "urn:ietf:wg:oauth:2.0:oob";
        final String applicationId = "c2b235f2620e362157a40aec609e737fe5a2547784933e00201ff90358e092c5";
        final String secret = "bee75fbb20ce6b45b64113b44208d12aeca02121fee8ea40f1bd9f44b491ba1c";
        final String authorizationCode = "ad2311b2860d224f89c32b7dfd4cb99550ba358aef412fae9ad11b52957a8930";

        new Thread(() -> {
            try {
                Audiosearch client = new Audiosearch()
                        .setApplicationId(applicationId)
                        .setSecret(secret)
                        .build();

                SearchShowResult searchShowResult = client.searchShows("basketball").execute().body();
                Log.d("searchresult", searchShowResult.toString());
                Log.d("searchresult", searchShowResult.getResults().get(0).getTitle());
            } catch (Exception e) {
                Log.d("searchlist", "failure to search");
                Log.d("searchlist", e.toString());
            }
        }).start();
    }
}
