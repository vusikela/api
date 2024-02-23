package com.rest.pojo.collection.newPojo;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Script {

   @SerializedName("id")
   String id;

   @SerializedName("exec")
   List<String> exec;

   @SerializedName("type")
   String type;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    
    public void setExec(List<String> exec) {
        this.exec = exec;
    }
    public List<String> getExec() {
        return exec;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    
}