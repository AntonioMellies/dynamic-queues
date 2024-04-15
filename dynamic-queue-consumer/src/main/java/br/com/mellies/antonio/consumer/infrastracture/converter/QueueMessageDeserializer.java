package br.com.mellies.antonio.consumer.infrastracture.converter;

import br.com.mellies.antonio.core.queue.QueueMessage;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class QueueMessageDeserializer extends  ObjectMapperDeserializer<QueueMessage> {
  public QueueMessageDeserializer() {
    super(QueueMessage.class);
  }
}
