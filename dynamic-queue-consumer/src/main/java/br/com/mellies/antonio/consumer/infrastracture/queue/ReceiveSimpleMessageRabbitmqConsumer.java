package br.com.mellies.antonio.consumer.infrastracture.queue;

import br.com.mellies.antonio.consumer.application.ports.inbound.ReceiveSimpleMessagePort;
import br.com.mellies.antonio.consumer.application.usecase.ReceiveSimpleMessageUseCase;
import br.com.mellies.antonio.consumer.application.usecase.ReceiveSimpleMessageUseCaseInput;
import br.com.mellies.antonio.core.exception.CustomException;
import br.com.mellies.antonio.core.queue.QueueMessage;
import br.com.mellies.antonio.core.queue.QueueReceiver;
import io.quarkus.arc.properties.IfBuildProperty;
import io.quarkus.logging.Log;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.concurrent.CompletionStage;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
@IfBuildProperty(name = "queue.system", stringValue = "rabbitmq")
public class ReceiveSimpleMessageRabbitmqConsumer
    implements ReceiveSimpleMessagePort<QueueMessage<String>>,
        QueueReceiver<CompletionStage<Void>, Message<JsonObject>> {

  @Inject ReceiveSimpleMessageUseCase receiveSimpleMessageUseCase;

  @Incoming("channel-test")
  public CompletionStage<Void> receive(Message<JsonObject> message) {
    try {
      Log.info("Received a message by Rabbitmq");
      this.receiveMessage(jsonObjectToQueueMessage(message.getPayload()));
    } catch (Exception e) {
      Log.error(e);
      return message.nack(e);
    }
    return message.ack();
  }

  public void receiveMessage(QueueMessage<String> message) throws CustomException {
    var input = new ReceiveSimpleMessageUseCaseInput(message.getId().toString(), message.getData());
    receiveSimpleMessageUseCase.execute(input);
  }

  private QueueMessage<String> jsonObjectToQueueMessage(JsonObject jsonObject)
      throws CustomException {
    try {
      return jsonObject.mapTo(QueueMessage.class);
    } catch (Exception e) {
      throw new CustomException("Error converting received message");
    }
  }
}
