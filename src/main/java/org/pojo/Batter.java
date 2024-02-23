package org.pojo;

import com.google.gson.annotations.SerializedName;

public class Batter {
    @SerializedName("id")
    String id;

    @SerializedName("type")
    String type;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

}
