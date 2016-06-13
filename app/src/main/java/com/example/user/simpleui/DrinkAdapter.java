package com.example.user.simpleui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/6/13.
 */
public class DrinkAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<Drink> drinks;

    public DrinkAdapter(Context context, ArrayList<Drink> drinks) {
        this.inflater = LayoutInflater.from(context);
        this.drinks = drinks;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return drinks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_drink_item, null);
            holder = new Holder();
            holder.drinkNameTextView = (TextView) convertView.findViewById(R.id.drinkNameTextView);
            holder.mPriceTextView = (TextView) convertView.findViewById(R.id.mPriceTextView);
            holder.lPriceTextView = (TextView) convertView.findViewById(R.id.lPriceTextView);
            holder.drinkImageView = (ImageView) convertView.findViewById(R.id.drinkImageView);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        Drink drink = drinks.get(position);
        return null;
    }

    class Holder{
        TextView drinkNameTextView;
        TextView mPriceTextView;
        TextView lPriceTextView;
        ImageView drinkImageView;
    }
}
