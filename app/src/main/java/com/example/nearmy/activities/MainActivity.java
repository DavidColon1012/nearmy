package com.example.nearmy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.example.nearmy.R;
import com.example.nearmy.bean.Category;
import com.example.nearmy.bean.Element;
import com.example.nearmy.fragments.FiltreFrament;
import com.example.nearmy.fragments.RecommendationFrament;
import com.example.nearmy.frameworks.adapters.CategoryAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        context = this;

        RecyclerView rlvCategories = findViewById(R.id.rlvCategories);
        rlvCategories.setLayoutManager(new LinearLayoutManager(context));


        Category category1 = new Category();
        category1.setTitle("Me eventos");

        Category category2 = new Category();
        category2.setTitle("Mis lugares");

        Category category3 = new Category();
        category3.setTitle("Barranquilla");

        Bitmap bImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.element);


        ArrayList<Element> elementCategories2 = new ArrayList<>();
        Element element4 = new Element();
        element4.setBtm(bImage);
        elementCategories2.add(element4);
        elementCategories2.add(element4);
        elementCategories2.add(element4);
        elementCategories2.add(element4);

        Category category4 = new Category();
        category4.setEvento(true);
        category4.setListElements(elementCategories2);

        Element element = new Element();
        element.setBtm(bImage);

        Element element2 = new Element();
        element2.setBtm(bImage);

        Element element3 = new Element();
        element3.setBtm(bImage);

        ArrayList<Element> elementCategories = new ArrayList<>();
        elementCategories.add(element);
        elementCategories.add(element2);
        elementCategories.add(element3);


        category1.setListElements(elementCategories);
        category2.setListElements(elementCategories);
        category3.setListElements(elementCategories);


        ArrayList<Category> data = new ArrayList<>();
        data.add(category4);
        data.add(category1);
        data.add(category2);
        data.add(category3);

        rlvCategories.setAdapter(new CategoryAdapter(MainActivity.this, data));

    }

    public void goToFilter(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FiltreFrament filtreFrament = FiltreFrament.newInstance();
        filtreFrament.setCancelable(false);
        filtreFrament.show(fm, "filtreFrament");
    }

    public void goToRecommendation(View view) {
        FragmentManager fm = getSupportFragmentManager();
        RecommendationFrament recommendationFrament = RecommendationFrament.newInstance();
        recommendationFrament.setCancelable(false);
        recommendationFrament.show(fm, "recommendationFrament");
    }
}
