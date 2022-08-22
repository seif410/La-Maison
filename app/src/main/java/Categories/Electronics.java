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
    public static String[] prgmNameList5 = {"Logitech Mouse", "Xiaomi Airpods",
            "WB 2TB", "Samsung A12",
            "iPhone 13 Pro", "Samsung A52", "Xiaomi Note 10",
            "Samsung 32 Inch HDTV", "Samsung 50 Inch", "LG UHD 55 Inch",
            "LG 43 Inch FHD TV", "BOYA Microphone"};

    public static int[] prgmImages4 = {R.drawable.mouse, R.drawable.airpods, R.drawable.hard,
            R.drawable.phone1, R.drawable.phone2, R.drawable.phone3, R.drawable.phone4,
            R.drawable.samsung, R.drawable.tv2, R.drawable.tv4, R.drawable.tv3, R.drawable.mircro};

    public static int[] prgmNameList6 = {171, 350, 1199, 4850, 29640,
            8770, 6199, 4299, 9499, 9699, 5499, 256};

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
