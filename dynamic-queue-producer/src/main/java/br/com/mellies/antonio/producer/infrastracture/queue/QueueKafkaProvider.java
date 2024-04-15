package br.com.mellies.antonio.producer.infrastracture.queue;

import br.com.mellies.antonio.core.queue.QueueMessage;
import br.com.mellies.antonio.core.queue.QueueProvider;
import io.quarkus.arc.properties.IfBuildProperty;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
@IfBuildProperty(name = "queue.system", stringValue = "kafka")
public class QueueKafkaProvider implements QueueProvider {

    @Inject
    @Channel("channel-test")
    Emitter<QueueMessage> emitter;
    @Override
    public Object sendMessage(QueueMessage<?> message) {
        Log.info("Sending a message by Kafka");
        emitter.send(Message.of(message));
        return message;
    }
}
