package be.uantwerpen.be;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dries on 23/02/2017.
 */

@Controller
public class PageController {
    @RequestMapping({"/"})
    public String showHomepage(ModelMap model)
    {
        return "DJHomePage";
    }
}
