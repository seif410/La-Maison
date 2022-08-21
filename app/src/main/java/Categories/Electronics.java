package Categories;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.GridView;

import com.example.lamaison.R;

public class Electronics extends Activity {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList5 = {"Logitech Mouse", "Xiaomi Airpods",
            "WB 2TB", "Samsung A12",
            "iPhone 13 Pro", "Samsung A52", "Xiaomi Note 10",
            "Samsung 32 Inch HDTV", "Samsung 50 Inch UHD", "LG UHD 55 Inch",
            "LG 43 Inch FHD TV", "BOYA Microphone"};

    public static int[] prgmImages4 = {R.drawable.mouse, R.drawable.airpods, R.drawable.hard,
            R.drawable.phone1, R.drawable.phone2, R.drawable.phone3, R.drawable.phone4,
            R.drawable.samsung, R.drawable.tv2, R.drawable.tv4, R.drawable.tv3, R.drawable.mircro};

    public static String[] prgmNameList6 = {"171 EGP", "350 EGP", "1,199 EGP", "4,850 EGP", "29,640 EGP",
            "8,770 EGP", "6,199 EGP", "4,299 EGP", "9,499 EGP", "9,699 EGP", "5,499 EGP", "256 EGP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);
        gv = (GridView) findViewById(R.id.gridView3);
        String x = (getIntent().getExtras().getString("homeid"));
        gv.setAdapter(new CustomAdapter(this, prgmNameList5, prgmImages4, prgmNameList6, x) {
        });
    }
}
