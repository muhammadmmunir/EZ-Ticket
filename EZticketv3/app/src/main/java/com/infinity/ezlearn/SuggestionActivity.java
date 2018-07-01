package com.infinity.ezlearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Infinity on 14/12/2017.
 */

public class SuggestionActivity extends AppCompatActivity {
    private List<Match> matchList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MatchAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_suggestion);
        setTitle("Match Suggestion");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);

        mAdapter = new MatchAdapter(matchList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.setAdapter(mAdapter);

        prepareMatchData();
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(SuggestionActivity.this, OrderTicketActivity.class);
                startActivity(intent);
            }
        });
    }

    private void prepareMatchData() {
        Match match = new Match();
        for(int i = 0; i < 14; i++){
            if(MatchData.bigmatch[i] == true){
                if(MatchData.competition[i].equalsIgnoreCase("Champions League")){
                    match = new Match(MatchData.match[i], MatchData.bigmatch[i], MatchData.competition[i], MatchData.time[i]);
                    matchList.add(match);
                }else if(MatchData.competition[i].equalsIgnoreCase("Premier League")){
                    match = new Match(MatchData.match[i], MatchData.bigmatch[i], MatchData.competition[i], MatchData.time[i]);
                    matchList.add(match);
                }else if(MatchData.competition[i].equalsIgnoreCase("FA Cup")){
                    match = new Match(MatchData.match[i], MatchData.bigmatch[i], MatchData.competition[i], MatchData.time[i]);
                    matchList.add(match);
                }else if(MatchData.competition[i].equalsIgnoreCase("League Cup")){
                    match = new Match(MatchData.match[i], MatchData.bigmatch[i], MatchData.competition[i], MatchData.time[i]);
                    matchList.add(match);
                }
            }

        }
        mAdapter.notifyDataSetChanged();
    }
}
