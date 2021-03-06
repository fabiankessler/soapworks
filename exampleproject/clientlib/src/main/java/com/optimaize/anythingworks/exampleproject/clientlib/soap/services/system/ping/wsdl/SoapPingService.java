
package com.optimaize.anythingworks.exampleproject.clientlib.soap.services.system.ping.wsdl;

import com.optimaize.anythingworks.exampleproject.clientlib.soap.commonwsdl.SoapWebServiceException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SoapPingService", targetNamespace = "http://ping.system.soap.services.server.exampleproject.anythingworks.optimaize.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SoapPingService {


    /**
     * 
     * @param apiKey
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ping", targetNamespace = "http://ping.system.soap.services.server.exampleproject.anythingworks.optimaize.com/", className = "com.optimaize.anythingworks.exampleproject.clientlib.soap.services.system.ping.wsdl.Ping")
    @ResponseWrapper(localName = "pingResponse", targetNamespace = "http://ping.system.soap.services.server.exampleproject.anythingworks.optimaize.com/", className = "com.optimaize.anythingworks.exampleproject.clientlib.soap.services.system.ping.wsdl.PingResponse")
    @Action(input = "http://ping.system.soap.services.server.exampleproject.anythingworks.optimaize.com/SoapPingService/pingRequest", output = "http://ping.system.soap.services.server.exampleproject.anythingworks.optimaize.com/SoapPingService/pingResponse", fault = {
            @FaultAction(className = SoapWebServiceException.class, value = "http://exceptionthrower.development.soap.services.server.exampleproject.anythingworks.optimaize.com/SoapExceptionThrower/throwException/Fault/SoapWebServiceException")
    })
    public String ping(
        @WebParam(name = "apiKey", targetNamespace = "")
        String apiKey)
        throws SoapWebServiceException
    ;

}
