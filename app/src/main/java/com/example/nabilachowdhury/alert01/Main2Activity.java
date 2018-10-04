package com.example.nabilachowdhury.alert01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends Activity {

    //ListView infoList;
    public MyAdapter infoAdapter;
    public ArrayList<Info> datas;
    public ListView showDataView; // This is the listview of the second activity added
    Context context;
    //int pos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        datas = intent.getBundleExtra("data_sent_from_previous_activity").getParcelableArrayList("user_data");
        showDataView = findViewById(R.id.info_list_2);
        infoAdapter = new MyAdapter(this,datas);
        showDataView.setAdapter(infoAdapter);
        infoAdapter.notifyDataSetChanged();
        AlertDialog.Builder builder ;
        builder = new AlertDialog.Builder(context);
        builder.setTitle("Names")
                .setAdapter(infoAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        showDataView.setAdapter(infoAdapter);
//                        infoAdapter.notifyDataSetChanged();


                    }
                }).show();


//        Get the AlertDialog from create()
        //AlertDialog dialog = builder.create();

    }





}

