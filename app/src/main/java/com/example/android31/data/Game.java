package com.example.android31.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, contents.get(i), i * 2));
            cards.add(new Card<>(false, false, contents.get(i), i * 2 + 1));
        }
    }

    public void choose(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        findPairs(card);

    }

    private void findPairs(Card<CardContent> card) {
        for (Card<CardContent> searchCard : cards) {
            if (searchCard.isFaceUp()
                    && searchCard.getId() != card.getId()) {
                if (searchCard.getContent() == card.getContent()) {
                    card.setMatched(true);
                    searchCard.setMatched(true);
                    Log.d("tag", "Match!");
                } else {
                    searchCard.setFaceUp(!searchCard.isFaceUp());
                }
            }

        }
        remove();
    }

    private void remove() {
        List<Card<CardContent>> newList = new ArrayList<>(cards);
        for (Card<CardContent> card : cards) {
            if (card.isMatched()) newList.remove(card);
        }
        cards.clear();
        cards.addAll(newList);

    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }
}
