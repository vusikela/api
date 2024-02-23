package com.rest.pojo.collection.newPojo;

import com.google.gson.annotations.SerializedName;

   
public class Event {

   @SerializedName("listen")
   String listen;

   @SerializedName("script")
   Script script;


    public void setListen(String listen) {
        this.listen = listen;
    }
    public String getListen() {
        return listen;
    }
    
    public void setScript(Script script) {
        this.script = script;
    }
    public Script getScript() {
        return script;
    }
    
}