package br.com.mellies.antonio.producer.infrastracture.configuration;

import br.com.mellies.antonio.producer.application.ports.SimpleMessageQueuePort;
import br.com.mellies.antonio.producer.application.usecase.SendSimpleMessageUseCase;
import br.com.mellies.antonio.producer.application.usecase.SendSimpleMessageUseCaseImpl;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@Dependent
public class UseCasesConfiguration {

  private final SimpleMessageQueuePort simpleMessageQueuePort;

  @Inject
  public UseCasesConfiguration(SimpleMessageQueuePort simpleMessageQueuePort) {
    this.simpleMessageQueuePort = simpleMessageQueuePort;
  }

  @Produces
  public SendSimpleMessageUseCase sendSimpleMessageUseCase() {
    return new SendSimpleMessageUseCaseImpl(simpleMessageQueuePort);
  }

}
