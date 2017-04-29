//The MicroServiceController gets responses from the client
//sends http post request to stub
//gets response from stub (virtual queue ID)
//sends http post request to cem
//gets response from cem (waiting times)

package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.CallMapping;
import model.VirtualQueueServiceResponse;
import org.apache.http.HttpResponse;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.HttpRequestService;
import service.UrlProcessor;
import service.UrlService;
import utils.Utils;

import java.io.IOException;
import java.net.URL;

@Singleton
public class MicroServiceController extends Controller {

    @Inject
    private HttpRequestService servis;

    @Inject
    private UrlService url_service;

    @Inject
    private UrlProcessor urlProcessor;

    public MicroServiceController(){
    }

    public Result processRequest() throws IOException {
        //process virtual queue id from stub
        JsonNode jsonTopics = request().body().asJson();
        CallMapping topics = Json.fromJson(jsonTopics, CallMapping.class);
        System.out.println("Call mapping have been received & processed. " + "\n" + topics);
        HttpResponse response = servis.postResponse(jsonTopics);

        //Takes response stream and turns it into an object.
        VirtualQueueServiceResponse virtualQueueServiceResponse = Utils.getObjectFromJsonInputStream(response.getEntity().getContent(), VirtualQueueServiceResponse.class);

        //generate a new url (cem url + vqid) to execute call wait time
        URL new_url = url_service.getUrl(virtualQueueServiceResponse.getId());
        //converts new_url to string
        String newUrlString = new_url.toString();

        //execute the new URL & provides the wait time
        Result newUrlResult = urlProcessor.processUrl(newUrlString);

        return newUrlResult;
    }

}
