package com.example.user.simpleui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    RadioGroup radioGroup;
    CheckBox checkBox;
    ListView listView;
    Spinner storeSpinner;

    ArrayList<Order> orders = new ArrayList<>();
    final int REQUEST_CODE_DRINK_MENU_ACTIVITY = 0;
//    String selectedSex = "Male";
//    String name = "";
//    String sex = "";
String drinkName = "black tea";
    String menuResults ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.TextView);
        editText = (EditText) findViewById(R.id.editText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        listView = (ListView)findViewById(R.id.listView);
        storeSpinner = (Spinner)findViewById(R.id.storeSpinner);

        setupListView();

        setupListView();
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    click(v);
                    return true;
                }
                return false;
            }
        });

        Log.d("Debug", "Main Acti OnCreate");
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
//                if (checkedID == R.id.maleRadioButton) {
//                    selectedSex = "Male";
//                } else if (checkedID == R.id.femaleRadioButton2) {
//                    selectedSex = "Female";
//                }
                RadioButton radioButton = (RadioButton) findViewById(checkedID);
                drinkName = radioButton.getText().toString();
            }
        });
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                changeTextView();
//            }
//        });

    }
    void setupSpinner()
    {
        String[] data = getResources().getStringArray(R.array.storeInfo);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        storeSpinner.setAdapter(adapter);
    }
    void setupListView()
    {
//        String[] data = new String[]{"123", "456","789","Hello","ListView","Hi"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drinks);
//        List<Map<String,String>> data = new ArrayList<>();
//
//        for(int i = 0; i < orders.size(); i++)
//        {
//            Order order = orders.get(i);
//            Map<String,String> item = new HashMap<>();
//
//            item.put("note", order.note); //(key , value)
//            item.put("drinkName", order.drinkName);
//
//            data.add(item);
//        }
//        String[] from = {"note", "drinkName"};
//        int[] to = {R.id.noteTextView, R.id.drinkNameTextView};
//
//        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.listview_oder_item, from, to);
        OrderAdapter adapter = new OrderAdapter(this, orders);
        listView.setAdapter(adapter);
    }

        public void click(View view) {
               String note = editText.getText().toString();
//                sex = selectedSex;
//                changeTextView();

            Order order = new Order();
            order.note = note;
            order.menuResults = menuResults;
            order.storeInfo = (String)storeSpinner.getSelectedItem();
            orders.add(order);

            textView.setText(note);
            menuResults = "";
            editText.setText("");

            setupListView();
            }

    public void goToMenu(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this, DrinkMenuActivity.class);
        startActivityForResult(intent, REQUEST_CODE_DRINK_MENU_ACTIVITY );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==  REQUEST_CODE_DRINK_MENU_ACTIVITY)
        {
            if(resultCode == RESULT_OK)
            {
                menuResults = data.getStringExtra("results");
                Toast.makeText(this, "完成菜單", Toast.LENGTH_LONG).show();
            }
            if(resultCode == RESULT_CANCELED)
            {
                textView.setText("");
                Toast.makeText(this, "取消菜單", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
               super.onStart();
               Log.d("Debug", "Main Activity onStart");
           }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Debug", "Main Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Debug", "Main Activity onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Debug", "Main Activity onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Debug", "Main Activity onDestroy");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Debug", "Main Activity onRestart");
    }
        }

