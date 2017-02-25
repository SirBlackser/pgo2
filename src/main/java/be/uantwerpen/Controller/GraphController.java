package be.uantwerpen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dries on 23/02/2017.
 */

@Controller
public class GraphController {
    @RequestMapping({"/Graphs"})
    public String showHomepage(ModelMap model)
    {
        return "GraphPage";
    }
}
