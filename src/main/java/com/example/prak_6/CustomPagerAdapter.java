package com.example.prak_6;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

public class CustomPagerAdapter extends PagerAdapter {
    public static ArrayList<StoreFront.Product> prodData = new ArrayList<>(100);
    private boolean mForceReinstantiateItem = false;
    private LayoutInflater layoutInflater;
    private Context context;
    public CustomPagerAdapter(Context context, ArrayList<StoreFront.Product> prodData) {
        this.prodData = prodData;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = layoutInflater.from(context);
        View view = null;
        if (prodData.get(position).Count != 0) {
            view = layoutInflater.inflate(R.layout.page, container, false);
            TextView text = view.findViewById(R.id.text);
            TextView name = view.findViewById(R.id.name);
            TextView count = view.findViewById(R.id.count);
            TextView cost = view.findViewById(R.id.cost);
            name.setText(prodData.get(position).Name);
            text.setText(prodData.get(position).Text);
            count.setText(String.valueOf(prodData.get(position).Count));
            cost.setText(String.valueOf(prodData.get(position).Price));
        }
        else {
            view = layoutInflater.inflate(R.layout.nullpage, container, false);
            TextView name = view.findViewById(R.id.nameprod);
            name.setText(prodData.get(position).Name);
        }
        container.addView(view);
        return view;
    }
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
    @Override
    public int getCount() {
        return prodData.size();
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ConstraintLayout) object);
    }
    public int getItemPosition(Object object) {
         return POSITION_NONE;
    }

}
