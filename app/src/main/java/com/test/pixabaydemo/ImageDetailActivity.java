package com.test.pixabaydemo;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.test.pixabaydemo.model.Hit;

import java.util.ArrayList;

public class ImageDetailActivity extends AppCompatActivity {
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        ArrayList<Hit>  imageDetails = this.getIntent().getParcelableArrayListExtra("details");

        imageView = findViewById(R.id.detail_image_view);


        Glide.with(this).load(imageDetails.get(0).getImageURL()).placeholder(R.drawable.pixabay_thumb).into(imageView);

    }
}
