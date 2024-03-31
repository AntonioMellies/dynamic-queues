package br.com.mellies.antonio.core.queue;

public interface QueueReceiver<R, T> {
    R receiveMessage(T message);
}
