package org.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Batters {
    @SerializedName("batter")
    List<Batter> batter;


    public void setBatter(List<Batter> batter) {
        this.batter = batter;
    }

    public List<Batter> getBatter() {
        return batter;
    }

}
