package org.lambdarest.runtime.router.types;


import org.lambdarest.jaxrs.ResourceMethod;
import org.lambdarest.runtime.models.Request;


public class ConsumedTypes implements RouterType {
    @Override
    public boolean isMatching(Request request, ResourceMethod resourceMethod) {
        return resourceMethod.getConsumedTypes().contains(request.getConsumedMediaType());
    }
}
