package com.example.management;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ModelFood>mList;
    OnContactClickListener onContactClickListener;

    FoodAdapter(Context mContext, ArrayList<ModelFood>list,OnContactClickListener onContactClickListener){
        this.mContext = mContext;
        mList = list;
        this.onContactClickListener=onContactClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.rv_food_items,parent,false);

        ViewHolder viewHolder = new ViewHolder(view,onContactClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final ModelFood foodItem = mList.get(position);
        ImageView image;
        TextView name,place,price;

        image = holder.item_image;

        name = holder.item_name;
        place = holder.item_place;
        price = holder.item_price;

        Glide.with(mContext)
                .load(foodItem.getImage())
                .override(100, 200)
                .fitCenter()
                .dontAnimate()
                .into(image);

        name.setText(foodItem.getName());
        place.setText(foodItem.getPlace());
        price.setText(foodItem.getPrice());

        /*holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(mContext,"You Clicked"+position+foodItem.getName(),Toast.LENGTH_LONG).show();

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView item_image;
        TextView item_name,item_place,item_price;
        OnContactClickListener onContactClickListener;

        public ViewHolder(@NonNull View itemView , OnContactClickListener onContactClickListener) {
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);

            item_name = itemView.findViewById(R.id.item_name);
            item_place= itemView.findViewById(R.id.item_place);
            item_price = itemView.findViewById(R.id.item_price);
            this.onContactClickListener=onContactClickListener;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            onContactClickListener.onContactClick(v,getAdapterPosition());
        }
    }

    public interface OnContactClickListener{
         void onContactClick(View v,int position);
    }

}
