package service;

import com.google.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpRequestWaitTimeService {
    @Inject
    private HttpClientBuilder httpClientBuilder;

    //an http response is a message sent by the server back to the client after receiving & interpreting a request message
    //an http request consists of method name, request URI & http protocol version

    public HttpResponse postWaitTimeResponse(String url) throws IOException {

        HttpClient httpClient = httpClientBuilder.build();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);

        return response;

    }
}
