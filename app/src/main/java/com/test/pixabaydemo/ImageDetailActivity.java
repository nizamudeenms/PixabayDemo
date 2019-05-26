package com.test.pixabaydemo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.test.pixabaydemo.model.Hit;

public class ImageDetailActivity extends AppCompatActivity {
    ImageView detailImageView, userImageView, shareImage;
    RelativeLayout userLayout;
    TextView userNameText;
    LottieAnimationView loadingAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        Hit imageDetails = this.getIntent().getParcelableExtra("details");

        detailImageView = findViewById(R.id.detail_image_view);
        userImageView = findViewById(R.id.user_image_view);
        userLayout = findViewById(R.id.user_layout);
        userNameText = findViewById(R.id.user_name_text);
        shareImage = findViewById(R.id.share_image);
        loadingAnimation = findViewById(R.id.detail_image_view_loading_anim);

        if (imageDetails.getWebformatURL() != null) {
            Glide.with(this).load(imageDetails.getWebformatURL())
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            loadingAnimation.setVisibility(View.INVISIBLE);
                            return false;
                        }
                    }).into(detailImageView);
        } else {
            Glide.with(this).load(R.drawable.pixabay_logo).into(detailImageView);
        }

        if (!imageDetails.getUserImageURL().equals("")) {
            Glide.with(this).load(imageDetails.getUserImageURL())
                    .apply(RequestOptions.circleCropTransform()).placeholder(R.drawable.pixabay_thumb).into(userImageView);
            if (imageDetails.getUser() != null) {
                userNameText.setText(imageDetails.getUser());
            } else {
                userNameText.setVisibility(View.GONE);
            }
        } else {
            userLayout.setVisibility(View.GONE);
        }


        shareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "PixaBay");

                String shareText = "Hi, Checkout this Image in Pixabay by Nizam. ";
                intent.putExtra(Intent.EXTRA_TEXT, shareText);
                startActivity(Intent.createChooser(intent, "Share with"));


            }
        });

    }
}
