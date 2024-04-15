package br.com.mellies.antonio.producer.application.ports.outbound;

public interface SimpleMessageQueueRepository {
    boolean sendSimpleMensageToQueue(String message);
}
