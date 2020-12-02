package com.moringaschool.wishabook.Model;

public class Author {

    Integer id;
    int imageUrl;
    String aurthorName;

    public String getAurthorName() {
        return aurthorName;
    }

    public void setAurthorName(String aurthorName) {
        this.aurthorName = aurthorName;
    }

    public Author(String aurthorName) {
        this.aurthorName = aurthorName;
    }

    public Author(Integer id, int imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
