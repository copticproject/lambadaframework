package org.lambdarest.runtime.router.types;


import org.glassfish.jersey.uri.UriTemplate;
import org.lambdarest.jaxrs.Resource;
import org.lambdarest.jaxrs.ResourceMethod;
import org.lambdarest.runtime.models.Request;

import java.util.HashMap;

public class Path implements RouterType {

    @Override
    public boolean isMatching(Request request, ResourceMethod resourceMethod) {
        Resource resource = resourceMethod.getParent();

        try {
            return new UriTemplate(resource.getPath()).match(request.getPathTemplate(), new HashMap<>());
        } catch (NullPointerException e) {
            return false;
        }
    }
}
