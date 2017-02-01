package com.example.swapnil.gohd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by SWAPNIL on 31-Mar-16.
 */
public class ImageAdaptor4 extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds1 = {
            R.drawable.cr1, R.drawable.cr2,
            R.drawable.cr3, R.drawable.cr4,
            R.drawable.cr5, R.drawable.cr6

    };

    // Constructor
    public ImageAdaptor4(Context c){
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
