package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.net.Uri;

public class ProcessSingle extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_single);
        
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if (type.startsWith("image/")) {
                ImageView iv = (ImageView) findViewById(R.id.single_image_view);
                Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
                iv.setImageURI(imageUri);
            }
        }

        
        
        
    }
}
