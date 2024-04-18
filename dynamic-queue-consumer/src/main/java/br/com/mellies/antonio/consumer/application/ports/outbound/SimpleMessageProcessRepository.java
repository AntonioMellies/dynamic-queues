package br.com.mellies.antonio.consumer.application.ports.outbound;

public interface SimpleMessageProcessRepository {
    void processSimpleMessageToQueue(String message);
}
