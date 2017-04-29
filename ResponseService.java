//The ResponseService accepts the response from the client
package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.Logger;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class ResponseService {
    //these are the inputs required information from customer
    private static final String CUSTOMERNAME = "customerName";
    private static final String CUSTOMERID = "customerId";
    private static final String ACCOUNTNUMBER = "accountNumber";
    private static final String SEGMENT = "segment";
    private static final String REASON = "reason";
    private static final String SERVICE = "service";
    private static final String PREFERREDCALLBACKTIME = "preferredCallbackTime";

    //ObjectMapper class provides functionality to convert Java objects to matching JSON constructs and vice versa
    private ObjectMapper objectMapper;

    //declare a component (using INJECT annotation) that is a controller that has other components and dependencies
    @Inject
    public ResponseService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonNode getResponse(JsonNode request) {

        String name;
        String id;
        String accountnum;
        String segmentString;
        String reasonString;
        String serviceString;
        String prefCallbackTime;

        try {
            name = request.get(CUSTOMERNAME).asText();
        } catch (Exception e) {
            Logger.error("Inbound message missing the name field");
            throw new RuntimeException("Inbound message missing the name field");
        }

        try {
            id = request.get(CUSTOMERID).asText();
        } catch (Exception e) {
            Logger.error("Inbound message missing the customer ID field");
            throw new RuntimeException("Inbound message missing the customer ID field");
        }

        try {
            accountnum = request.get(ACCOUNTNUMBER).asText();
        } catch (Exception e) {
            Logger.error("Inbound message missing the account number field");
            throw new RuntimeException("Inbound message missing the account number field");
        }

        try {
            segmentString = request.get(SEGMENT).asText();
        } catch (Exception e) {
            Logger.error("Inbound message missing the segment field");
            throw new RuntimeException("Inbound message missing the segment field");
        }

        try {
            reasonString = request.get(REASON).asText();
        } catch (Exception e) {
            Logger.error("Inbound message missing the reason field");
            throw new RuntimeException("Inbound message missing the reason field");
        }

        try {
            serviceString = request.get(SERVICE).asText();
        } catch (Exception e) {
            Logger.error("Inbound message missing the service field");
            throw new RuntimeException("Inbound message missing the service field");
        }

        try {
            prefCallbackTime = request.get(PREFERREDCALLBACKTIME).asText();
        } catch (Exception e) {
            Logger.error("Inbound message missing the preferred callback time field");
            throw new RuntimeException("Inbound message missing the preferred callback time field");
        }

        Map expectedResponse = new HashMap();
        Logger.info("Message received: name: {} id: {} callback-time: {} account-number: {} segment: {} reason: {} service: {} preferred-callback-time", name, id, accountnum, segmentString, reasonString, serviceString, prefCallbackTime);
        expectedResponse.put("message", "Welcome " + name);
        expectedResponse.put("customer-id", id);
        expectedResponse.put("account-number", accountnum);
        expectedResponse.put("segment", segmentString);
        expectedResponse.put("reason", reasonString);
        expectedResponse.put("service", serviceString);
        expectedResponse.put("preferred-callback-time", prefCallbackTime);
        expectedResponse.put("preferred-callback-time", prefCallbackTime);

        return objectMapper.convertValue(expectedResponse, JsonNode.class);
    }
}