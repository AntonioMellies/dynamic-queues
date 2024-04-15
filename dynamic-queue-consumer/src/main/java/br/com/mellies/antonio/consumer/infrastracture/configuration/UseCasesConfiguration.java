package br.com.mellies.antonio.consumer.infrastracture.configuration;

import br.com.mellies.antonio.consumer.application.usecase.ReceiveSimpleMessageUseCase;
import br.com.mellies.antonio.consumer.application.usecase.ReceiveSimpleMessageUseCaseImpl;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

@Dependent
public class UseCasesConfiguration {

  @Produces
  public ReceiveSimpleMessageUseCase receiveSimpleMessageUseCase() {
    return new ReceiveSimpleMessageUseCaseImpl();
  }

}
