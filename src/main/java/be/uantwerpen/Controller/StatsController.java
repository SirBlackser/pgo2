package be.uantwerpen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Revil on 01/03/2017.
 */
@CrossOrigin
@Controller
//@RestController
public class StatsController {
    BlackListController blackListController = new BlackListController();

    @RequestMapping({"/Stats"})
    public String showHomepage(ModelMap model, HttpServletRequest request)
    {
        blackListController.updateBlacklist(request, 2);
        if(blackListController.checkBlackList(request))
        {
            return "shame";
        } else {
            return "StatsPage";
        }
    }
}
