package com.rest.pojo.collection.newPojo;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Item {

   @SerializedName("name")
   String name;

   @SerializedName("event")
   List<Event> event;

   @SerializedName("request")
   Request request;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setEvent(List<Event> event) {
        this.event = event;
    }
    public List<Event> getEvent() {
        return event;
    }
    
    public void setRequest(Request request) {
        this.request = request;
    }
    public Request getRequest() {
        return request;
    }
    
}