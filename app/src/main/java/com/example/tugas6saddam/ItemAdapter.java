package com.example.tugas6saddam;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context context;
    private String[] itemNames;
    private String[] itemDescriptions;
    private String[] itemPrices;
    private int[] itemImages;

    public ItemAdapter(Context context, String[] itemNames, String[] itemDescriptions, String[] itemPrices, int[] itemImages) {
        this.context = context;
        this.itemNames = itemNames;
        this.itemDescriptions = itemDescriptions;
        this.itemPrices = itemPrices;
        this.itemImages = itemImages;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(itemImages[position]);
        holder.textName.setText(itemNames[position]);
        holder.textDescription.setText(itemDescriptions[position]);
        holder.textPrice.setText(itemPrices[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailItemActivity.class);
                intent.putExtra("name", itemNames[position]);
                intent.putExtra("description", itemDescriptions[position]);
                intent.putExtra("price", itemPrices[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemNames.length;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textName, textDescription, textPrice;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textName = itemView.findViewById(R.id.text_name);
            textDescription = itemView.findViewById(R.id.text_description);
            textPrice = itemView.findViewById(R.id.text_price);
        }
    }
}
