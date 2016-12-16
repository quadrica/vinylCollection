package com.lehtarec.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by PENGUIN on 13.12.2016.
 */
public class ReleaseForm {
    @NotEmpty
    @Size(max=50)
    private String artist = "";

    @NotEmpty
    @Size(max=50)
    private String title = "";

    @NotEmpty
    @Size(min=15, max=255)
    private String imgurl = "";

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }


}
