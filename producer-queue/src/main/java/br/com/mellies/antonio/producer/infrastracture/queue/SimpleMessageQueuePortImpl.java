package br.com.mellies.antonio.producer.infrastracture.queue;

import br.com.mellies.antonio.core.queue.QueueMessage;
import br.com.mellies.antonio.core.queue.QueueProvider;
import br.com.mellies.antonio.producer.application.ports.SimpleMessageQueuePort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SimpleMessageQueuePortImpl implements SimpleMessageQueuePort {

  @Inject
  QueueProvider queueProvider;

  @Override
  public boolean sendSimpleMensageToQueue(String message, String queue) {
    try {
      var messageToQueue = QueueMessage.builder().message(message).build();
      queueProvider.sendMessage(messageToQueue, queue);
    } catch (Exception e) {
      return false;
    }
    return true;
  }  
}
