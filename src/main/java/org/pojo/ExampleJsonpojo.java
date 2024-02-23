package org.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExampleJsonpojo {
    @SerializedName("id")
    String id;

    @SerializedName("type")
    String type;

    @SerializedName("name")
    String name;

    @SerializedName("ppu")
    double ppu;

    @SerializedName("batters")
    Batters batters;

    @SerializedName("topping")
    List<Topping> topping;


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

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPpu(double ppu) {
        this.ppu = ppu;
    }
    public double getPpu() {
        return ppu;
    }

    public void setBatters(Batters batters) {
        this.batters = batters;
    }
    public Batters getBatters() {
        return batters;
    }

    public void setTopping(List<Topping> topping) {
        this.topping = topping;
    }
    public List<Topping> getTopping() {
        return topping;
    }

}
