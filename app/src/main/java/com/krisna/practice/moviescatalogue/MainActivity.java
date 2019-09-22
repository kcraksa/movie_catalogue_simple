package com.krisna.practice.moviescatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataTitle, dataReleaseDate, dataSynopsis, dataGenre, dataDuration;
    private TypedArray dataPhoto;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieAdapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movies);
        listView.setAdapter(movieAdapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movie = new Movie();
                movie.setTitle(dataTitle[i]);
                movie.setRelease_date(dataReleaseDate[i]);
                movie.setSynopsis(dataSynopsis[i]);
                movie.setPhoto(dataPhoto.getResourceId(i, -1));
                movie.setDuration(dataDuration[i]);
                movie.setGenre(dataGenre[i]);

                Intent movieDetailIntent = new Intent(MainActivity.this, MovieDetail.class);
                movieDetailIntent.putExtra(MovieDetail.EXTRA_MOVIE, movie);
                startActivity(movieDetailIntent);
            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setRelease_date(dataReleaseDate[i]);
            movie.setSynopsis(dataSynopsis[i]);
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movies.add(movie);
        }
        movieAdapter.setMovies(movies);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.movie_title);
        dataReleaseDate = getResources().getStringArray(R.array.release_date);
        dataSynopsis = getResources().getStringArray(R.array.synopsis);
        dataPhoto = getResources().obtainTypedArray(R.array.poster);
        dataDuration = getResources().getStringArray(R.array.duration);
        dataGenre = getResources().getStringArray(R.array.genre);
    }
}
