package br.com.mellies.antonio.consumer.application.usecase;

import br.com.mellies.antonio.consumer.application.ports.outbound.SimpleMessageProcessRepository;
import br.com.mellies.antonio.core.exception.UseCaseException;
import io.quarkus.logging.Log;
import java.util.Objects;

public class ReceiveSimpleMessageUseCaseImpl implements ReceiveSimpleMessageUseCase {

  private final SimpleMessageProcessRepository simpleMessageProcessRepository;

  public ReceiveSimpleMessageUseCaseImpl(
      SimpleMessageProcessRepository simpleMessageProcessRepository) {
    this.simpleMessageProcessRepository = Objects.requireNonNull(simpleMessageProcessRepository);
  }

  @Override
  public void execute(ReceiveSimpleMessageUseCaseInput input) throws UseCaseException {
    try {
      Log.info("Receive message id: " + input.id());
      this.simpleMessageProcessRepository.processSimpleMessageToQueue(input.message());
    } catch (Exception e) {
      throw new UseCaseException(e.getMessage());
    }
  }
}
