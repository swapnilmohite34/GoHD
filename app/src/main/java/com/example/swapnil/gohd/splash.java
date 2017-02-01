package com.example.swapnil.gohd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by SWAPNIL on 30-Jan-16.
 */
public class splash extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_scrren);
        Thread th=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent startMain=new  Intent(getApplicationContext(),Activity1.class);
                    startActivity(startMain);
                    finish();
                }
               catch (InterruptedException e){
                    e.printStackTrace();
               }

            }
        }; th.start();

    }
}
