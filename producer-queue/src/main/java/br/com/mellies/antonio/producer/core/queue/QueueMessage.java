package br.com.mellies.antonio.producer.core.queue;

import java.util.UUID;

public class QueueMessage {

  UUID id;
  String message;

  public QueueMessage(QueueMessageBuilder queueMessageBuilder) {
    this.id = queueMessageBuilder.id;
    this.message = queueMessageBuilder.message;
  }

  public static QueueMessageBuilder builder() {
    return new QueueMessageBuilder();
  }

  public static class QueueMessageBuilder {
    UUID id;
    String message;

    public QueueMessageBuilder message(String message) {
      this.message = message;
      return this;
    }

    public QueueMessage build() {
      this.id = UUID.randomUUID();
      return new QueueMessage(this);
    }
  }
}
