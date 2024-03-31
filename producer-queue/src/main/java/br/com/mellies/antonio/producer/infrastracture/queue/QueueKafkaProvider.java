package br.com.mellies.antonio.producer.infrastracture.queue;

import br.com.mellies.antonio.core.queue.QueueMessage;
import br.com.mellies.antonio.core.queue.QueueProvider;
import io.quarkus.arc.properties.IfBuildProperty;
import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
@IfBuildProperty(name = "queue.system", stringValue = "kafka")
public class QueueKafkaProvider implements QueueProvider {

    @Inject
    @Channel("out")
    Emitter<QueueMessage> emitter;
    @Override
    public void sendMessage(QueueMessage<?> message, String chanel) {
        OutgoingKafkaRecordMetadata<?> metadata =
                OutgoingKafkaRecordMetadata.builder().withTopic(chanel).build();

        emitter.send(Message.of(message).addMetadata(metadata));
    }
}
