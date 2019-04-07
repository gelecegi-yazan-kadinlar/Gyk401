package com.gyk.gyk401;

public class Food {
    private String photoUrl;
    private String name;
    private String cal;

    public Food() {
    }

    public Food(String photoUrl, String name, String cal) {
        this.photoUrl = photoUrl;
        this.name = name;
        this.cal = cal;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }
}
