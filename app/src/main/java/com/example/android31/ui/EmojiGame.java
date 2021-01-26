package com.example.android31.ui;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.android31.data.Card;
import com.example.android31.data.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmojiGame {

    private Game game;

    @RequiresApi(api = Build.VERSION_CODES.R)
    public EmojiGame() {
        List<String> content = List.of("A", "B", "C");
//        content.add("A");
//        content.add("B");
//        content.add("C");
       // Collections.shuffle(content);
        game = new Game<>(content);
    }

    public void choose(Card<String> card) {
        game.choose(card);
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }
}
