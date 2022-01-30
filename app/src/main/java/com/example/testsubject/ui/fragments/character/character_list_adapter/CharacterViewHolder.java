package com.example.testsubject.ui.fragments.character.character_list_adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testsubject.data.models.Character;
import com.example.testsubject.databinding.ItemCharacterBinding;

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    protected void onBind(Character character) {
        ItemCharacterBinding.bind(itemView).tvCharacterName.setText(character.getName());
        ItemCharacterBinding.bind(itemView).tvCharacterStatus.setText(character.getStatus());
        Glide
                .with(ItemCharacterBinding.bind(itemView).getRoot())
                .load(character.getImage())
                .into(ItemCharacterBinding.bind(itemView).ivCharacterAvatar);
    }
}
