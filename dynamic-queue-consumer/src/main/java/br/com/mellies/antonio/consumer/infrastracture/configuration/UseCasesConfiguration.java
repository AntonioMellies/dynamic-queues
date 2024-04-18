package br.com.mellies.antonio.consumer.infrastracture.configuration;

import br.com.mellies.antonio.consumer.application.ports.outbound.SimpleMessageProcessRepository;
import br.com.mellies.antonio.consumer.application.usecase.ReceiveSimpleMessageUseCase;
import br.com.mellies.antonio.consumer.application.usecase.ReceiveSimpleMessageUseCaseImpl;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@Dependent
public class UseCasesConfiguration {

  private final SimpleMessageProcessRepository simpleMessageProcessRepository;

  @Inject
  public UseCasesConfiguration(SimpleMessageProcessRepository simpleMessageProcessRepository) {
    this.simpleMessageProcessRepository = simpleMessageProcessRepository;
  }

  @Produces
  public ReceiveSimpleMessageUseCase receiveSimpleMessageUseCase() {
    return new ReceiveSimpleMessageUseCaseImpl(simpleMessageProcessRepository);
  }

}
