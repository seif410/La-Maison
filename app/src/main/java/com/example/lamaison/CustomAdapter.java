package com.example.lamaison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

    String[] firsttextview;
    Context context;
    String[] secondtextview;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter(Clothes clothes, String[] prgmNameList, int[] prgmImages, String[] ppp) {
        // TODO Auto-generated constructor stub
        firsttextview = prgmNameList;
        context = clothes;
        imageId = prgmImages;
        secondtextview = ppp;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return firsttextview.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        TextView name;
        ImageView img;
        TextView price;
        Button btn;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.programlist, null);
        holder.name = (TextView) rowView.findViewById(R.id.textView1);
        holder.price = (TextView) rowView.findViewById(R.id.textView2);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
        holder.btn = (Button) rowView.findViewById(R.id.button);

        holder.name.setText(firsttextview[position]);
        holder.img.setImageResource(imageId[position]);
        holder.price.setText(secondtextview[position]);
        holder.btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You Clicked " + firsttextview[position], Toast.LENGTH_LONG).show();
                Toast.makeText(context, "You Clicked " + secondtextview[position], Toast.LENGTH_LONG).show();

            }
        });

        return rowView;
    }

}