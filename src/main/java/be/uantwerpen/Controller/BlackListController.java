package be.uantwerpen.Controller;

import be.uantwerpen.models.Song;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dries on 23/03/2017.
 */
public class BlackListController {
    public ArrayList<Song> allSongs = new ArrayList<Song>();
    Song[] songs;
    Map<String, ArrayList<Long>> IpList = new HashMap<String, ArrayList<Long>>();
    List<String> blackList = new ArrayList<>();
    int previousPage = -1;

    public void updateBlacklist(HttpServletRequest request, int page)
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
            //20 seconds
            if (timeStamp - IpList.get(ip).get(0) < 20000) {
                System.out.println("time between request: " + (timeStamp - IpList.get(ip).get(0)));
                Long requestNumber = IpList.get(ip).get(1);
                if(previousPage == page) {
                    requestNumber = requestNumber + 1;
                    System.out.println("request omhoog: " + requestNumber);
                    IpList.get(ip).remove(1);
                    IpList.get(ip).add(requestNumber);
                } else {
                    //no good fix, if script cycles between pages.
                    previousPage = page;
                }
                if (requestNumber > 10 && !blackList.contains(ip)) {
                    blackList.add(ip);
                    System.out.println("add to blacklist: " + ip);
                }
            } else {
                if (blackList.contains(ip)) {
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
    }

    public boolean checkBlackList(HttpServletRequest request)
    {
        if(blackList.contains(request.getRemoteAddr()))
        {
            return true;
        } else {
            return false;
        }
    }

}
