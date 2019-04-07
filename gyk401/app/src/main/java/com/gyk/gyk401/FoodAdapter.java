package com.gyk.gyk401;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private List<Food> foodList;
    private LayoutInflater layoutInflater;

    public FoodAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.layoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;
        row_view = layoutInflater.inflate(R.layout.custom_row_layout,null);
        ImageView imageViewFood = (ImageView) row_view.findViewById(R.id.imageViewFood);
        TextView textViewFoodName = (TextView) row_view.findViewById(R.id.textViewFoodName);
        TextView textViewFoodCal = (TextView) row_view.findViewById(R.id.textViewFoodCal);

        Food food = foodList.get(i);
        Picasso.get().load(food.getPhotoUrl()).into(imageViewFood);
        textViewFoodName.setText(food.getName());
        textViewFoodCal.setText(food.getCal()+" /Cal");

        return row_view;
    }
}
