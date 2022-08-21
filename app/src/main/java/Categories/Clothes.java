package Categories;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.GridView;

import com.example.lamaison.R;

public class Clothes extends Activity {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList = {"Adidas Bag", "Women handbag",
            "Oversize purple shirt", "Oversize grey T-shirt", "Black heels",
            "Gold heels", "Baggy pants", "Ripped jeans", "Les Deux", "Nasa Hoodie",
            "Adidas white shoes", "Adidas floral shoes"};
    public static int[] prgmImages = {R.drawable.bag1, R.drawable.bag2, R.drawable.tshirt,
            R.drawable.tshirt1, R.drawable.shoes, R.drawable.heels4, R.drawable.jeanse,
            R.drawable.jeanse1, R.drawable.hoodie2, R.drawable.hoodi5, R.drawable.adidas2,
            R.drawable.adidas};
    public static String[] prgmNameList2 = {"800 EGP", "900 EGP", "300 EGP", "350 EGP",
            "750 EGP", "1500 EGP", "500 EGP", "300 EGP", "600 EGP", "600 EGP", "900 EGP",
            "1000 EGP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        gv = (GridView) findViewById(R.id.gridView1);
        String x = (getIntent().getExtras().getString("homeid"));
        gv.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages, prgmNameList2, x) {
        });
    }


}