package com.example.reciclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.reciclerviewexample.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Animal> animalList = new ArrayList<Animal>();
    private Context mContext;
    private OnItemClickListener listener;

    public AnimalAdapter(List<Animal> animalList, Context mContext, OnItemClickListener listener) {
        //this.mLayoutInflater = mLayoutInflater;
        this.animalList = animalList;
        this.mContext = mContext;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_animal,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Animal animal =animalList.get(position);
        holder.textView.setText(animal.getName());
        Glide.with(holder.imageView.getContext()).load(animal.getUrl()).centerCrop().into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewListItem);
            textView = itemView.findViewById(R.id.textViewListItem);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(this,getNameByPosition(getAdapterPosition()),getUrlByPosition(getAdapterPosition()));
        }
    }

    private String getNameByPosition (int position){
        if(position!=RecyclerView.NO_POSITION){
            return animalList.get(position).getName();
        }else{
            return "no hay";
        }
    }
    private String getUrlByPosition (int position){
        if(position!=RecyclerView.NO_POSITION){
            return animalList.get(position).getUrl();
        }else{
            return "no hay";
        }
    }

    public interface OnItemClickListener {
        public void onClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String url);
    }



}
