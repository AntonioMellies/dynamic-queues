package br.com.mellies.antonio.producer.infrastracture.queue;

import br.com.mellies.antonio.producer.core.queue.QueueMessage;
import br.com.mellies.antonio.producer.core.queue.QueueProvider;
import io.quarkus.arc.properties.IfBuildProperty;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@IfBuildProperty(name = "queue.system.type", stringValue = "kafka")
public class QueueKafkaProvider implements QueueProvider {

    @Override
    public boolean sendMessage(QueueMessage message, String chanel) {
        System.out.print("TEST PROVIDER KAFKA");
        return false;
    }
}
