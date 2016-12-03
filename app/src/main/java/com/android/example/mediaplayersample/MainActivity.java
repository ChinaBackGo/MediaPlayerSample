package com.android.example.mediaplayersample;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private float mVolume = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaPlayer = MediaPlayer.create(this, R.raw.song);

        //Set onClickListener for Play Button
        Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Play Audio
                mMediaPlayer.start(); // no need to call prepare(); create() does that for you

                //Test with a toast
                Log.i("MainActivity:onClick", "Play Button: Pressed");
            }
        });

        //Set up onclick listener for Pause Button
        Button pauseButton = (Button) findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Play Audio
                mMediaPlayer.pause();

                //Test with a toast
                Log.i("MainActivity:onClick", "Pause Button: Pressed");
            }
        });

        //Set up onclick listener for Volume Increase Button
        Button volumeIncreaseButton = (Button) findViewById(R.id.volume_increase);
        volumeIncreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mVolume = Math.min(mVolume + 0.1f, 1.0f);
                //Set Volume
                mMediaPlayer.setVolume(mVolume, mVolume);

                //Test with a toast
                Log.i("MainActivity:onClick", "VolumeIncrease: Pressed - Volume Set: " + mVolume);
            }
        });

        //Set up onclick listener for Volume Decrease Button
        Button volumeDecreaseButton = (Button) findViewById(R.id.volume_decrease);
        volumeDecreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set Volume
                mVolume = Math.max(mVolume - 0.1f, 0.0f);
                mMediaPlayer.setVolume(mVolume, mVolume); // no need to call prepare(); create() does that for you

                //Test with a toast
                Log.i("MainActivity:onClick", "VolumeDecrease: Pressed - Volume set: " + mVolume);
            }
        });

        //Set up onclick listener for skip forward Button
        Button skipForwardButton = (Button) findViewById(R.id.skip_forward);
        skipForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Seek Audio
                int currentPos = mMediaPlayer.getCurrentPosition();
                mMediaPlayer.seekTo(currentPos + 1000);

                //Test with a toast
                Log.i("MainActivity:onClick", "Skip Forward: Pressed");
            }
        });

        //Set up onclick listener for skip backward Button
        Button skipBackwardButton = (Button) findViewById(R.id.skip_backward);
        skipBackwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Seek Audio
                int currentPos = mMediaPlayer.getCurrentPosition();
                mMediaPlayer.seekTo(currentPos - 1000);

                //Test with a toast
                Log.i("MainActivity:onClick", "Skip Backward: Pressed");
            }
        });
    }
}
