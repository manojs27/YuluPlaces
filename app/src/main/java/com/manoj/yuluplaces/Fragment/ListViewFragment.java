package com.manoj.yuluplaces.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.manoj.yuluplaces.Adapter.PlacesListAdapter;
import com.manoj.yuluplaces.AppConfig;
import com.manoj.yuluplaces.Model.Places;
import com.manoj.yuluplaces.Model.Venues;
import com.manoj.yuluplaces.R;
import com.manoj.yuluplaces.RestClient.RestClientService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ListViewFragment extends Fragment {
    ListView listView;
    List<Venues> item_list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View lView = inflater.inflate(R.layout.list_fragment, container, false);
        listView = (ListView) lView.findViewById(R.id.listivew);
        return lView;
    }

    @Override
    public void onResume() {
        super.onResume();
        new PlacesAsyncTask().execute();
    }

    public class PlacesAsyncTask extends AsyncTask<Void, Void, List<Venues>> {
        @Override
        protected List<Venues> doInBackground(Void... voids) {
            RestClientService restClientService = RestClientService.retrofit.create(RestClientService.class);
            final Call<Places> call = restClientService.requestExplore(AppConfig.Client_ID, AppConfig.Client_Secret,
                    AppConfig.apiVersion, AppConfig.geoLocation);

            try {
                Places explore = call.execute().body();
                item_list = explore.getResponse().getVenues();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return item_list;
        }

        @Override
        protected void onPostExecute(List<Venues> item) {
            super.onPostExecute(item);
            PlacesListAdapter placesListAdapter = new PlacesListAdapter(getContext(), R.layout.item_list, item);
            listView.setAdapter(placesListAdapter);
        }
    }
}
