package com.rest.pojo.collection.newPojo;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Request {

   @SerializedName("url")
   String url;

   @SerializedName("method")
   String method;

   @SerializedName("header")
   List<Header> header;


    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    public String getMethod() {
        return method;
    }
    
    public void setHeader(List<Header> header) {
        this.header = header;
    }
    public List<Header> getHeader() {
        return header;
    }
    
}