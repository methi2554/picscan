package com.example.picscan;

public class Scan {
    private int id;
    private String ttstext;
    private byte[] image;

    public Scan(String ttstext,  byte[] image, int id) {
        this.ttstext = ttstext;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
