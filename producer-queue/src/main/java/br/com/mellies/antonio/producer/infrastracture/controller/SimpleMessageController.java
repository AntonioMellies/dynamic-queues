package br.com.mellies.antonio.producer.infrastracture.controller;

import br.com.mellies.antonio.producer.application.usecase.SendSimpleMessageUseCase;
import br.com.mellies.antonio.producer.core.exception.CustomException;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/simple-message")
public class SimpleMessageController {

    @Inject
    SendSimpleMessageUseCase sendSimpleMessageUseCase;

    @POST
    public Response hello(Map<String, String> body) throws CustomException {
        String message = body.get("message");
        return Response.accepted(sendSimpleMessageUseCase.execute(message)).build();
    }
}
