package be.uantwerpen.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import be.uantwerpen.models.Song;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

/**
 * Created by dries on 23/02/2017.
 */

@Controller
//@RestController
public class MusicController {
    public ArrayList<Song> allSongs = new ArrayList<Song>();
    Song[] songs;

    private String serverIp = "143.129.39.150";

    private int serverPort = 8080;

    @RequestMapping({"/", "/Music"})
    public String showHomepage(final ModelMap model)
    {
        allSongs.clear();
        allSongs.add(new Song(1, "Gives you hell", "The All-American Rejects"));
        allSongs.add(new Song(2, "Dirty Little secret", "The All-American Rejects"));
        allSongs.add(new Song(3, "Your Star", "The All-American Rejects"));
        allSongs.add(new Song(4, "Back in Black", "AC DC"));
        allSongs.add(new Song(5, "Sofia", "Alvaro Soler"));
        allSongs.add(new Song(6, "Keep your head up", "Andy Grammer"));
        allSongs.add(new Song(7, "What The Hell", "Avril Lavigne"));
        /*RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Song[]> responseList;
        responseList = restTemplate.getForEntity("http://" + ServerIp + ":" + serverPort +"/music/", Song[].class);
        songs = responseList.getBody();
        for(Song song: songs)
        {
            allSongs.add(song);
        }*/
        model.addAttribute("allSongs", allSongs.toArray());
        return "DJHomePage";
    }
}