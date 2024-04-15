package br.com.mellies.antonio.producer.infrastracture.configuration;

import br.com.mellies.antonio.producer.application.ports.outbound.SimpleMessageQueueRepository;
import br.com.mellies.antonio.producer.application.usecase.SendSimpleMessageUseCase;
import br.com.mellies.antonio.producer.application.usecase.SendSimpleMessageUseCaseImpl;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@Dependent
public class UseCasesConfiguration {

  private final SimpleMessageQueueRepository simpleMessageQueueRepository;

  @Inject
  public UseCasesConfiguration(SimpleMessageQueueRepository simpleMessageQueueRepository) {
    this.simpleMessageQueueRepository = simpleMessageQueueRepository;
  }

  @Produces
  public SendSimpleMessageUseCase sendSimpleMessageUseCase() {
    return new SendSimpleMessageUseCaseImpl(simpleMessageQueueRepository);
  }

}
