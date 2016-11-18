package com.lab.colour.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.lab.colour.R;

import java.util.ArrayList;

/**
 * Created by SeoHyeonBae on 2016-11-16.
 */

public class DetailImagePagerAdapter extends PagerAdapter {

    ArrayList<String> mResources = new ArrayList<String>();

    Context mContext;
    LayoutInflater mLayoutInflater;

    public void init(ArrayList<String> imageUrls){
        mResources = imageUrls;
    }

    public DetailImagePagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return mResources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_detail_image_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        Glide.with(mContext).load(mResources.get(position)).placeholder(R.drawable.loading).centerCrop().into(imageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
