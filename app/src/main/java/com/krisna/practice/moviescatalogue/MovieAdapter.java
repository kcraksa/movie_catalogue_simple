package com.krisna.practice.moviescatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.items, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {

        private TextView txtTitle, txtReleaseDate, txtSynopsis;
        private ImageView imgPhoto;

        public ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.tv_title);
            txtReleaseDate = view.findViewById(R.id.tv_release_date);
            txtSynopsis = view.findViewById(R.id.tv_synopsis);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());
            txtReleaseDate.setText(movie.getRelease_date());
            txtSynopsis.setText(movie.getSynopsis());
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }
}
