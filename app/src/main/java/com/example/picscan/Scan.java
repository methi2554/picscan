package com.example.picscan;

public class Scan {
    private int id;
    private String  rating;
    private String ttstext;
    private byte[] image;

    public Scan(String ttstext, String rating , byte[] image, int id) {
        this.ttstext = ttstext;
        this.image = image;
        this.id = id;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTtsText() {
        return ttstext;
    }

    public void setTtsText(String ttstext) {
        this.ttstext = ttstext;
    }


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
