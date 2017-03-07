package be.uantwerpen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dries on 23/02/2017.
 */
@CrossOrigin
@Controller
public class GraphController {
    @RequestMapping({"/Graphs"})
    public String showHomepage(ModelMap model)
    {
        return "GraphPage";
    }

    @RequestMapping({"/test"})
    public String test() {return "TestPage";}

    @RequestMapping({"/test1"})
    public String test1() {return "TestPage1";}
}
