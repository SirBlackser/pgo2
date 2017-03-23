package be.uantwerpen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dries on 23/02/2017.
 */
@CrossOrigin
@Controller
public class GraphController {
    BlackListController blackListController = new BlackListController();

    @RequestMapping({"/Graphs/{id}/"})
    public String showHomepage(@PathVariable Long id, ModelMap model, HttpServletRequest request)
    {
        blackListController.updateBlacklist(request, 0);
        //System.out.println("ID: " + id);
        if(blackListController.checkBlackList(request))
        {
            return "shame";
        } else {
            return "GraphPage";
        }
    }
}
