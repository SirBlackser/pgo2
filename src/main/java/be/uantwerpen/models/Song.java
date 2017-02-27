package be.uantwerpen.models;

/**
 * Created by dries on 25/02/2017.
 */
public class Song {
    private String songName;
    private String artist;

    public Song(String songName, String artist)
    {
        this.songName = songName;
        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
