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


public class CustomAdapter{ /*extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Journer> journers;


    public CustomAdapter(ArrayList<Journer> journer){
        journers = journer;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutimage,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setImage(journers.get(position).getImage());
        holder.setText(journers.get(position).getText());
        holder.setMessageView(journers.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return journers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        int messageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(view ->      {
                Snackbar.make(view, messageView, Snackbar.LENGTH_LONG).show();

            });
            textView = itemView.findViewById(R.id.jourtexte);
            imageView = itemView.findViewById(R.id.joureimage);
        }
        public void setText(int message) {
            textView.setText(message);
        }
        public void setImage(int image){
            imageView.setImageResource(image);
        }
        public void setMessageView(int messages){messageView = messages;};

    }
    public int test(int position){
        return journers.get(position).getMessage();
    }


*/
}
