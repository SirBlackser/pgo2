package be.uantwerpen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Revil on 01/03/2017.
 */
@CrossOrigin
@Controller
//@RestController
public class StatsController {
    @RequestMapping({"/Stats"})
    public String showHomepage(ModelMap model)
    {
        return "StatsPage";
    }
}
