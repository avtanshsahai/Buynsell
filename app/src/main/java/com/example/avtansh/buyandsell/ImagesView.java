package com.example.avtansh.buyandsell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import com.example.avtansh.buyandsell.adapters.ImageAdapter;
import model.Offer;
import model.OfferManager;

public class ImagesView extends AppCompatActivity {

    private OfferManager manager = OfferManager.getInstance(this);
    private ListView imagesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_view);

        Bundle bundle = getIntent().getExtras();
        final long id = bundle.getLong("idOffer");
        Offer offer = manager.getOfferByID(id);
        ArrayList<byte[]> images = offer.getImages();

        ImageAdapter adapter = new ImageAdapter(this, images);
        imagesView = (ListView) findViewById(R.id.images_list_view);
        imagesView.setAdapter(adapter);
    }
}