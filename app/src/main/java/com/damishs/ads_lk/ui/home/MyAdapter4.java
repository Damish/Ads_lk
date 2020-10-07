package com.damishs.ads_lk.ui.home;

import android.content.Context;
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

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.ViewHolder> {

    private List<AdItem> listItems;
    private Context context;
    private OnItemListener mOnItemListener;

    public MyAdapter4(List<AdItem> listItems, Context context, OnItemListener onItemListener) {
        this.listItems = listItems;
        this.context = context;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public MyAdapter4.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adlistitem4,parent,false);
        return new ViewHolder(v,mOnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter4.ViewHolder holder, int position) {

        AdItem AdItem = listItems.get(position);
        holder.adName.setText(AdItem.getAdName());
        holder.publishedDate.setText(AdItem.getPublishedDate());
        holder.sellerName.setText(AdItem.getSellerName());
        holder.specialText.setText(AdItem.getSpecialText());
        holder.price.setText(AdItem.getPrice());

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
            imageView= itemView.findViewById(R.id.imageView2);
            publishedDate=itemView.findViewById(R.id.textViewDate2);
            adName=itemView.findViewById(R.id.textViewAdName2);
            sellerName=itemView.findViewById(R.id.textViewSellerName2);
            specialText=itemView.findViewById(R.id.textViewSpecialText2);
            price=itemView.findViewById(R.id.textViewPrice2);

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
