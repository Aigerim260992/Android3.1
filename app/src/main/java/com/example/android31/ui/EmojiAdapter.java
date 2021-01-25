package com.example.android31.ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android31.R;
import com.example.android31.data.Card;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    private final EmojiGame game;
    private final Listener listener;

    public EmojiAdapter(EmojiGame game, Listener listener) {
        this.game = game;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new EmojiHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.bind(game.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }


    static class EmojiHolder extends RecyclerView.ViewHolder {

        private final Listener listener;
        private final TextView tvCard;

        public EmojiHolder(@NonNull View itemView, Listener listener) {
            super(itemView);
            this.listener = listener;
            tvCard = itemView.findViewById(R.id.tv_card);
        }

        public void bind(Card<String> card) {
            itemView.setOnClickListener(v -> listener.cardClick(card));
            if (card.isFaceUp()) {
                tvCard.setBackgroundColor(Color.WHITE);
                tvCard.setText(card.getContent());
            } else {
                tvCard.setBackgroundColor(Color.BLUE);
                tvCard.setText(" ");
            }
        }
    }

    public interface Listener {
        void cardClick(Card<String> card);
    }
}
