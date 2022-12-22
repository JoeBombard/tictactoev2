package com.example.tictactoev2;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Jour> jour;

    public CustomAdapter(ArrayList<Jour> jours) {
        jour = jours;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutviewholder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setImage(jour.get(position).image);
        holder.setText(jour.get(position).text);
        holder.setMessage(jour.get(position).message);
    }

    @Override
    public int getItemCount() {
        return jour.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        int message;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(view -> {
                Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
            });
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void setText(int message) {textView.setText(message);}
        public void setImage(int image) {imageView.setImageResource(image);}
        public void setMessage(int messages) {message = messages;}
    }
}
