package br.com.mellies.antonio.consumer.application.usecase;

import br.com.mellies.antonio.core.exception.UseCaseException;
import io.quarkus.runtime.util.StringUtil;

public class ReceiveSimpleMessageUseCaseImpl implements ReceiveSimpleMessageUseCase {

  @Override
  public void execute(String input) throws UseCaseException {
    if (StringUtil.isNullOrEmpty(input)) {
      System.out.print("Message not found");
      return;
    }
    System.out.print("Message: " + input);
  }
}
