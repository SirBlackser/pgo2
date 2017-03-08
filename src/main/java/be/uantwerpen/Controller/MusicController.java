package be.uantwerpen.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import be.uantwerpen.models.Song;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by dries on 23/02/2017.
 */

@CrossOrigin
@Controller
//@RestController
public class MusicController {
    public ArrayList<Song> allSongs = new ArrayList<Song>();
    Song[] songs;

    @RequestMapping({"/", "/Music"})
    public String showHomepage(final ModelMap model)
    {
        allSongs.clear();
        allSongs.add(new Song("Gives you hell", "The All-American Rejects"));
        allSongs.add(new Song("Dirty Little secret", "The All-American Rejects"));
        allSongs.add(new Song("Your Star", "The All-American Rejects"));
        allSongs.add(new Song("Back in Black", "AC DC"));
        allSongs.add(new Song("Sofia", "Alvaro Soler"));
        allSongs.add(new Song("Keep your head up", "Andy Grammer"));
        allSongs.add(new Song("What The Hell", "Avril Lavigne"));
        /*RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Song[]> responseList;
        responseList = restTemplate.getForEntity(/*link hier*//*, Song[].class);
        songs = responseList.getBody();
        for(Song song: songs)
        {
            allSongs.add(song);
        }*/
        model.addAttribute("allSongs", allSongs.toArray());
        return "DJHomePage";
    }
}


