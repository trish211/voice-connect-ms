package utils;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import play.libs.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by d847717 on 31/03/2017.
 */
public class Utils {
    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    public static <T> T getObjectFromJsonInputStream(InputStream is, Class<T> snResponseMessageClass) {
        String inputStreamString = getStringFromInputStream(is);
        if (inputStreamString == null) {
            return null;
        }
        return Json.fromJson(Json.parse(inputStreamString), snResponseMessageClass);
    }

    public static <T> T getObjectFromJsonString(String jsonString, Class<T> snResponseMessageClass) {
        if (jsonString == null) {
            return null;
        }
        return Json.fromJson(Json.parse(jsonString), snResponseMessageClass);
    }

    public static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (sb.toString() == null || sb.toString().isEmpty()) {
            return null;
        }
        LOG.trace("Input stream processed and is now String: " + sb.toString());
        return sb.toString();
    }
}
