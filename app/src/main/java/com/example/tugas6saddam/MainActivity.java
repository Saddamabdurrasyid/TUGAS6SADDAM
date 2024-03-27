package com.example.tugas6saddam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;

    private String[] itemNames = {"Stylo 160", "Genio", "Scoopy", "Beat", "vario 125", "Vario 160", "Adv 160", "Pcx 160", "Forza 250", "Cbr 150", "Cbr 250", "Sonic 150", "Crf 150L", "Monkey", "Supra 1000hp"};
    private String[] itemDescriptions = {"INI STYLO 160CC", "INI GENIO 125CC", "INI SCOOPY 115CC", "INI BEAT 115CC", "INI VARIO 125CC", "INI VARIO 160CC", "INI ADV 160CC", "INI PCX 160CC", "INI FORZA 250CC", "INI CBR 150CC", "INI CBR 250CC", "INI SONIC 150CC", "INI CRF 150CC", "INI MONKEY 100CC", "INI SUPRA 1000HP"};
    private String[] itemPrices = {"Rp. 27,550,000", "Rp. 19,110,000", "Rp. 21,975,000", "Rp. 18,050,000", "Rp. 22,550,000", "Rp. 26,639,000", "Rp. 36,200,000", "Rp. 32,670,000", "Rp. 90,330,000", "Rp. 37,783,000",
            "Rp. 63,956,000", "Rp. 25,520,000", "Rp. 36,430,000", "Rp. 82,970,000", "Rp. 1,999,999,999"};
    private int[] itemImages = {R.drawable.stylo, R.drawable.genio, R.drawable.scoopy, R.drawable.beat, R.drawable.vario125, R.drawable.vario160, R.drawable.adv, R.drawable.pcx, R.drawable.forza,  R.drawable.cbr150, R.drawable.cbr250, R.drawable.sonic, R.drawable.crf, R.drawable.monkey, R.drawable.supra125};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);
    }

    class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

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
                    Intent intent = new Intent(MainActivity.this, DetailItemActivity.class);
                    intent.putExtra("name", itemNames[position]);
                    intent.putExtra("image", itemImages[position]); // Tambahkan ID gambar ke Intent
                    intent.putExtra("description", itemDescriptions[position]);
                    intent.putExtra("price", itemPrices[position]);

                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemNames.length;
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {
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
}
