package com.damishs.ads_lk.ui.home;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damishs.ads_lk.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {

    private List<AdItem> listItems;
    private Context context;
    private OnItemListener mOnItemListener;

    public MyAdapter2(List<AdItem> listItems, Context context, OnItemListener onItemListener) {
        this.listItems = listItems;
        this.context = context;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public MyAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adlistitem,parent,false);
        return new ViewHolder(v,mOnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.ViewHolder holder, int position) {

        AdItem AdItem = listItems.get(position);
        holder.adName.setText(AdItem.getAdName());
        holder.publishedDate.setText(AdItem.getPublishedDate());
        holder.sellerName.setText(AdItem.getSellerName());
        holder.specialText.setText(AdItem.getSpecialText());
        holder.price.setText(AdItem.getPrice());
 //       holder.imageUrl.setText(AdItem.getImageUrl());
//        holder.imageView.setImageURI(Uri.parse(""));

        String imageUri = AdItem.getImageUrl();

        Picasso.with(context).load(imageUri).into(holder.imageView);
        //.resize(50, 50).
        //Picasso.with(context).load(imageUri).fit().centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView publishedDate,adName,sellerName,specialText,price;
        ImageView imageView;

        OnItemListener onItemListener;

        public ViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            imageView= itemView.findViewById(R.id.imageView);
            publishedDate=itemView.findViewById(R.id.textViewDate);
            adName=itemView.findViewById(R.id.textViewAdName);
            sellerName=itemView.findViewById(R.id.textViewSellerName);
            specialText=itemView.findViewById(R.id.textViewSpecialText);
            price=itemView.findViewById(R.id.textViewPrice);

            this.onItemListener = onItemListener;

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener{
        void onItemClick(int position);

    }

}
