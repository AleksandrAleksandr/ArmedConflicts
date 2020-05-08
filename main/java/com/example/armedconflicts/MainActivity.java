package com.example.armedconflicts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    TextView text4, text5, text6, text7, text8, text9;
    Event africaEvents;
    GoogleMap map;
    List<Marker> africaMarkers = new ArrayList<>();

    View window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text4 = findViewById(R.id.textView4);
        text5 = findViewById(R.id.textView5);
        text6 = findViewById(R.id.textView6);
        text7 = findViewById(R.id.textView7);
        text8 = findViewById(R.id.textView8);
        text9 = findViewById(R.id.textView9);

        window = getLayoutInflater().inflate(R.layout.custon_info_window, null);

//        NetworkService.getInstance()
//                .getJsonApi()
//                .getEventById(7064065)
//                .enqueue(new Callback<Event>() {
//                    @Override
//                    public void onResponse(Call<Event> call, Response<Event> response) {
//
//                        Event event = response.body();
//
//                        text2.setText(event.getData()[0].getCountry());
//                        text3.setText(event.getData()[0].getEvent_type());
//                        text4.setText(String.valueOf(event.getData()[0].getYear()));
//                        text5.setText(event.getData()[0].getLocation());
//                        text6.setText(String.valueOf(event.getData()[0].getLongitude()));
//                        text7.setText(String.valueOf(event.getData()[0].getLatitude()));
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<Event> call, Throwable t) {
//                        text1.setText("Error request1");
//                    }
//                });

//        NetworkService.getInstance()
//                .getJsonApi()
//                .getEventsByCountry("Brazil")
//                .enqueue(new Callback<Event>() {
//                    @Override
//                    public void onResponse(Call<Event> call, Response<Event> response) {
//                        Event events = response.body();
//
//                        //text6.setText(events.getData()[0].getLocation());
//                        //text7.setText(events.getData()[1].getLocation());
//                        text8.setText(events.getData()[2].getLocation());
//                        text9.setText(events.getData()[3].getLocation());
//                    }
//
//                    @Override
//                    public void onFailure(Call<Event> call, Throwable t) {
//                        text1.setText("Error request2");
//                    }
//                });

//        NetworkService.getInstance()
//                .getJsonApi()
//                .getEventsByRegion(2, 2020, 20, ">")
//                .enqueue(new Callback<Event>() {
//                    @Override
//                    public void onResponse(Call<Event> call, Response<Event> response) {
//                        africaEvents = response.body();
//                        text7.setText(africaEvents.getData()[0].getEvent_date());
//                        text9.setText(String.valueOf(africaEvents.getCount()));
//                        fillMap();
//                    }
//
//                    @Override
//                    public void onFailure(Call<Event> call, Throwable t) {
//                        text8.setText("africa error");
//                    }
//                });

        NetworkService.getInstance()
                .getJsonApi()
                .getEventsByRegionAndDate(2, "2020-04-23")
                .enqueue(new Callback<Event>() {
                    @Override
                    public void onResponse(Call<Event> call, Response<Event> response) {
                        africaEvents = response.body();
                        text9.setText(String.valueOf(africaEvents.getCount()));
                        fillMap();
                    }

                    @Override
                    public void onFailure(Call<Event> call, Throwable t) {
                        text8.setText("africa error");
                    }
                });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").build();
        db.eventDao().insertAll(africaEvents.getData());
        db.eventDao().

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                //render(marker, window);
                //return window;
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                render(marker, window);
                return window;
            }
        });

        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                int event_index = (Integer) marker.getTag();
                //intent.putExtra("event_date", africaEvents.getData()[event_index].getEvent_date())
                intent.putExtra("year", africaEvents.getData()[event_index].getYear());
                intent.putExtra("event_type", africaEvents.getData()[event_index].getEvent_type());
                intent.putExtra("sub_event_type", africaEvents.getData()[event_index].getSub_event_type());
                intent.putExtra("actor1", africaEvents.getData()[event_index].getActor1());
                intent.putExtra("actor2", africaEvents.getData()[event_index].getActor2());
                intent.putExtra("country", africaEvents.getData()[event_index].getCountry());
                intent.putExtra("location", africaEvents.getData()[event_index].getLocation());
                intent.putExtra("source", africaEvents.getData()[event_index].getSource());
                intent.putExtra("notes", africaEvents.getData()[event_index].getNotes());
                intent.putExtra("fatalities", africaEvents.getData()[event_index].getFatalities());
                startActivity(intent);
            }
        });
    }

    public void fillMap() {
        for (int i = 0; i < africaEvents.getCount(); i++) {
            LatLng marker = new LatLng(africaEvents.getData()[i].getLatitude(), africaEvents.getData()[i].getLongitude());
            //map.addMarker(new MarkerOptions().position(marker).title(String.valueOf(i)).flat(true)).setTag(i);
            Marker mark = map.addMarker(new MarkerOptions()
                    .position(marker)
                    .title(africaEvents.getData()[i].getLocation())
                    .snippet(africaEvents.getData()[i].getEvent_date()));

            mark.setTag(i);

            if (africaEvents.getData()[i].getEvent_type().equals("Battles"))
                mark.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
            else
                mark.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

            africaMarkers.add(mark);
        }
    }

    public void render(Marker marker, View view){
        int badge;

        int marker_id = (Integer) marker.getTag();
        if (africaEvents.getData()[marker_id].getEvent_type().equals("Battles"))
            badge = R.drawable.helm;
        else badge = 0;

        ((ImageView) view.findViewById(R.id.badge)).setImageResource(badge);

        String title = marker.getTitle();
        TextView titleUi = view.findViewById(R.id.title);
        if (title != null)
            titleUi.setText(title);
        else
            titleUi.setText("");

        String snippet = marker.getSnippet();
        TextView snippetUi = view.findViewById(R.id.snippet);
        if (snippet != null) {
            snippetUi.setText(snippet);
        } else {
            snippetUi.setText("");
        }
    }
}
