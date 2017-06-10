package be.uantwerpen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import be.uantwerpen.models.Song;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

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


