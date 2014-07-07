package com.mycompany.myapp;

import android.view.*;
import android.util.ArrayList<E>;
import android.net.Uri;
import android.widget.BaseAdapter;
import android.content.Context;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Uri> mImageUris;

    public ImageAdapter(Context c, ArrayList<Uri> imageUris) {
        mContext = c;
        mImageUris = imageuris;
    }

    public int getCount() {
        return mImageUris.size();
    }

    public Object getItem(int position) {
        return mImageUris.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            //imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(4, 4, 4, 4);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageURI((Uri)getItem(position));
        return imageView;
    }

}
