package com.sunnyweather.android.ui.place;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sunnyweather.android.R;
import com.sunnyweather.android.logic.model.Place;
import com.sunnyweather.android.ui.weather.WeatherActivity;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {
    PlaceFragment fragment;
    List<Place> placeList;

    public PlaceAdapter(PlaceFragment fragment, List<Place> placeList) {
        this.fragment = fragment;
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item, parent, false);
         ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.itemView.setOnClickListener(v -> {
            int adapterPosition = viewHolder.getAdapterPosition();
            Place place = placeList.get(adapterPosition);
            FragmentActivity acticity=fragment.getActivity();
            if (acticity instanceof WeatherActivity){
                DrawerLayout drawerLayout=acticity.findViewById(R.id.drawerLayout);
                drawerLayout.closeDrawers();
                ((WeatherActivity) acticity).getViewModel().setLocationLng(place.getLocation().getLng());
                ((WeatherActivity) acticity).getViewModel().setLocationLat(place.getLocation().getLat());
                ((WeatherActivity) acticity).getViewModel().setPlaceName(place.getName());
                ((WeatherActivity) acticity).refreshWeather();
            }else {
                Intent intent = new Intent(parent.getContext(), WeatherActivity.class);
                intent.putExtra("location_lng", place.getLocation().getLng());
                intent.putExtra("location_lat", place.getLocation().getLat());
                intent.putExtra("place_name", place.getName());
                fragment.startActivity(intent);
                fragment.getActivity().finish();//自己谁便加的
            }
            fragment.getViewModel().savePlace(place);
        });
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Place place = placeList.get(position);
        holder.placeName.setText(place.getName());
        holder.placeAddress.setText(place.getAddress());
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView placeName = itemView.findViewById(R.id.placeName);
        TextView placeAddress = itemView.findViewById(R.id.placeAddress);
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
