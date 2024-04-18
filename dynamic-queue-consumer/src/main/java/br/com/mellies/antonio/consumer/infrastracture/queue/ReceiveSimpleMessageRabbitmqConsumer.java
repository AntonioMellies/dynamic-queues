package br.com.mellies.antonio.consumer.infrastracture.queue;

import br.com.mellies.antonio.consumer.application.ports.inbound.ReceiveSimpleMessagePort;
import br.com.mellies.antonio.consumer.application.usecase.ReceiveSimpleMessageUseCase;
import br.com.mellies.antonio.consumer.application.usecase.ReceiveSimpleMessageUseCaseInput;
import br.com.mellies.antonio.core.exception.CustomException;
import br.com.mellies.antonio.core.queue.QueueMessage;
import br.com.mellies.antonio.core.queue.QueueReceiver;
import io.quarkus.arc.properties.IfBuildProperty;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.concurrent.CompletionStage;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
@IfBuildProperty(name = "queue.system", stringValue = "rabbitmq")
public class ReceiveSimpleMessageRabbitmqConsumer
    implements ReceiveSimpleMessagePort<QueueMessage<String>>,
        QueueReceiver<CompletionStage<Void>, Message<QueueMessage<String>>> {

  @Inject
  ReceiveSimpleMessageUseCase receiveSimpleMessageUseCase;

  @Override
  @Incoming("channel-test")
  public CompletionStage<Void> receive(Message<QueueMessage<String>> message) {
    try {
      Log.info("Received a message by Rabbitmq");
      this.receiveMessage(message.getPayload());
    } catch (Exception e) {
      return message.nack(e);
    }
    return message.ack();
  }
  @Override
  public void receiveMessage(QueueMessage<String> body) throws CustomException {
    var input = new ReceiveSimpleMessageUseCaseInput(body.getId().toString(), body.getData());
    receiveSimpleMessageUseCase.execute(input);
  }

}
