package com.example.licheapp.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.licheapp.HelperClasses.HomeAdapter.FeatureAdapter;
import com.example.licheapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.licheapp.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {

    RecyclerView featuredRecyclers;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecyclers = findViewById(R.id.featured_recyclers);
        featuredRecyclers();
    }

    private void featuredRecyclers() {

        featuredRecyclers.setHasFixedSize(true);
        featuredRecyclers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false
        ));


        ArrayList<FeaturedHelperClass> featuredArtwork = new ArrayList<>();

        featuredArtwork.add(new FeaturedHelperClass(R.drawable.vbk, "Music Art", "Vybz Kartel, Jamaican Singer Currently Serving in Prison Announces A New Album Release."));
        featuredArtwork.add(new FeaturedHelperClass(R.drawable.city2, "City", "Vybz Kartel, Jamaican Singer Currently Serving in Prison Announces A New Album Release."));
        featuredArtwork.add(new FeaturedHelperClass(R.drawable.plane, "Traveling", "Vybz Kartel, Jamaican Singer Currently Serving in Prison Announces A New Album Release."));
        featuredArtwork.add(new FeaturedHelperClass(R.drawable.wall2, "Interior Design", "Vybz Kartel, Jamaican Singer Currently Serving in Prison Announces A New Album Release."));


        adapter = new FeatureAdapter(featuredArtwork);
        featuredRecyclers.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }
}