package com.example.lab2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;

import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ImageHolder {
    private static ImageHolder instance;
    public Map<String, Bitmap> images = new HashMap<>();
    ListActivityFragment adapter;
    public static ImageHolder createInstance(List<Item> items, ListActivityFragment adapter) {
        if(instance == null) {
            instance = new ImageHolder(items, adapter);
        }
        return instance;
    }

    public static ImageHolder getInstance() {
        return instance;
    }

    private ImageHolder(List<Item> items,ListActivityFragment  adapter) {
        this.adapter = adapter;
        int[] colors = new int[300*300];
        Arrays.fill(colors, 0, 300*300, Color.GRAY);
        for(Item item : items) {
            images.put(item.getGraphic(), Bitmap.createBitmap(colors, 300, 300, Bitmap.Config.ARGB_8888));
        }
    }
    public Bitmap getImage(String graphics) {
        return images.get(graphics);
    }

}
