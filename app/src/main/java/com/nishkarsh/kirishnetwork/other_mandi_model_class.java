package com.nishkarsh.kirishnetwork;

public class other_mandi_model_class {
   private String crop_id,hindi_name,image,last_date,market,meters,state,url_str,location,district;
   private int district_id,id;
   private double lat ,lon,km,met;

    public other_mandi_model_class(String crop_id,String district,int district_id,String hindi_name,int id,String image,double km,String last_date,
        double lat,double lon,String location,String market,double met,String state,String url_str){
    this.crop_id=crop_id;
    this.district=district;
    this.district_id=district_id;
    this.hindi_name=hindi_name;
    this.image=image;
    this.id=id;
    this.km=km;
    this.last_date=last_date;
    this.lat=lat;
    this.lon=lon;
    this.location=location;
    this.market=market;
    this.met=met;
    this.state=state;
    this.url_str=url_str;



    }

    public String getCrop_id() {
        return crop_id;
    }

    public void setCrop_id(String crop_id) {
        this.crop_id = crop_id;
    }

    public String getHindi_name() {
        return hindi_name;
    }

    public void setHindi_name(String hindi_name) {
        this.hindi_name = hindi_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLast_date() {
        return last_date;
    }

    public void setLast_date(String last_date) {
        this.last_date = last_date;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMeters() {
        return meters;
    }

    public void setMeters(String meters) {
        this.meters = meters;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl_str() {
        return url_str;
    }

    public void setUrl_str(String url_str) {
        this.url_str = url_str;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getMet() {
        return met;
    }

    public void setMet(double met) {
        this.met = met;
    }
}

