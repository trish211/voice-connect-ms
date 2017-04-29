//The UrlProcessor is a service that executes the URL which contains the Virtual Queue ID
package service;

import com.google.inject.Inject;
import model.ServiceResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import play.libs.Json;
import play.mvc.Result;
import utils.Utils;

import java.io.IOException;
import java.io.InputStream;

import static play.mvc.Results.ok;

public class UrlProcessor {
    @Inject
    private HttpRequestWaitTimeService serviceTime;

    public Result processUrl(String url) throws IOException {
        //InputStream is for reading
        InputStream is = null;
        //JsonNode jsonTime = request().body().asJson();
        //HttpResponse responseTime = serviceTime.postWaitTimeResponse(jsonTime, url);
        HttpResponse responseTime = serviceTime.postWaitTimeResponse(url);
        HttpEntity httpEntity = responseTime.getEntity();
        is = httpEntity.getContent();

        //return ok(responseTime.getEntity().getContent());
        return ok(Json.parse(responseTime.getEntity().getContent()));

        //ServiceResponse response = Utils.getObjectFromJsonInputStream(responseTime.getEntity().getContent(), ServiceResponse.class);
        //return ok(Json.toJson(response));
    }
}
