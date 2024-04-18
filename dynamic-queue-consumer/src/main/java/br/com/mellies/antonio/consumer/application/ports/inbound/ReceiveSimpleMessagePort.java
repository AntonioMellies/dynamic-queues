package br.com.mellies.antonio.consumer.application.ports.inbound;

import br.com.mellies.antonio.core.exception.CustomException;

public interface ReceiveSimpleMessagePort<I> {
  void receiveMessage(I body) throws CustomException;
}
