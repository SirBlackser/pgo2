package be.uantwerpen.Controller;

import be.uantwerpen.models.Song;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dries on 1/03/2017.
 */
@RestController
public class RestMusicController {

    public ArrayList<Song> allSongs = new ArrayList<Song>();

    @RequestMapping("/getMusic")
    public List<Song> getSongs(){

        allSongs.clear();
        allSongs.add(new Song("Gives you hell", "The All-American Rejects"));
        allSongs.add(new Song("Dirty Little secret", "The All-American Rejects"));
        allSongs.add(new Song("Your Star", "The All-American Rejects"));
        allSongs.add(new Song("Back in Black", "AC DC"));
        allSongs.add(new Song("Sofia", "Alvaro Soler"));
        allSongs.add(new Song("Keep your head up", "Andy Grammer"));
        allSongs.add(new Song("What The Hell", "Avril Lavigne"));

        return allSongs;
    }


}
