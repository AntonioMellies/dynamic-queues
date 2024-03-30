package br.com.mellies.antonio.producer.core.queue;

import java.io.Serializable;
import java.util.UUID;

public class QueueMessage<T> implements Serializable {

  UUID id;
  T data;

  public QueueMessage(QueueMessageBuilder queueMessageBuilder) {
    this.id = queueMessageBuilder.id;
    this.data = (T) queueMessageBuilder.data;
  }

  public UUID getId() {
    return id;
  }

  public T getData() {
    return data;
  }

  public static QueueMessageBuilder builder() {
    return new QueueMessageBuilder();
  }

  public static class QueueMessageBuilder {
    UUID id;
    Object data;

    public QueueMessageBuilder message(Object data) {
      this.data = data;
      return this;
    }

    public QueueMessage build() {
      this.id = UUID.randomUUID();
      return new QueueMessage(this);
    }
  }
}
