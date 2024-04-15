package br.com.mellies.antonio.producer.application.usecase;

import br.com.mellies.antonio.core.exception.UseCaseException;
import br.com.mellies.antonio.producer.application.ports.outbound.SimpleMessageQueueRepository;
import io.quarkus.runtime.util.StringUtil;

import java.util.Objects;

public class SendSimpleMessageUseCaseImpl implements SendSimpleMessageUseCase {

  private final SimpleMessageQueueRepository simpleMessageQueueRepository;

  public SendSimpleMessageUseCaseImpl(SimpleMessageQueueRepository simpleMessageQueueRepository) {
    this.simpleMessageQueueRepository = Objects.requireNonNull(simpleMessageQueueRepository);
  }

  @Override
  public Boolean execute(String input) throws UseCaseException {

    if (StringUtil.isNullOrEmpty(input))
      throw new UseCaseException("Message not found");

    return simpleMessageQueueRepository.sendSimpleMensageToQueue(input);
  }
}
