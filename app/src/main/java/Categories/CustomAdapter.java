package Categories;

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

import com.example.lamaison.R;

import Categories.Clothes;
import database.database;

public class CustomAdapter extends BaseAdapter {
    String[] firsttextview;
    Context context;
    int[] secondtextview;
    int[] test;
    String id;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter(Clothes clothes, String[] prgmNameList, int[] prgmImages, int[] ppp, String s) {
        // TODO Auto-generated constructor stub
        firsttextview = prgmNameList;
        context = clothes;
        imageId = prgmImages;
        secondtextview = ppp;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        id = s;
    }

    public CustomAdapter(Groceries groceries, String[] prgmNameList, int[] prgmImages, int[] ppp, String s) {
        // TODO Auto-generated constructor stub
        firsttextview = prgmNameList;
        context = groceries;
        imageId = prgmImages;
        secondtextview = ppp;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        id = s;
    }

    public CustomAdapter(Electronics electronics, String[] prgmNameList, int[] prgmImages, int[] ppp, String s) {
        // TODO Auto-generated constructor stub
        firsttextview = prgmNameList;
        context = electronics;
        imageId = prgmImages;
        secondtextview = ppp;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        id = s;
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
        database db = new database(context);
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.programlist, null);
        holder.name = (TextView) rowView.findViewById(R.id.textView1);
        holder.price = (TextView) rowView.findViewById(R.id.textView2);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
        holder.btn = (Button) rowView.findViewById(R.id.button);

        holder.name.setText(firsttextview[position]);
        holder.img.setImageResource(imageId[position]);
        holder.price.setText(String.valueOf(secondtextview[position]));
        holder.btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                db.AddtoCart(id, firsttextview[position], String.valueOf(secondtextview[position]));
                Toast.makeText(context, firsttextview[position] + " Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }

}