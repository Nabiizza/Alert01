package com.example.nabilachowdhury.alert01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<Info> datas;
    Context context;

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Info singleInfo = datas.get(position);

        LayoutInflater infoInflater = LayoutInflater.from(context);
        View customView = infoInflater.inflate(R.layout.list_item_view,parent,false);

        TextView name = (TextView) customView.findViewById(R.id.info_name);
        TextView height = (TextView) customView.findViewById(R.id.info_height);
        TextView weight = (TextView) customView.findViewById(R.id.info_weight);
        name.setText(singleInfo.name);
        height.setText(singleInfo.height);
        weight.setText(singleInfo.weight);

        //name.setText((CharSequence) datas.get(position));

        /*name.setText((CharSequence)   singleInfo);
        height.setText((CharSequence) singleInfo);
        weight.setText((CharSequence) singleInfo);*/

        return customView;
    }

    public MyAdapter(Context context, ArrayList<Info> datas) {
        super();
        this.datas = datas;
        this.context = context;
    }
}
