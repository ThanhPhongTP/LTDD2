package com.example.naochiennhom2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
   Context context;
   //ArrayList<Images> data = null;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //final Animation animation = AnimationUtils.loadAnimation(context, R.anim.quay);
        final ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(this.context);
            imageView.setLayoutParams(new GridView.LayoutParams(200,200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        else
            imageView = (ImageView)convertView;
            imageView.setImageResource(R.drawable.lg);

//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    imageView.startAnimation(animation);
//                }
//            });
        return imageView;
    }
}
