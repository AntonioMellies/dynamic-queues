package br.com.mellies.antonio.producer.core.queue;

public interface QueueProvider {
    boolean sendMessage(QueueMessage<?> message, String chanel);

}
