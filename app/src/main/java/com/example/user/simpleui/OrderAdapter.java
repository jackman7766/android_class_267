package com.example.user.simpleui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 2016/6/6.
 */
public class OrderAdapter extends BaseAdapter {

    ArrayList<Order> orders;
    LayoutInflater inflater;

    public OrderAdapter(Context context, ArrayList<Order> orders)
    {
      this.orders= orders;
        this.inflater =  LayoutInflater.from(context);
    }
    @Override
    public int getCount() {

        return orders.size();

    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if(convertView == null)
       {
           convertView = inflater.inflate(R.layout.listview_oder_item, null);

       }

        TextView drinkNameTextView = (TextView)convertView.findViewById(R.id.drinkNameTextView);
        TextView noteTextView = (TextView)convertView.findViewById(R.id.noteTextView);

        Order order = orders.get(position);

        drinkNameTextView.setText(order.drinkName);
        noteTextView.setText(order.note);
        return convertView;
    }
}
