package com.rest.pojo.collection.newPojo;

import com.google.gson.annotations.SerializedName;

   
public class ExampleJson2KtPOJO {

   @SerializedName("collection")
   Collection collection;


    public void setCollection(Collection collection) {
        this.collection = collection;
    }
    public Collection getCollection() {
        return collection;
    }
    
}