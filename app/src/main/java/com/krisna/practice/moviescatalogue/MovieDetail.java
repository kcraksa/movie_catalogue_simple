package com.krisna.practice.moviescatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetail extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "Extra Movie";
    TextView txtTitle, txtReleaseDate, txtSynopsis, txtDuration, txtGenre;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        txtTitle = findViewById(R.id.tv_title_dtl);
        txtReleaseDate = findViewById(R.id.tv_release_date_dtl);
        txtSynopsis = findViewById(R.id.tv_synopsis_dtl);
        imgPhoto = findViewById(R.id.img_photo_dtl);
        txtDuration = findViewById(R.id.tv_duration_dtl);
        txtGenre = findViewById(R.id.tv_genre_dtl);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        txtTitle.setText(movie.getTitle());
        txtReleaseDate.setText(movie.getRelease_date());
        txtSynopsis.setText(movie.getSynopsis());
        imgPhoto.setImageResource(movie.getPhoto());
        txtDuration.setText(movie.getDuration());
        txtGenre.setText(movie.getGenre());
    }
}
