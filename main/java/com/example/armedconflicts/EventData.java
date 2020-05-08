package com.example.armedconflicts;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EventData {

    @PrimaryKey
    private int data_id;
    private int year;
    private String event_type;
    private String country;

    private String notes;

    private int iso;

    private String event_id_cnty;

    private String event_id_no_cnty;

    private String source;

    private String sub_event_type;

    private int time_precision;

    private int geo_precision;

    private int inter1;

    private int inter2;

    private String source_scale;

    private String assoc_actor_1;

    private String assoc_actor_2;

    private String actor2;

    private String actor1;

    private int fatalities;

    private int interaction;

    private String admin1;

    private String admin2;

    private String location;

    private String region;

    private String admin3;

    private Double latitude;

    private Double longitude;

    private String event_date;

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }
//private DateFormat event_date;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getData_id() {
        return data_id;
    }

    public void setData_id(int data_id) {
        this.data_id = data_id;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getIso() {
        return iso;
    }

    public void setIso(int iso) {
        this.iso = iso;
    }

    public String getEvent_id_cnty() {
        return event_id_cnty;
    }

    public void setEvent_id_cnty(String event_id_cnty) {
        this.event_id_cnty = event_id_cnty;
    }

    public String getEvent_id_no_cnty() {
        return event_id_no_cnty;
    }

    public void setEvent_id_no_cnty(String event_id_no_cnty) {
        this.event_id_no_cnty = event_id_no_cnty;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSub_event_type() {
        return sub_event_type;
    }

    public void setSub_event_type(String sub_event_type) {
        this.sub_event_type = sub_event_type;
    }

    public int getTime_precision() {
        return time_precision;
    }

    public void setTime_precision(int time_precision) {
        this.time_precision = time_precision;
    }

    public int getGeo_precision() {
        return geo_precision;
    }

    public void setGeo_precision(int geo_precision) {
        this.geo_precision = geo_precision;
    }

    public int getInter1() {
        return inter1;
    }

    public void setInter1(int inter1) {
        this.inter1 = inter1;
    }

    public int getInter2() {
        return inter2;
    }

    public void setInter2(int inter2) {
        this.inter2 = inter2;
    }

    public String getSource_scale() {
        return source_scale;
    }

    public void setSource_scale(String source_scale) {
        this.source_scale = source_scale;
    }

    public String getAssoc_actor_1() {
        return assoc_actor_1;
    }

    public void setAssoc_actor_1(String assoc_actor_1) {
        this.assoc_actor_1 = assoc_actor_1;
    }

    public String getAssoc_actor_2() {
        return assoc_actor_2;
    }

    public void setAssoc_actor_2(String assoc_actor_2) {
        this.assoc_actor_2 = assoc_actor_2;
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    public int getFatalities() {
        return fatalities;
    }

    public void setFatalities(int fatalities) {
        this.fatalities = fatalities;
    }

    public int getInteraction() {
        return interaction;
    }

    public void setInteraction(int interaction) {
        this.interaction = interaction;
    }

    public String getAdmin1() {
        return admin1;
    }

    public void setAdmin1(String admin1) {
        this.admin1 = admin1;
    }

    public String getAdmin2() {
        return admin2;
    }

    public void setAdmin2(String admin2) {
        this.admin2 = admin2;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAdmin3() {
        return admin3;
    }

    public void setAdmin3(String admin3) {
        this.admin3 = admin3;
    }
}
