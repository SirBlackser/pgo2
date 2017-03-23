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

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    Map<String, ArrayList<Long>> IpList = new HashMap<String, ArrayList<Long>>();
    List<String> blackList = new ArrayList<>();

    @RequestMapping({"/", "/Music"})
    public String showHomepage(final ModelMap model, HttpServletRequest request)
    {
        String ip = request.getRemoteAddr();
        if(!IpList.containsKey(ip))
        {
            long timeStamp = System.currentTimeMillis();
            System.out.println("initial timestamp: " + timeStamp);
            ArrayList<Long> data = new ArrayList<>();
            data.add(timeStamp);
            Long requestNumber = new Long(1);
            data.add(requestNumber);
            IpList.put(ip, data);
        } else {
            long timeStamp = System.currentTimeMillis();
            //10 seconds
            if(timeStamp-IpList.get(ip).get(0) < 10000)
            {
                System.out.println("time between request: " + (timeStamp- IpList.get(ip).get(0)));
                Long requestNumber = IpList.get(ip).get(1);
                requestNumber = requestNumber+1;
                System.out.println("request omhoog: " + requestNumber);
                IpList.get(ip).remove(1);
                IpList.get(ip).add(requestNumber);
                if(requestNumber>10 && !blackList.contains(ip))
                {
                    blackList.add(ip);
                    System.out.println("add to blacklist: " + ip);
                }
            } else {
                if(blackList.contains(ip)) {
                    blackList.remove(ip);
                    System.out.println("remove from blacklist: " + ip);
                }
                Long requestNumber = new Long(1);
                IpList.get(ip).clear();
                IpList.get(ip).add(timeStamp);
                IpList.get(ip).add(requestNumber);
                System.out.println("reset list with timestamp: " + timeStamp + " and request: " + requestNumber);
            }
        }
        //System.out.println(ip);
        /*allSongs.clear();
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
        if(blackList.contains(ip))
        {
            return "shame";
        } else {
            return "DJHomePage";
        }
    }
}


