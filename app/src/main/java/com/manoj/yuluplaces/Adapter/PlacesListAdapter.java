package com.manoj.yuluplaces.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.manoj.yuluplaces.Model.Venues;
import com.manoj.yuluplaces.R;

import java.util.List;

public class PlacesListAdapter extends ArrayAdapter<Venues> {
    private LayoutInflater layoutInflater;

    private static class ViewHolder {
        TextView name;
        TextView address;
        TextView city;
    }

    public PlacesListAdapter(Context context, int layout, List<Venues> objects) {
        super(context, layout, objects);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Venues item = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.item_name);
            viewHolder.address = (TextView) convertView.findViewById(R.id.item_address);
            viewHolder.city = (TextView) convertView.findViewById(R.id.item_city);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String name = item.getName();
        String address = item.getLocation().getAddress() != null ? item.getLocation().getAddress() : "Address Not " +
                "Availble";
        String city = item.getLocation().getCity() != null ? item.getLocation().getCity() : "City Not Availble";
        viewHolder.name.setText(name);
        viewHolder.address.setText(address);
        viewHolder.city.setText(city);
        return convertView;
    }
}