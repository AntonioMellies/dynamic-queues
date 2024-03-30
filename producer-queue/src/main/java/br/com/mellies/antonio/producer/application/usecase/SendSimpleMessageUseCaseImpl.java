package br.com.mellies.antonio.producer.application.usecase;

import br.com.mellies.antonio.producer.core.exception.UseCaseException;
import br.com.mellies.antonio.producer.core.queue.QueueMessage;
import br.com.mellies.antonio.producer.core.queue.QueueProvider;
import io.quarkus.runtime.util.StringUtil;

public class SendSimpleMessageUseCaseImpl implements SendSimpleMessageUseCase {

  private final QueueProvider queueProvider;

  public SendSimpleMessageUseCaseImpl(QueueProvider queueProvider) {
    this.queueProvider = queueProvider;
  }

  @Override
  public Boolean execute(String input) throws UseCaseException {

    if (StringUtil.isNullOrEmpty(input)) throw new UseCaseException("Message not found");

    QueueMessage message = QueueMessage.builder().message(input).build();
    queueProvider.sendMessage(message, "chanel");

    return null;
  }
}
