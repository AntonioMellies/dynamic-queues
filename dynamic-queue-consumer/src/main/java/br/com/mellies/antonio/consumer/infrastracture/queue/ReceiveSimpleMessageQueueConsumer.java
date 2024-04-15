package br.com.mellies.antonio.consumer.infrastracture.queue;

import br.com.mellies.antonio.consumer.application.usecase.ReceiveSimpleMessageUseCase;
import br.com.mellies.antonio.core.queue.QueueMessage;
import br.com.mellies.antonio.core.queue.QueueReceiver;
import io.quarkus.arc.properties.IfBuildProperty;
import io.smallrye.reactive.messaging.kafka.api.IncomingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.concurrent.CompletionStage;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
@IfBuildProperty(name = "queue.system", stringValue = "kafka")
public class ReceiveSimpleMessageQueueConsumer
    implements QueueReceiver<CompletionStage<Void>, Message<QueueMessage<String>>> {

  @Inject
  ReceiveSimpleMessageUseCase receiveSimpleMessageUseCase;

  @Override
  @Incoming("SIMPLE_STRING_MESSAGE")
  public CompletionStage<Void> receiveMessage(Message<QueueMessage<String>> message) {
    try {
      message.getMetadata(IncomingKafkaRecordMetadata.class).orElseThrow();

      String messagePayload = message.getPayload().getData();
      receiveSimpleMessageUseCase.execute(messagePayload);
    } catch (Exception e) {
      return message.nack(e);
    }
    return message.ack();
  }
}
