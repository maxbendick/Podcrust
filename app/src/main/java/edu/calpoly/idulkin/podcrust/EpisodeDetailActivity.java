package edu.calpoly.idulkin.podcrust;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

/**
 * An activity representing a single Episode detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link EpisodeListActivity}.
 */
public class EpisodeDetailActivity extends AppCompatActivity {

    private String title;
    private String mp3;
    private String description;
    private String img;
    private static final String TAG = "EpisodeDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
//        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();

        title = bundle.getString("TITLE");
        mp3 = bundle.getString("MP3");
        description = bundle.getString("DESCRIPTION");
        img = bundle.getString("IMAGE");
        Log.d(TAG, "onCreate: " + title + mp3 + description + img);


        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
//            Bundle arguments = new Bundle();
//            arguments.putString(EpisodeDetailFragment.ARG_ITEM_ID,
//                    getIntent().getStringExtra(EpisodeDetailFragment.ARG_ITEM_ID));
//            EpisodeDetailFragment fragment = new EpisodeDetailFragment();
//            fragment.setArguments(arguments);
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.episode_detail_container, fragment)
//                    .commit();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        EpisodeDetailFragment fragment = (EpisodeDetailFragment) fragmentManager.findFragmentById(R.id.episode_detail);

        if (fragment == null) {
            EpisodeDetailFragment edf = EpisodeDetailFragment.newInstance(title, mp3, description, img);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.episode_detail, edf);
            fragmentTransaction.commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, EpisodeListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
