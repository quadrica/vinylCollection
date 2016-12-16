package com.lehtarec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Created by PENGUIN on 21.11.2016.
 */
@Entity
public class Release {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String title, artist, imgurl;

    public Release()
    {}
    
    public Release(String title, String artist, String imgurl) {
        super();
        this.title = title;
        this.artist = artist;
        this.imgurl = imgurl;
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public String getImgurl() {
        return imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    

    @Override
    public String toString() {
        return String.format(
                "Release[id=%d, title='%s', artist='%s']",
                id, title, artist);
    }
}
