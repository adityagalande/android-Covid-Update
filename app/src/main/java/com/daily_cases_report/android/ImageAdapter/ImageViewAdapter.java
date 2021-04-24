package com.daily_cases_report.android.ImageAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.daily_cases_report.android.R;

public class ImageViewAdapter extends PagerAdapter {

    private final Context mContext;
    private final int[] imageID = new int[] {R.drawable.wear_mask, R.drawable.wash_hands, R.drawable.stay_home};

    public ImageViewAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return imageID.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(imageID[position]);
        container.addView(imageView, 0);
        return imageView;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

}
