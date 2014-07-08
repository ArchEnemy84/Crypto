package com.mycompany.myapp;

import android.net.Uri;
import android.content.Context;
import android.provider.MediaStore;
import android.database.Cursor;

public static class UriToFile
{
  public static String getRealPathFromURI(Context context, Uri contentUri) 
    {
        Cursor cursor = null;
        try 
        { 
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        catch(Exception ex)
        {
            Toast.makeToast().show();
        }
        finally 
        {
            if (cursor != null) 
            {
                cursor.close();
            }
        }
    }
}