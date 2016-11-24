package com.lebartodev.mercurylab5;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 24.11.2016.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageVH> {
    private List<String> imagesUrls = new ArrayList<>();
    private Context context;


    public ImageAdapter(Context context, List<String> imagesUrls) {
        this.context = context;
        this.imagesUrls = imagesUrls;
    }

    @Override
    public ImageVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.i_image, parent, false);
        return new ImageVH(v);
    }

    @Override
    public void onBindViewHolder(ImageVH holder, int position) {
        Glide.with(context).load(imagesUrls.get(position))
                .placeholder(R.drawable.placeholder).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return imagesUrls.size();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    class ImageVH extends RecyclerView.ViewHolder {
        private ImageView image;

        public ImageVH(View itemView) {

            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
