package br.com.mellies.antonio.producer.infrastracture.controller;

import br.com.mellies.antonio.core.exception.CustomException;
import br.com.mellies.antonio.producer.application.usecase.SendSimpleMessageUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.HashMap;

@Path("/simple-message")
public class SendSimpleMessageController {

  @Inject SendSimpleMessageUseCase sendSimpleMessageUseCase;

  @POST
  public Response simpleMessage(HashMap<String, String> body) throws CustomException {
    String message = body.get("message");
    return Response.accepted(sendSimpleMessageUseCase.execute(message)).build();
  }
}
