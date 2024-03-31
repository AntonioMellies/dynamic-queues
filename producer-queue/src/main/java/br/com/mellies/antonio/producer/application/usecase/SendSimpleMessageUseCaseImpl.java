package br.com.mellies.antonio.producer.application.usecase;

import br.com.mellies.antonio.core.exception.UseCaseException;
import br.com.mellies.antonio.producer.application.ports.SimpleMessageQueuePort;
import io.quarkus.runtime.util.StringUtil;

public class SendSimpleMessageUseCaseImpl implements SendSimpleMessageUseCase {

  private final static String CHANNEL = "SIMPLE_STRING_MESSAGE";
  private final SimpleMessageQueuePort simpleMessageQueuePort;

  public SendSimpleMessageUseCaseImpl(SimpleMessageQueuePort simpleMessageQueuePort) {
    this.simpleMessageQueuePort = simpleMessageQueuePort;
  }

  @Override
  public Boolean execute(String input) throws UseCaseException {

    if (StringUtil.isNullOrEmpty(input))
      throw new UseCaseException("Message not found");

    return simpleMessageQueuePort.sendSimpleMensageToQueue(input, CHANNEL);
  }
}
