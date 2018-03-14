package org.lambdarest.runtime.router;


import org.glassfish.jersey.process.Inflector;
import org.glassfish.jersey.server.model.ResourceMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lambdarest.jaxrs.JAXRSParser;
import org.lambdarest.jaxrs.Resource;
import org.lambdarest.runtime.models.Request;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class RouterTest {


    protected JAXRSParser getJAXRSParser() {

        List<Resource> resourceList = new LinkedList<>();
        org.glassfish.jersey.server.model.Resource.Builder resourceBuilder = org.glassfish.jersey.server.model.Resource.builder();
        resourceBuilder.path("/{id}");
        ResourceMethod resourceMethod = resourceBuilder
                .addMethod("GET")
                .handledBy(new Inflector<ContainerRequestContext, Object>() {
                    @Override
                    public Object apply(ContainerRequestContext containerRequestContext) {
                        return "HELLO";
                    }
                })
                .build();

        resourceList.add(new Resource(resourceBuilder.build()));
        JAXRSParser mockJaxRSParser = PowerMock.createMock(JAXRSParser.class);
        expect(mockJaxRSParser.scan())
                .andReturn(resourceList)
                .anyTimes();

        expect(mockJaxRSParser.withPackageName(anyString(),
                anyObject(Class.class)))
                .andReturn(mockJaxRSParser)
                .anyTimes();

        PowerMock.replayAll();
        return mockJaxRSParser;
    }

    @Test
    public void getRouter() throws Exception {
        Request request = new Request();
        request
                .setMethod(Request.RequestMethod.GET)
                .setPackage("org.lambdarest")
                .setPathtemplate("/{id}");

        org.lambdarest.jaxrs.ResourceMethod routedResource = Router
                .getRouter()
                .setJaxrsParser(getJAXRSParser())
                .route(request);

        assertNotNull(routedResource);
    }
}