package org.lambdarest.runtime.models.error;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.lambdarest.runtime.models.Response;

public class ErrorResponse extends Response {

    protected String errorMessage;

    public ErrorResponse() {
        this.errorMessage = "Internal Server Error";
        this.code = 500;
    }

    public ErrorResponse(String errorMessage) {
        this();
        this.errorMessage = errorMessage;
    }

    @JsonProperty("errorMessage")
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

}
