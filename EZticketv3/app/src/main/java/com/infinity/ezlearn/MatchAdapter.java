package com.infinity.ezlearn;

/**
 * Created by Infinity on 14/12/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MyViewHolder> {

    private List<Match> matchList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, competition, time;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            competition = (TextView) view.findViewById(R.id.competition);
            time = (TextView) view.findViewById(R.id.time);
        }
    }


    public MatchAdapter(List<Match> moviesList) {
        this.matchList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Match movie = matchList.get(position);
        holder.title.setText(movie.getTitle());
        holder.competition.setText(movie.getCompetition());
        holder.time.setText(movie.getTime());
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }
}
