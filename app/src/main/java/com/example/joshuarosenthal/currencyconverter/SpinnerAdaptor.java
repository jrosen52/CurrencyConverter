package com.example.joshuarosenthal.currencyconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class SpinnerAdapter extends BaseAdapter {

    Context context;
    int images[];
    String[] currency;
    LayoutInflater inflter;

    public SpinnerAdapter (Context applicationContext, int[] flags, String[] currency) {
        this.context = applicationContext;
        this.images = flags;
        this.currency = currency;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.content_main, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(images[i]);
        names.setText(currency[i]);
        return view;
    }
}