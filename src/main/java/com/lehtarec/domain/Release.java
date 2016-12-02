package com.lehtarec.domain;

/**
 * Created by PENGUIN on 21.11.2016.
 */
public class Release {
    private long id;
    private String title, artist;

    public Release(long id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String firstName) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return String.format(
                "Release[id=%d, title='%s', artist='%s']",
                id, title, artist);
    }
}
