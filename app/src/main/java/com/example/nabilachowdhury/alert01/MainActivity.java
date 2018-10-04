package com.example.nabilachowdhury.alert01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener {
    EditText name;
    EditText height;
    EditText weight;
    Button submit;
    public Button viewAll;
    ListView infoList;
    MyAdapter infoAdapter;
    ArrayList<Info> datas;

    public void jump(){
        viewAll=findViewById(R.id.et_list_view);
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int pos=0;
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("user_data", datas);
                intent.putExtra("data_sent_from_previous_activity",bundle);
                startActivity(intent);

            }
        });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.et_list_name);
        height=findViewById(R.id.et_list_height);
        weight=findViewById(R.id.et_list_weight);
        submit =findViewById(R.id.et_list_submit);

        submit.setOnClickListener(this);
        //name.setOnKeyListener(this);
        datas = new ArrayList<Info>();
        infoAdapter = new MyAdapter(this,datas);
        infoList = (ListView) findViewById(R.id.info_list);
        infoList.setAdapter(infoAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v == submit){
            //String getInput = name.getText().toString();
            /*name.getText().toString();
            height.getText().toString();
            weight.getText().toString();*/
            Info info1= new Info(name.getText().toString(),height.getText().toString(),weight.getText().toString());
            datas.add(info1);
            infoAdapter.notifyDataSetChanged();
            infoList.setVisibility(View.GONE);
            name.setText("");
            height.setText("");
            weight.setText("");
            jump();

        }



    }

    /*@Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_ENTER)) {
            String getInput = name.getText().toString();
            datas.add(getInput);
            infoAdapter.notifyDataSetChanged();
            name.setText("");
            return true;
        }
        return false;
    }*/
}

