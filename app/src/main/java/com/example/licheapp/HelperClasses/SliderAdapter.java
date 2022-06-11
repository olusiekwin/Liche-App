package com.example.licheapp.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.licheapp.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[] = {

            R.drawable.connect,
            R.drawable.interact_with_friends,
            R.drawable.share_art,
            R.drawable.enjoy_your_art
    };

    int headings[] = {
          R.string.first_slide_title,
          R.string.second_slide_title,
          R.string.third_slide_title,
          R.string.fourth_slide_title
    };

    int descriptions[] = {
            R.string.first_slide_description,
            R.string.second_slide_description,
            R.string.third_slide_description,
            R.string.fourth_slide_description
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layouts, (ViewGroup) container, false);

        //hooks
        ImageView  imageView = view.findViewById(R.id.slide_image);
        TextView heading = view.findViewById(R.id.slider_heading);
        TextView description = view.findViewById(R.id.slider_desc);

        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        description.setText(descriptions[position]);

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
