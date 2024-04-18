package br.com.mellies.antonio.consumer.infrastracture.process;

import br.com.mellies.antonio.consumer.application.ports.outbound.SimpleMessageProcessRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SimpleMessageProcessRepositoryImpl implements SimpleMessageProcessRepository {

  @Override
  public void processSimpleMessageToQueue(String message) {
    Log.info("Process simple message: " + message);
  }
}
