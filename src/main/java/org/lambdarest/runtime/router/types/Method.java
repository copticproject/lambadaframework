package org.lambdarest.runtime.router.types;


import org.lambdarest.jaxrs.ResourceMethod;
import org.lambdarest.runtime.models.Request;

public class Method implements RouterType {

    @Override
    public boolean isMatching(Request request, ResourceMethod resourceMethod) {
        return resourceMethod.getHttpMethod().equals(request.getMethod().name());
    }
}
