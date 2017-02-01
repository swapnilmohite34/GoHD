package com.example.swapnil.gohd;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by SWAPNIL on 31-Mar-16.
 */
public class DetailsActivity2 extends Activity {
    ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_grid_item);
        ImageAdaptor2 imageAdapter = new ImageAdaptor2(this);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mThumbIds1[position]);
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        Button btnRotate = (Button)findViewById(R.id.rotate);
        Button btn = (Button)findViewById(R.id.button);
        btnRotate.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                arg0.startAnimation(animRotate);
                setWallPaper();
                Toast.makeText(DetailsActivity2.this, "Wallpaper is Set", Toast.LENGTH_SHORT).show();

            }
        });
        btn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Activity1.class);
                startActivity(i);

            }
        });
    }

    public void setWallPaper() {
        WallpaperManager myWallpaperManager
                = WallpaperManager.getInstance(getApplicationContext());
        try {
            Bitmap bitmap=((BitmapDrawable)imageView.getDrawable()).getBitmap();
            if(bitmap!=null)
                myWallpaperManager.setBitmap(bitmap);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
