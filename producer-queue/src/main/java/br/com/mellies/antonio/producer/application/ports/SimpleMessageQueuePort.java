package br.com.mellies.antonio.producer.application.ports;

public interface SimpleMessageQueuePort {
    boolean sendSimpleMensageToQueue(String message, String queue);
}
