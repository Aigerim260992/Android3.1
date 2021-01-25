package com.example.android31;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.GnssAntennaInfo;
import android.os.Bundle;

import com.example.android31.data.Card;
import com.example.android31.ui.EmojiAdapter;
import com.example.android31.ui.EmojiGame;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener {
    private RecyclerView recyclerView;
    private EmojiAdapter adapter;
    private EmojiGame game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_cards);
        game = new EmojiGame();
        adapter = new EmojiAdapter(game, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));

    }

    @Override
    public void cardClick(Card<String> card) {
        game.choose(card);
        adapter.notifyDataSetChanged();

    }
}
