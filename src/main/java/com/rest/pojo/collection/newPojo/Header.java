package com.rest.pojo.collection.newPojo;

import com.google.gson.annotations.SerializedName;

   
public class Header {

   @SerializedName("key")
   String key;

   @SerializedName("value")
   String value;


    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    
}