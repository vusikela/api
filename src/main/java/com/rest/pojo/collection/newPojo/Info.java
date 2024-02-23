package com.rest.pojo.collection.newPojo;

import com.google.gson.annotations.SerializedName;

   
public class Info {

   @SerializedName("name")
   String name;

   @SerializedName("description")
   String description;

   @SerializedName("schema")
   String schema;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    
    public void setSchema(String schema) {
        this.schema = schema;
    }
    public String getSchema() {
        return schema;
    }
    
}