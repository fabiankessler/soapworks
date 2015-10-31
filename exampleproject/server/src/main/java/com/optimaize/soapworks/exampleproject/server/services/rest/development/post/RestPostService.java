package com.optimaize.soapworks.exampleproject.server.services.rest.development.post;

import com.optimaize.soapworks.exampleproject.ontology.rest.development.post.Circle;
import com.optimaize.soapworks.exampleproject.ontology.rest.development.post.ComplexObject;
import com.optimaize.soapworks.exampleproject.server.lib.BaseWebService;
import com.optimaize.soapworks.server.rest.RestWebService;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;

/**
 * This service uses a complex JSON input that comes in the http post body payload.
 * The result is complex also.
 */
@Service
@Path("/v1/development")
public class RestPostService extends BaseWebService implements RestWebService {

    @GET
    @Path("/get")
    @Produces({"application/json"})
    public ComplexObject get(
    ) {
        return new ComplexObject("theresult", 15, true, ComplexObject.Color.RED, new Circle("blue", 5d));
    }

    @POST
    @Path("/post")
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public ComplexObject post(
            @QueryParam(value = "apiKey") final String apiKey,
            @QueryParam(value = "envelope") final boolean envelope,
            ComplexObject complexParam
    ) {
        return new ComplexObject(
                complexParam.getString()+"-result",
                complexParam.getNumber()*2,
                !complexParam.isYesOrNo(),
                complexParam.getColor(),
                new Circle("light"+complexParam.getGeometricalFigure().getColor(), 5d)
        );
    }

}