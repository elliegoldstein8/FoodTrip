package com.example.queenelizabethviii.caireen2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomListView extends ArrayAdapter<String> {

    private String[] burgername;
    private Integer[] burgerdesc;
    private Integer[] imgid;
    private Integer[] id;
    private Activity context;

    public CustomListView(Activity context, String[] burgername, Integer[] burgerdesc, Integer[] imgid, Integer[] id) {
        super (context,R.layout.customlayout,burgername);

        this.context = context;
        this.burgername = burgername;
        this.burgerdesc = burgerdesc;
        this.imgid = imgid;
        this.id = id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View r = convertView;
       ViewHolder viewHolder=null;
       if (r==null){
           LayoutInflater layoutInflater = context.getLayoutInflater();
           r = layoutInflater.inflate(R.layout.customlayout,null,true);
           viewHolder = new ViewHolder(r);
           r.setTag(viewHolder);
       }
       else{
           viewHolder = (ViewHolder) r.getTag();

       }
       viewHolder.ivw.setImageResource(imgid[position]);
       viewHolder.tvw1.setText(burgername[position]);
       viewHolder.tvw2.setText(burgerdesc[position].toString() + " pesos");
       viewHolder.tvw3.setText("ID No." + id[position].toString());
        return r;
    }

    class ViewHolder{
        TextView tvw1, tvw2, tvw3;
        ImageView ivw;
      //  FloatingActionButton flot;
        ViewHolder(View v){
            tvw1 = (TextView) v.findViewById(R.id.tvburgername);
            tvw2 = (TextView) v.findViewById(R.id.tvburgerdesc);
            ivw = (ImageView) v.findViewById(R.id.burgerimage);
            tvw3 = (TextView) v.findViewById(R.id.tvid);
        }
    }
}
