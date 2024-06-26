package com.example.travelingapp;

public class Traveling {
    private String Name;
    private String description;
    private String address;
    private String phone;

    public Traveling() {
    }

    public Traveling(String Name, String description, String address, String phone) {
        this.Name = Name;
        this.description = description;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(Traveling description) {
        this.description = String.valueOf(description);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + Name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
