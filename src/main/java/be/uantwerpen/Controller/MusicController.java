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
    BlackListController blackListController = new BlackListController();

    @RequestMapping({"/", "/Music"})
    public String showHomepage(final ModelMap model, HttpServletRequest request)
    {
        blackListController.updateBlacklist(request, 1);
        model.addAttribute("allSongs", allSongs.toArray());
        if(blackListController.checkBlackList(request))
        {
            return "shame";
        } else {
            return "DJHomePage";
        }
    }
}


