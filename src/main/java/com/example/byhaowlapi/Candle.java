package com.example.byhaowlapi;

import javax.persistence.*;

@Entity
public class Candle {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;
    @Column(length = 2000)
   private String fragranceNotes;
   @Column(length = 2000)
   private String description;
   private String burnTime;
   private String blend;
   private String scent;
   private String vessel;
   private String wick;
   private String dimension;
   private String colour;

    private Float price;

    private String img;

   public Candle(){
   }

   public Candle(Long id, Float price, String name, String fragranceNotes, String description, String burnTime, String blend, String scent, String vessel, String wick,String dimension, String colour, String img){
       this.id = id;
       this.price = price;
       this.name = name;
       this.fragranceNotes = fragranceNotes;
       this.description = description;
       this.burnTime = burnTime;
       this.blend = blend;
       this.scent = scent;
       this.vessel = vessel;
       this.wick = wick;
       this.dimension = dimension;
       this.colour = colour;
       this.img = img;
   }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFragranceNotes() {
        return fragranceNotes;
    }

    public void setFragranceNotes(String fragranceNotes) {
        this.fragranceNotes = fragranceNotes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBurnTime() {
        return burnTime;
    }

    public void setBurnTime(String burnTime) {
        this.burnTime = burnTime;
    }

    public String getBlend() {
        return blend;
    }

    public void setBlend(String blend) {
        this.blend = blend;
    }

    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    public String getWick() {
        return wick;
    }

    public void setWick(String wick) {
        this.wick = wick;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
