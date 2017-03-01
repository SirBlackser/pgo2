package be.uantwerpen.models;

/**
 * Created by dries on 25/02/2017.
 */
public class Song {
    private int IDmarker;
    private String title;
    private String artist;

    public Song(int IDmarker, String title, String artist)
    {
        this.IDmarker = IDmarker;
        this.title = title;
        this.artist = artist;
    }

    public int getIDmarker() {
        return IDmarker;
    }

    public void setIDmarker(int IDmarker) {
        this.IDmarker = IDmarker;
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
}
