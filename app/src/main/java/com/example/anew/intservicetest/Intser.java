package com.example.anew.intservicetest;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Intser extends IntentService
{
    URL url;
    public Intser(String name)
    {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent)
    {
        try
        {
            url=new URL("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&h=350");
            InputStream ins=url.openStream();
            Bitmap bmp= BitmapFactory.decodeStream(ins);
            intent.setAction("image sent");
            Bitmap bmp1= ThumbnailUtils.extractThumbnail(bmp,40,40);
            intent.putExtra("image",bmp1);
            sendBroadcast(intent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
