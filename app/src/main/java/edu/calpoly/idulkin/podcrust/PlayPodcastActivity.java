package edu.calpoly.idulkin.podcrust;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import edu.calpoly.idulkin.podcrust.R;

public class PlayPodcastActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private static final String TAG = PlayPodcastActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_podcast);
        String url = "http://soundbible.com/grab.php?id=1851&type=mp3";
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            Log.d(TAG, "Opened media stream");
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.start();
        } catch(IOException e){
            Log.e(TAG, "Failed to open media stream");
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}