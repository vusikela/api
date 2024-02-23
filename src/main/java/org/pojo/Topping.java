package org.pojo;

import com.google.gson.annotations.SerializedName;

public class Topping {

    @SerializedName("id")
    String id;

    @SerializedName("type")
    String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
