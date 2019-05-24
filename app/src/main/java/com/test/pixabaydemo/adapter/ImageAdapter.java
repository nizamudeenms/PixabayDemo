package com.test.pixabaydemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.test.pixabaydemo.R;
import com.test.pixabaydemo.model.Hit;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    String TAG = ImageAdapter.class.getSimpleName();
    List<Hit> imagesList;
    private Context mContext;
    String previewUrl = null;


    public ImageAdapter( Context mContext, List<Hit> imagesList) {
        this.imagesList = imagesList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.thumbnail, parent, false);
        return new ImageViewHolder(itemView, mContext, imagesList);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        imagesList.get(position);
        ImageView im = holder.thumbnail;
        previewUrl = imagesList.get(position).getPreviewURL();
        if (previewUrl != null) {
            Glide.with(mContext).load(previewUrl).placeholder(R.drawable.pixabay_thumb).into(im);
        } else {
            Glide.with(mContext).load(R.drawable.pixabay_thumb).placeholder(R.drawable.pixabay_thumb).into(im);
        }
    }

    @Override
    public int getItemCount() {

        if (null == imagesList) return 0;
        return imagesList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        List<Hit> imagesList;
        Context context;

        public ImageViewHolder(@NonNull View itemView, Context context, List<Hit> images) {
            super(itemView);
            this.imagesList = images;
            this.context = context;

            thumbnail = itemView.findViewById(R.id.thumbnail_image_view);

        }
    }
}
