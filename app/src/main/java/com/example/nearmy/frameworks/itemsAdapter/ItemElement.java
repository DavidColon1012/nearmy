package com.example.nearmy.frameworks.itemsAdapter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nearmy.R;
import com.example.nearmy.activities.MainActivity;
import com.example.nearmy.bean.Element;
import com.example.nearmy.fragments.ElementInfoFrament;

public class ItemElement extends RecyclerView.ViewHolder {

    private ImageView imv;

    public ItemElement(@NonNull View itemView) {
        super(itemView);
        imv = itemView.findViewById(R.id.imv);
    }

    public void bind(final MainActivity context, Element element) {
        imv.setImageBitmap(redimensionarImagenMaximo(element.getBtm(),250,250));
        imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = context.getSupportFragmentManager();
                ElementInfoFrament elementInfoFrament = ElementInfoFrament.newInstance();
                elementInfoFrament.show(fm, "elementInfoFrament");
            }
        });
    }

    private static Bitmap redimensionarImagenMaximo(Bitmap mBitmap, float newWidth, float newHeigth) {
        // Redimensionamos
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeigth) / height;
        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // matrix.postRotate(90);
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // recreate the new Bitmap
        return Bitmap.createBitmap(mBitmap, 0, 0, width, height, matrix, false);
    }
}
