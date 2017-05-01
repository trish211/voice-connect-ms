# voice-connect-ms
This is a micro service application that processes a call back request from a client. The customer provides the topic of request by giving the type of segment, reason & service (e.g. segment = "Consumer", reason = "EnquireBill", service = "Mobile").  

The micro service then processes the request from the client. This is done by making a request to the virtual queue stub, which generates the virtual queue ID for the customer. The micro service also makes a request to the CEM which provides the customer callback wait time details. 

The micro service application responds to the request of the client by providing in return the virtual queue ID (e.g. C1E2M365432) and the call back waiting time (e.g. 300000 Milliseconds).

# MicroServiceController.java

The micro service controller works with the following conditions:
1. An SBT plugin tools must be installed in your local system. An SBT build file (build.sbt) is provided for you.
2. The micro service controller includes services, utilities & modules as shown below: 
 - CallMapping.java
 - Reason.java
 - Segment.java
 - Service.java
 - ServiceResponse.java
 - TimeMapping.java
 - TimeServiceResponse.java
 - VirtualQueueServiceResponse.java
 - HttpRequestService.java
 - HttpRequestQaitTimeService.java
 - ResponseService.java
 - UrlProcessor.java
 - UrlService.java
 - Utils.java
 - Module.java

The micro service application can be tested using a consumer-driven testing or Pact testing framework which can be found on https://github.com/trish211/voice-connect-pact.git.
