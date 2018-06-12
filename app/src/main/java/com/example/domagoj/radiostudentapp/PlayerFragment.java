package com.example.domagoj.radiostudentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Util;

import saschpe.exoplayer2.ext.icy.IcyHttpDataSourceFactory;

/**
 * Created by Kenda on 4/10/2018.
 */

public class PlayerFragment extends Fragment {
    private ImageButton b_play_pause;
    private TextView textView;

    private ExoPlayer player;
    private boolean prepared = false;
    private boolean started = false;
    private IcyHttpDataSourceFactory icyHttpDataSourceFactory;
    private ExtractorsFactory extractorsFactory;
    // private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_fragment, container, false);

        b_play_pause = view.findViewById(R.id.b_play_pause);

        textView = view.findViewById(R.id.textView);

        initializePlayer();
        ImageButton imageButton1 = view.findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.facebooklogo);

        ImageButton imageButton2 = view.findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.instagramlogo);

        ImageButton imageButton3 = view.findViewById(R.id.imageButton3);
        imageButton3.setImageResource(R.drawable.soundcloudlogo);

        new PlayerTask().execute(RadioConstants.STREAM_URI);
        b_play_pause.setOnClickListener(v -> {
            if(started){
                started = false;
                player.setPlayWhenReady(false);
                b_play_pause.setImageResource(R.drawable.play);

            } else {
                started = true;
                player.setPlayWhenReady(true);
                b_play_pause.setImageResource(R.drawable.pause);
            }
        });
        imageButton1.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(RadioConstants.FACEBOOKU_RI));
            startActivity(intent);
        });
        imageButton2.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(RadioConstants.INSTAGRAM_URI));
            startActivity(intent);
        });
        imageButton3.setOnClickListener(v ->  {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(RadioConstants.MIXCLOUD_URI));
            startActivity(intent);
        });

        return view;
    }


    @Override
    public void onPause() {
        super.onPause();
        if(started){
            player.setPlayWhenReady(true);
            b_play_pause.setImageResource(R.drawable.pause);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (started){
            player.setPlayWhenReady(true);
            b_play_pause.setImageResource(R.drawable.pause);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (prepared){
            player.setPlayWhenReady(false);
            b_play_pause.setImageResource(R.drawable.play);
        }
    }

    private class PlayerTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            // This is the MediaSource representing the media to be played.
            Uri videoUri = Uri.parse(strings[0]);
            MediaSource videoSource = new ExtractorMediaSource(videoUri,
                    // dataSourceFactory,
                    icyHttpDataSourceFactory,
                    extractorsFactory,
                    null, null);

            // Prepare the player with the source.
            player.prepare(videoSource);
            prepared = true;
            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            b_play_pause.setEnabled(true);
        }
    }

    private void initializePlayer() {
        // Create a default TrackSelector
        TrackSelector trackSelector = new DefaultTrackSelector(
                new AdaptiveTrackSelection.Factory(new DefaultBandwidthMeter()));
        //Initialize the player
        player = ExoPlayerFactory.newSimpleInstance(this.getContext(), trackSelector);
        // Produces Extractor instances for parsing the media data.
        extractorsFactory = new DefaultExtractorsFactory();

        // Dodano za: ExoPlayer2 Shoutcast Metadata Protocol (ICY) extension
        IcyHttpData icyHttpData = new IcyHttpData(s -> textView.setText(s));
        // Custom HTTP data source factory which requests Icy metadata and parses it if
        // the stream server supports it
        String userAgent = Util.getUserAgent(this.getContext(), RadioConstants.APPLICATION_NAME);
        icyHttpDataSourceFactory = new IcyHttpDataSourceFactory.Builder(userAgent)
                .setIcyHeadersListener(icyHttpData::iceHeader)
                .setIcyMetadataChangeListener(icyHttpData::icyMetadata)
                .build();
    }


}
