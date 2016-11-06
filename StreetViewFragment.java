package com.example.chiwaura.blesscoffee;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by  Engineer CHIWAURA on 10/24/2016.
 */
public class StreetViewFragment extends SupportStreetViewPanoramaFragment {
    public static final StreetViewFragment newInstance(double latitude, double longitude){
        Bundle args = new Bundle();
        args.putDouble("latitude", latitude);
                args.putDouble("longitude", longitude);

        StreetViewFragment fragment =  new StreetViewFragment();
        fragment.setArguments(args);
        return fragment;



    }


}