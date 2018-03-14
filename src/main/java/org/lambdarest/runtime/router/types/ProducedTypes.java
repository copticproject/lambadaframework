package org.lambdarest.runtime.router.types;


import org.lambdarest.jaxrs.ResourceMethod;
import org.lambdarest.runtime.models.Request;

public class ProducedTypes implements RouterType {
    @Override
    public boolean isMatching(Request request, ResourceMethod resourceMethod) {
        return resourceMethod.getProducedTypes().contains(request.getProducedMediaType());
    }
}
