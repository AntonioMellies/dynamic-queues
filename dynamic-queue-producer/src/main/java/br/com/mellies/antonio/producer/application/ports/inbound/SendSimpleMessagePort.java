package br.com.mellies.antonio.producer.application.ports.inbound;

import br.com.mellies.antonio.core.exception.CustomException;

public interface SendSimpleMessagePort<I, O> {
  O simpleMessage(I body) throws CustomException;
}
