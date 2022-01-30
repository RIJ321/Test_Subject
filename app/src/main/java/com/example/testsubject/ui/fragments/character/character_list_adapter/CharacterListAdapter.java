package com.example.testsubject.ui.fragments.character.character_list_adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testsubject.R;
import com.example.testsubject.data.models.Character;

import java.util.List;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private List<Character> list;
    private OnCharacterItemClickListener itemClickListener;

    public void setList(List<Character> list) {
        this.list = list;
    }

    public void setItemClickListener(OnCharacterItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_character, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.onBind(list.get(position));

        holder.itemView.setOnClickListener(view -> {
            itemClickListener.inCharacterClick(list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
