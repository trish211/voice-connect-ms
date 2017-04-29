//The HttpRequestService sends a HTTP Post request - VQ ID
package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.net.HttpHeaders;
import com.google.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;


import java.io.IOException;
import java.net.URI;

public class HttpRequestService {
    @Inject
    private HttpClientBuilder httpClientBuilder;

    //an http response is a message sent by the server back to the client after receiving & interpreting a request message
    //an http request consists of method name, request URI & http protocol version

    public HttpResponse postResponse(JsonNode jsonMessage) throws IOException {
        HttpResponse response = null;
        HttpClient httpClient = httpClientBuilder.build();
        try {
            //string data container
            //convert jsonMessage to string
            String jsonString = jsonMessage.toString();
            //post string entity
            StringEntity jsonEntity = new StringEntity(jsonString);

            HttpPost post = new HttpPost("http://localhost:9001/VirtualQueues");
            //an http message contains headers to describe message properties
            post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            post.setEntity(jsonEntity);
            //send http response
            response = httpClient.execute(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


}
