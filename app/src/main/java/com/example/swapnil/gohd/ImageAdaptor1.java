package com.example.swapnil.gohd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by SWAPNIL on 28-Mar-16.
 */
public class ImageAdaptor1 extends BaseAdapter{
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds1 = {
            R.drawable.c1, R.drawable.c2,
            R.drawable.c3, R.drawable.c4,
            R.drawable.c5, R.drawable.c6

    };

    // Constructor
    public ImageAdaptor1(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds1.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds1[position];

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds1[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(470, 470));
        return imageView;
    }
}
