package service;

import java.io.IOException;
import java.net.URL;

public class UrlService {
    private URL newUrl;

    public URL getUrl(String responseStringId) {

        //initialise cem url
        String urlString = "http://nero.in.telstra.com.au:9003/CustomerExperienceManager/rest/getInfo/";
        try {
            URL url = new URL(urlString + responseStringId);
            newUrl = url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newUrl;
    }

}
