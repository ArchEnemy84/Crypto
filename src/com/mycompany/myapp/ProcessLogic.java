package com.mycompany.myapp;

import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by Patrick on 20.07.2014.
 */
public class ProcessLogic {
    public static void encryptImages(ArrayList<Uri> imageList)
    {
        for(int i = 0; i < imageList.size(); i++)
            encryptImage(imageList.get(i));
    }

    public static void encryptImage(Uri image)
    {

    }
}
