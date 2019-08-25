package com.manoj.yuluplaces.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.manoj.yuluplaces.AppConfig;
import com.manoj.yuluplaces.Model.Places;
import com.manoj.yuluplaces.Model.Venues;
import com.manoj.yuluplaces.R;
import com.manoj.yuluplaces.RestClient.RestClientService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class MapViewFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private MapView mMapView;
    List<LatLng> latLngList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View lView = inflater.inflate(R.layout.map_fragment, container, false);
        mMapView = (MapView) lView.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        setupMap();
        return lView;
    }

    private void setupMap() {
        mMapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (int i = 0; i < latLngList.size(); i++) {
            mMap.addMarker(new MarkerOptions().position(latLngList.get(i)).title("Marker" + i));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngList.get(i)));
        }
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 15.0f ) );
    }


    @Override
    public void onResume() {
        super.onResume();
        new PlacesAsyncTask().execute();
        if (mMapView != null) {
            mMapView.onResume();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMapView != null)
            mMapView.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mMapView != null)
            mMapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mMapView != null)
            mMapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mMapView != null)
            mMapView.onSaveInstanceState(outState);
    }

    public class PlacesAsyncTask extends AsyncTask<Void, Void, List<LatLng>> {
        @Override
        protected List<LatLng> doInBackground(Void... voids) {
            RestClientService restClientService = RestClientService.retrofit.create(RestClientService.class);
            final Call<Places> call = restClientService.requestExplore(AppConfig.Client_ID, AppConfig.Client_Secret,
                    AppConfig.apiVersion, AppConfig.geoLocation);

            try {
                Places places = call.execute().body();
                parseLatLong(places);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return latLngList;
        }

        @Override
        protected void onPostExecute(List<LatLng> locations) {
            super.onPostExecute(locations);
            setupMap();
        }
    }

    private void parseLatLong(Places places) {
        List<Venues> venues = places.getResponse().getVenues();
        for (int i = 0; i < venues.size(); i++) {
            double lat = Double.parseDouble(venues.get(i).getLocation().getLat());
            double lng = Double.parseDouble(venues.get(i).getLocation().getLng());
            LatLng latLng = new LatLng(lat, lng);
            latLngList.add(latLng);
        }
    }
}
