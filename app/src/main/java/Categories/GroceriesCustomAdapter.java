package Categories;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lamaison.R;

public class GroceriesCustomAdapter extends BaseAdapter {

    String[] resultt;
    Context contextt;
    String[] subsss;
    int[] imageIdd;
    private static LayoutInflater inflater = null;

    public GroceriesCustomAdapter(Groceries groceries, String[] prgmNameList, int[] prgmImages, String[] ppp) {
        // TODO Auto-generated constructor stub
        resultt = prgmNameList;
        contextt = groceries;
        imageIdd = prgmImages;
        subsss = ppp;
        inflater = (LayoutInflater) contextt.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return resultt.length;
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
        TextView tv;
        ImageView img;
        TextView vv;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.programlist, null);
        holder.tv = (TextView) rowView.findViewById(R.id.textView1);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
        holder.vv = (TextView) rowView.findViewById(R.id.textView2);


        holder.tv.setText(resultt[position]);
        holder.img.setImageResource(imageIdd[position]);
        holder.vv.setText(subsss[position]);
        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(contextt, "You Clicked " + resultt[position], Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }

}