package com.example.anew.intservicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    IntentFilter inf;
    Intent i;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inf=new IntentFilter();
        inf.addAction("image is loading");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent)
            {
                Toast.makeText(context,"Image loaded component",Toast.LENGTH_LONG).show();
                Bitmap bmp=intent.getParcelableExtra("image");
                iv=findViewById(R.id.iv1);
                iv.setImageBitmap(bmp);
            }
        },inf);
    }

    private void registerReceiver(BroadcastReceiver broadcastReceiver)
    {

    }

    public void getimage(View view)
    {
        i=new Intent(this,Intser.class);
        startActivity(i);
    }
}
