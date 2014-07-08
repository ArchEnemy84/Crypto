package com.mycompany.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Uri> mImageUris;

    public ImageAdapter(Context c, ArrayList<Uri> imageUris) {
        mContext = c;
        mImageUris = imageUris;
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
    public View getView(int position, View convertView, ViewGroup parent) 
    {
        ImageView imageView;
        boolean thumb = true;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, GridView.AUTO_FIT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(4, 4, 4, 4);
        } 
        else 
        {
            imageView = (ImageView) convertView;
        }
        
        if(thumb)
        {
            /*
            Bitmap bitmapOriginal = BitmapFactory.decodeFile(UriToFile.getRealPathFromURI(mContext,(Uri)getItem(position)));
            Bitmap bitmapThumb = Bitmap.createScaledBitmap(bitmapOriginal,200,200,true);
            bitmapOriginal.recycle();
            imageView.setImageBitmap(bitmapThumb);
            */
            try
            {
                Bitmap bitmapOriginal = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), (Uri)getItem(position));
                Bitmap bitmapThumb = Bitmap.createScaledBitmap(bitmapOriginal,200,200*(bitmapOriginal.getHeight()/bitmapOriginal.getWidth()),true);
                bitmapOriginal.recycle();
                imageView.setImageBitmap(bitmapThumb);
            }
            catch(Exception ex)
            {
                
            }
        }
        else
        {
            imageView.setImageURI((Uri)getItem(position));
        }
        
        return imageView;
    }
}
