package edu.calpoly.idulkin.podcrust;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import audiosearch.Audiosearch;
import audiosearch.exception.CredentialsNotFoundException;
import audiosearch.model.AudioFile;
import audiosearch.model.EpisodeQueryResult;
import audiosearch.model.EpisodeResult;
import retrofit2.Call;
import retrofit2.Response;

/**
 * An activity representing a list of Episodes. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link EpisodeDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class EpisodeListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private static final String TAG = "EpisodeListActivity";
    public static ArrayList<SearchAudio> searchAudioList;
    private SimpleItemRecyclerViewAdapter a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

//        View recyclerView = findViewById(R.id.episode_list);
//        assert recyclerView != null;
//        setupRecyclerView((RecyclerView) recyclerView);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.episode_list);
        assert recyclerView != null;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        if (savedInstanceState == null) {
            searchAudioList = new ArrayList<SearchAudio>();
        } else {
            searchAudioList = savedInstanceState.getParcelableArrayList("SEARCHAUDIOLIST");
        }

        a = new SimpleItemRecyclerViewAdapter(searchAudioList);
        recyclerView.setAdapter(a);

        Button clickButton = (Button) findViewById(R.id.submit);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EditText header = (EditText) findViewById(R.id.header);
                String query = header.getText().toString();

                if (query.trim().length() > 0) {
                    header.setText("Search episode");
                    doSearch(query);
                    a.notifyDataSetChanged();
                } else {
                    Toast.makeText(getApplicationContext(), "Search for an episode", Toast.LENGTH_SHORT).show();
                }
                for (SearchAudio searchAudio : searchAudioList) {
                    System.out.println(searchAudio.getTitle() + " " + searchAudio.getMp3());
                }


            }
        });

        EditText header = (EditText) findViewById(R.id.header);
        header.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.d(TAG, "header onKey called");
                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    EditText header = (EditText) findViewById(R.id.header);
                    String query = header.getText().toString();

                    if (query.trim().length() > 0) {
                        header.setText("Search episode");
                        doSearch(query);
                        a.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getApplicationContext(), "Search for an episode", Toast.LENGTH_SHORT).show();
                    }
                    for (SearchAudio searchAudio : searchAudioList) {
                        System.out.println(searchAudio.getTitle() + " " + searchAudio.getMp3());
                    }

                    return false;
                }
                return false;
            }
        });

        if (findViewById(R.id.episode_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(searchAudioList));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ArrayList<SearchAudio> mValues;

        public SimpleItemRecyclerViewAdapter(ArrayList<SearchAudio> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.episode_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.bind(searchAudioList.get(position));
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).getTitle());

            holder.mIdView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString("TITLE", holder.mItem.getTitle());
                        arguments.putString("MP3", holder.mItem.getMp3());
                        EpisodeDetailFragment fragment = new EpisodeDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.episode_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        //Not using EpisodeDetailActivity
                        Intent intent = new Intent(context, PlayPodcastActivity.class);
                        intent.putExtra("TITLE", holder.mItem.getTitle());
                        intent.putExtra("MP3", holder.mItem.getMp3());

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            if (searchAudioList == null) {
                return 0;
            }
            return searchAudioList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final TextView mIdView;
            public SearchAudio mItem;

            public ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mIdView.getText() + "'";
            }

            public void bind(SearchAudio sa) {
                mItem = sa;
                mIdView.setText(mItem.getTitle());
            }
        }
    }

    // Called when the Submit button is clicked through onClickListener above
    private void doSearch(final String query) {
        Log.d(TAG, "doSearch: called");
        final String callbackUrl = "urn:ietf:wg:oauth:2.0:oob";
        final String applicationId = "c2b235f2620e362157a40aec609e737fe5a2547784933e00201ff90358e092c5";
        final String secret = "bee75fbb20ce6b45b64113b44208d12aeca02121fee8ea40f1bd9f44b491ba1c";
        final String authorizationCode = "ad2311b2860d224f89c32b7dfd4cb99550ba358aef412fae9ad11b52957a8930";

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Audiosearch client = new Audiosearch().setApplicationId(applicationId).setSecret(secret).build();

                    Call<EpisodeQueryResult> call = client.searchEpisodes(query);
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
                            searchAudioList.add(sa);
                            Log.d("searched ", "> added  " + sa.getTitle() + " to List");
                        }
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("searching...","IOException");
                } catch (CredentialsNotFoundException e) {
                    e.printStackTrace();
                    Log.d("searching...","CredentialsNotFoundException");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("searching...", "Exception");
                }
            }
        });
        thread.start();
        Log.d("doSearch", "initialized thread...");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("SEARCHAUDIOLIST", searchAudioList);
        super.onSaveInstanceState(outState);
    }
}
