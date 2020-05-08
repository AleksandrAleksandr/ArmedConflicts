package com.example.armedconflicts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/acled/read?terms=accept")
    Call<Event> getEventById(@Query("data_id") int id);

    @GET("/acled/read?terms=accept&page=1&limit=10")
    Call<Event> getEventsByCountry(@Query("country") String country);

    @GET("/acled/read?terms=accept")
    Call<Event> getEventsByRegion(@Query("region") int region, @Query("year") int year, @Query("fatalities") int fatalities, @Query("fatalities_where") String where);

    @GET("/acled/read?terms=accept&event_date_where=>=")
    Call<Event> getEventsByRegionAndDate(@Query("region") int region, @Query("event_date") String date);
}
