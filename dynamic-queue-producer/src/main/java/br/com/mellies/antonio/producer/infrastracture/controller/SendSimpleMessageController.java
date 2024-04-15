package br.com.mellies.antonio.producer.infrastracture.controller;

import br.com.mellies.antonio.core.exception.CustomException;
import br.com.mellies.antonio.producer.application.ports.inbound.SendSimpleMessagePort;
import br.com.mellies.antonio.producer.application.usecase.SendSimpleMessageUseCase;
import br.com.mellies.antonio.producer.infrastracture.controller.dto.SimpleMessageDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/simple-message")
public class SendSimpleMessageController
    implements SendSimpleMessagePort<SimpleMessageDTO, Response> {

  @Inject SendSimpleMessageUseCase sendSimpleMessageUseCase;

  @POST
  public Response simpleMessage(SimpleMessageDTO body) throws CustomException {
    String message = body.message();
    return Response.accepted(sendSimpleMessageUseCase.execute(message)).build();
  }
}
