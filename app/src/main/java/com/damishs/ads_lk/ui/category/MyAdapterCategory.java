package com.damishs.ads_lk.ui.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damishs.ads_lk.R;
import com.damishs.ads_lk.ui.home.AdItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapterCategory extends RecyclerView.Adapter<MyAdapterCategory.ViewHolder> {

    private List<CategoryItem> listItems;
    private Context context;
    private OnItemListener mOnItemListener;

    public MyAdapterCategory(List<CategoryItem> listItems, Context context, OnItemListener onItemListener) {
        this.listItems = listItems;
        this.context = context;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public MyAdapterCategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list_item,parent,false);
        return new ViewHolder(v,mOnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterCategory.ViewHolder holder, int position) {

        CategoryItem categoryItem = listItems.get(position);
        holder.CategoryName.setText(categoryItem.getCategoryName());
        holder.CategoryResults.setText(categoryItem.getNoOfResults());

        // String imageUri = AdItem.getImageUrl();
        // Picasso.with(context).load(imageUri).into(holder.imageView);
        //.resize(50, 50).
        //Picasso.with(context).load(imageUri).fit().centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView CategoryName,CategoryResults;
        ImageView imageView;

        OnItemListener onItemListener;

        public ViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);

            CategoryName=itemView.findViewById(R.id.txtCategoryName);
            CategoryResults=itemView.findViewById(R.id.txtCategoryResults);

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
