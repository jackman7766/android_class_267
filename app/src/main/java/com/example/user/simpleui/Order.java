package com.example.user.simpleui;

import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by user on 2016/6/6.
 */
@ParseClassName("Order")
public class Order extends ParseObject{
    //String note;
    //String menuResults;
    //String storeInfo;

    public String getNote(){ return getString("note");}
    public void setNote(String note){ put("note", note);}

    public String getMenuResults(){
        String menuResults = getString(("menuResults"));
        if(menuResults == null)
        {
            menuResults = "";
        }
        return menuResults;
    }
    public void setMenuResults(String menuResults){ put("menuResults", menuResults);}

    public String getStoreInfo(){ return getString("storeInfo");}
    public void setStoreInfo(String storeInfo){ put("storeInfo", storeInfo);}

    public static ParseQuery<Order> getquery() {return ParseQuery.getQuery(Order.class);}

    public static void getOrderFromRemote(final FindCallback callback)
    {
        getquery().findInBackground(new FindCallback<Order>() {
            @Override
            public void done(List<Order> objects, ParseException e) {

                if(e == null){
                    ParseObject.pinAllInBackground(objects);  //全都先存在local
                }
                callback.done(objects, e);
            }
        });
    }

    public JSONObject getJsonObject()
    {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("note", getNote());
            jsonObject.put("menuResults", getMenuResults());
            jsonObject.put("storeInfo", getStoreInfo());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  jsonObject;
    }

    public static Order newInstanceWithData(String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            Order order = new Order();
            order.setNote(jsonObject.getString("note")) ;
            order.setStoreInfo(jsonObject.getString("storeInfo"));
            order.setMenuResults(jsonObject.getString("menuResults"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
