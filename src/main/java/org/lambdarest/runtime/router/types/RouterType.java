package org.lambdarest.runtime.router.types;


import org.lambdarest.jaxrs.ResourceMethod;
import org.lambdarest.runtime.models.Request;

public interface RouterType {

    boolean isMatching(Request request, ResourceMethod resourceMethod);
}
