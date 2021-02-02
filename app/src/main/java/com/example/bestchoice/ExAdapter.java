package com.example.bestchoice;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ExAdapter extends RecyclerView.Adapter<ExAdapter.ExampleViewHolder>{

    private ArrayList<Card_Item> mList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public boolean happy = true;
        public ImageView mImgView;
        public LinearLayout lt;
        public ImageView mImgDelete;
        private OnItemClickListener mListener;
        public interface OnItemClickListener {
            void onDeleteClick(int postition);
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            mListener = listener;
        }

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImgView = itemView.findViewById(R.id.imgView);
            mImgDelete = itemView.findViewById(R.id.imgdelete);
            lt = itemView.findViewById(R.id.layoutCard);
            itemView.findViewById(R.id.btnColore).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Random rnd = new Random();
                    int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                    lt.setBackgroundColor(color);
                }
            });

            itemView.findViewById(R.id.btnImmagine).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (happy)
                    {
                        mImgView.setImageResource(R.drawable.sad);
                        mImgView.setBackgroundColor(Color.parseColor("#ff0000"));
                        happy = false;
                    }
                    else
                    {
                        mImgView.setImageResource(R.drawable.happy);
                        mImgView.setBackgroundColor(Color.parseColor("#00ff00"));
                        happy = true;
                    }
                }
            });

            mImgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onDeleteClick(position);}
                    }
                }
            });
        }
    }



    public ExAdapter(ArrayList<Card_Item> exlista){
        mList = exlista;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Card_Item item1 = mList.get(position);
        holder.mImgView.setImageResource(item1.getmImageResource());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
