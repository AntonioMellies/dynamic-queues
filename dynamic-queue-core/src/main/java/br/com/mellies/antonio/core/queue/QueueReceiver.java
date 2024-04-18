package br.com.mellies.antonio.core.queue;

public interface QueueReceiver<R, T> {
    R receive(T message);
}
