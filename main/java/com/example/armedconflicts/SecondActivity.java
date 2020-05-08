package com.example.armedconflicts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView year, event_type, sub_event_type, actor1, actor2, country, location, source, notes, fatalities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViews();
        setInfo();
    }

    public void findViews() {
        year = findViewById(R.id.year);
        event_type = findViewById(R.id.event_type);
        sub_event_type = findViewById(R.id.sub_event_type);
        actor1 = findViewById(R.id.actor1);
        actor2 = findViewById(R.id.actor2);
        country = findViewById(R.id.country);
        location = findViewById(R.id.location);
        source = findViewById(R.id.source);
        notes = findViewById(R.id.notes);
        fatalities = findViewById(R.id.fatalities);
    }
    
    public void setInfo() {
        Intent parent = getIntent();

        year.setText("Year " + String.valueOf(parent.getIntExtra("year", 0)));
        event_type.setText("Event_type " + parent.getStringExtra("event_type"));
        sub_event_type.setText("Sub_event_type " + parent.getStringExtra("sub_event_type"));
        actor1.setText("Actor1 " + parent.getStringExtra("actor1"));
        actor2.setText("Actor2 " + parent.getStringExtra("actor2"));
        country.setText("Country " + parent.getStringExtra("country"));
        location.setText("Location " + parent.getStringExtra("location"));
        source.setText("Source " + parent.getStringExtra("source"));
        notes.setText("Notes " + parent.getStringExtra("notes"));
        fatalities.setText("Fatalities " + String.valueOf(parent.getIntExtra("fatalities", 0)));
    }
}
