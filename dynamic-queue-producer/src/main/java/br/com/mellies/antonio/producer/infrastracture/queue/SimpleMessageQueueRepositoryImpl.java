package br.com.mellies.antonio.producer.infrastracture.queue;

import br.com.mellies.antonio.core.queue.QueueMessage;
import br.com.mellies.antonio.core.queue.QueueProvider;
import br.com.mellies.antonio.producer.application.ports.outbound.SimpleMessageQueueRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SimpleMessageQueueRepositoryImpl implements SimpleMessageQueueRepository {

  @Inject
  QueueProvider queueProvider;

  @Override
  public boolean sendSimpleMensageToQueue(String message) {
    try {
      var messageToQueue = QueueMessage.builder()
              .message(message)
              .build();
      queueProvider.sendMessage(messageToQueue);
    } catch (Exception e) {
      Log.error(e.getMessage());
      return false;
    }
    return true;
  }
}
