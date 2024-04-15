package br.com.mellies.antonio.core.queue;

public interface QueueProvider {
    Object sendMessage(QueueMessage<?> message);

}
