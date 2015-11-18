package com.enforce.detection.web.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("kpi")
public class KPIResource {
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("o111")
    public String produceOrdersKpi() {
    	return "Got it - o111 kpi";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("e111")
    public String produceCreditKpi() {
    	return "Got it - e111 kpi";
    }
}
