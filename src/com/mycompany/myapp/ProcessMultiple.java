package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;

public class ProcessMultiple extends Activity
{
    ArrayList<Uri> imageUris = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_multiple);
        
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        
        TextView tv = (TextView) findViewById(R.id.multiple_header_textview);
        Button b = (Button) findViewById(R.id.multiple_process_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessLogic.encryptImages(imageUris);
            }
        });
        GridView gv = (GridView) findViewById(R.id.multiple_grid_view);
        
        if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("image/")) {
                imageUris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                tv.setText(UriToFile.getRealPathFromURI(this,imageUris.get(0)));
                gv.setAdapter(new ImageAdapter(this,imageUris));
            }
        }
    }
}
