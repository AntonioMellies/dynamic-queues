package br.com.mellies.antonio.producer.infrastracture.configuration;

import br.com.mellies.antonio.producer.application.usecase.SendSimpleMessageUseCase;
import br.com.mellies.antonio.producer.application.usecase.SendSimpleMessageUseCaseImpl;
import br.com.mellies.antonio.producer.core.queue.QueueProvider;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@Dependent
public class UseCasesConfiguration {

  private final QueueProvider queueProvider;

  @Inject
  public UseCasesConfiguration(QueueProvider queueProvider) {
    this.queueProvider = queueProvider;
  }

  @Produces
  public SendSimpleMessageUseCase sendSimpleMessageUseCase() {
    return new SendSimpleMessageUseCaseImpl(queueProvider);
  }

}
