package com.example.tugas6saddam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String description = intent.getStringExtra("description");
            String price = intent.getStringExtra("price");
            int imageId = intent.getIntExtra("image", 0); // Terima ID gambar dari Intent

            TextView textName = findViewById(R.id.text_name_detail);
            ImageView imageView = findViewById(R.id.image_view_detail);
            TextView textDescription = findViewById(R.id.text_description_detail);
            TextView textPrice = findViewById(R.id.text_price_detail);

            textName.setText(name);
            textDescription.setText(description);
            textPrice.setText(price);
            imageView.setImageResource(imageId); // Set gambar dengan ID yang diterima

            // Mengatur klik listener untuk tombol Bagikan
            Button btnShare = findViewById(R.id.btn_share);
            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shareText = "Kamu Membeli Barang Ini:\n\nName: " + name + "\nDescription: " + description + "\nPrice: " + price ;

                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                    startActivity(Intent.createChooser(shareIntent, "Share via"));
                }
            });
        } else {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
