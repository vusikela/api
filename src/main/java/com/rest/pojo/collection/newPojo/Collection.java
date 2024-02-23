package com.rest.pojo.collection.newPojo;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Collection {

   @SerializedName("info")
   Info info;

   @SerializedName("item")
   List<Item> item;


    public void setInfo(Info info) {
        this.info = info;
    }
    public Info getInfo() {
        return info;
    }
    
    public void setItem(List<Item> item) {
        this.item = item;
    }
    public List<Item> getItem() {
        return item;
    }
    
}