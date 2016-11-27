package edu.calpoly.idulkin.podcrust;


import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import java.io.IOException;

/**
 * Created by igor.dulkin on 11/24/16.
 */

public class MediaPlayerService extends Service
        implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, AudioManager.OnAudioFocusChangeListener{

    MediaPlayer mediaPlayer = null;

    private static final String ACTION_PLAY = "com.example.action.PLAY";
    private String url = "http://soundbible.com/grab.php?id=1851&type=mp3";
    private WifiManager.WifiLock wifiLock;
    private AudioManager audioManager;
    private String TAG = "Media Player Service";

    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        MediaPlayerService getService() {
            return MediaPlayerService.this;
        }
    }

    //Tracks the state of the MediaPlayer
    public static enum MP_STATE {
        PLAYING, PAUSED, STOPPED
    }
    private MP_STATE state;

    public MediaPlayerService(){}

    @Override
    public void onCreate(){
        super.onCreate();

        initMediaPlayer();
        Log.d(TAG, "Starting service");

        //Keeps using the wifi to stream if the device goes to sleep
        wifiLock = ((WifiManager) getSystemService(Context.WIFI_SERVICE))
                .createWifiLock(WifiManager.WIFI_MODE_FULL, "PodcrustLock");
        wifiLock.acquire();

        //Creates a Notification to run this as a foreground service
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0,
                new Intent(getApplicationContext(), MainActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT); //This intent is to get the current status of this service for the notification. Not using it yet.

        Notification CrustNotification = new Notification.Builder(getApplicationContext())
                .setContentTitle("PODCRUST PODCRUST PODCRUST")
                .setContentText("podcrust podcrust podcrust")
                .setSmallIcon(R.drawable.ic_play_button)
                .build();

        startForeground(11, CrustNotification);

//        //Initializes AudioManager, for handling audio focus
//        int result = audioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC,
//                AudioManager.AUDIOFOCUS_GAIN);
//
//        if (result != AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//            // could not get audio focus.
//        }

    }

    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /** Called when MediaPlayer is ready */
    public void onPrepared(MediaPlayer player) {
        player.start();
    }

    public void initMediaPlayer() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);

        try {
            mediaPlayer.setDataSource(url);
        }catch(IOException e){
            Log.e("Media Player Sevice:", "Failed to open media stream from URL");
        }
        mediaPlayer.prepareAsync(); // prepare async to not block main thread

        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);

        state = MP_STATE.STOPPED;
    }

    public MP_STATE getState(){
        return state;
    }

    public void start(){
        mediaPlayer.start();
        Log.e("Media Player Service", "Start playback");
        state = MP_STATE.PLAYING;
    }

    public void pause(){
        mediaPlayer.pause();
        Log.e("Media Player Service", "Pause playback");
        state = MP_STATE.PAUSED;
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        // ... react appropriately ...
        // The MediaPlayer has moved to the Error state, must be reset!
        initMediaPlayer();

        return true;
    }

    public void onAudioFocusChange(int focusChange) {
        // Do something based on focus change...
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        mediaPlayer.release();
        mediaPlayer = null;

        wifiLock.release();

        stopForeground(true);
    }
}


