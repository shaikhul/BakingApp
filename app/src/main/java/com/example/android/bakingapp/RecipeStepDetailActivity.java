package com.example.android.bakingapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class RecipeStepDetailActivity extends AppCompatActivity {

    @BindView(R.id.description_text_view) TextView description;
    @BindView(R.id.exo_player_view) SimpleExoPlayerView playerView;

    private SimpleExoPlayer exoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_step_detail);

        ButterKnife.bind(this);

        description.setText("2. Whisk the graham cracker crumbs, 50 grams (1/4 cup) of sugar, and 1/2 teaspoon of salt together in a medium bowl. Pour the melted butter and 1 teaspoon of vanilla into the dry ingredients and stir together until evenly mixed.");

        Timber.d("initializing exo player");
        initializePlayer();
    }

    private void initializePlayer() {
        exoPlayer = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(this),
                new DefaultTrackSelector(),
                new DefaultLoadControl());

        playerView.setPlayer(exoPlayer);

        String url = "https://d17h27t6h515a5.cloudfront.net/topher/2017/April/58ffd9a6_2-mix-sugar-crackers-creampie/2-mix-sugar-crackers-creampie.mp4";
        Timber.d("url - " + url);
        Uri uri = Uri.parse(url);
        MediaSource mediaSource = new ExtractorMediaSource(uri,
                new DefaultDataSourceFactory(this, "BakingApp"),
                new DefaultExtractorsFactory(),
                null,
                null);
        exoPlayer.prepare(mediaSource);
        exoPlayer.setPlayWhenReady(true);
    }

    private void releasePlayer() {
        exoPlayer.stop();
        exoPlayer.release();
        exoPlayer = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlayer();
    }
}
