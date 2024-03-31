package br.com.mellies.antonio.core.queue;

public interface QueueProvider {
    void sendMessage(QueueMessage<?> message, String chanel);

}
