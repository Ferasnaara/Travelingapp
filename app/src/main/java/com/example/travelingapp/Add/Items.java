package com.example.travelingapp.Add;
public class Items {
    private String HotelName;
    private String location;
    private String description;
    private int bed;
    private boolean guide;
    private String pic;
    private boolean wifi;
    private int price;
    public Items (String HotelName,String description,String location,int bed, boolean guide,double score,String pic, boolean wifi, int price)
    {
        this.HotelName=HotelName;
        this.location=location;
        this.description=description;
        this.bed=bed;
        this.guide=guide;
        this.pic=pic;
        this.wifi=wifi;
        this.price=price;

    }
    public String getHotelName(){
        return HotelName;
    }
    public void setHotelName(String HotelName){
        this.HotelName=HotelName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location){
        this.location=location;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public int getBed(){
        return bed;
    }
    public void setBed(int bed){
        this.bed=bed;
    }
    public boolean isGuide(){
        return guide;
    }
    public void setGuide(boolean guide){
        this.guide=guide;
    }
    public String getPic(){
        return pic;
    }
    public void setPic(String pic){this.pic=pic;}
    public boolean isWifi(){return wifi;}
    public void setWifi(boolean wifi){this.wifi=wifi;}
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }






}
