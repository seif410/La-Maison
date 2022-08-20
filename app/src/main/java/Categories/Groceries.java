package Categories;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.GridView;

import com.example.lamaison.R;

public class Groceries extends Activity {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList3 = {"Cucumber 1kg", "Eggs 30pcs",
            "Flour 1kg", "Green Apples 1kg", "Milk 1L",
            "Spaghetti 500g ", "Tomato 1kg", "Penne 500g", "Red Pepper 1kg", "Lipton tea pack",
            "Persil 3L", "Sunshine tuna"};
    public static int[] prgmImages3 = {R.drawable.cucumber, R.drawable.egg, R.drawable.flour,
            R.drawable.greenapple, R.drawable.milk, R.drawable.pasta, R.drawable.tomato,
            R.drawable.penne1, R.drawable.pepper, R.drawable.tea, R.drawable.persil,
            R.drawable.tuna1
    };
    public static String[] prgmNameList4 = {"10", "55", "25", "30",
            "20", "10", "9", "25", "30", "300", "30",
            "25"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);
        gv = (GridView) findViewById(R.id.gridView2);
        String x = (getIntent().getExtras().getString("homeid"));
        gv.setAdapter(new CustomAdapter(this, prgmNameList3, prgmImages3, prgmNameList4, x) {
        });
    }


}