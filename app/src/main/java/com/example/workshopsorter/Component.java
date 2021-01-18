package com.example.workshopsorter;


public class Component {
    private String name;
    private String location;
    private String link;
    private String group;
    private int quantity;

    public Component(String nname){
        name=nname;
        location="";
        link="";
        group="";
        quantity=0;
    }
    public String getName() {
        return name;
    }
    public void setName(String x) {
        name=x;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }
    public void incrementQuantity(){
        quantity++;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void decrementQuantity(){
        quantity--;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
}
