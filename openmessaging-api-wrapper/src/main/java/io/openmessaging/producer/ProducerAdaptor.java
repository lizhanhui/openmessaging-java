package io.openmessaging.producer;

import io.openmessaging.BytesMessage;
import io.openmessaging.Future;
import io.openmessaging.FutureListener;
import io.openmessaging.KeyValue;
import io.openmessaging.Message;
import io.openmessaging.interceptor.ProducerInterceptor;

public class ProducerAdaptor {

    private final Producer producer;

    public ProducerAdaptor(Producer producer) {
        this.producer = producer;
    }

    public KeyValue properties() {
        return producer.properties();
    }

    public SendResult send(Message message) {
        return producer.send(message);
    }

    public SendResult send(Message message, KeyValue properties) {
        return producer.send(message, properties);
    }

    public SendResult send(Message message, LocalTransactionBranchExecutor branchExecutor, Object arg,
        KeyValue properties) {
        return producer.send(message, branchExecutor, arg, properties);
    }

    public native void sendAsyncCallback(long opaque, Future<SendResult> future);

    public void sendAsync(final long opaque, Message message) {
        Future<SendResult> future = producer.sendAsync(message);
        future.addListener(new FutureListener<SendResult>() {
            @Override
            public void operationComplete(final Future<SendResult> future) {
                sendAsyncCallback(opaque, future);
            }
        });
    }

    public void sendAsync(final long opaque, Message message, KeyValue properties) {
        Future<SendResult> future = producer.sendAsync(message, properties);
        future.addListener(new FutureListener<SendResult>() {
            @Override
            public void operationComplete(final Future<SendResult> future) {
                sendAsyncCallback(opaque, future);
            }
        });
    }

    public void sendOneway(Message message) {
        producer.sendOneway(message);
    }

    public void sendOneway(Message message, KeyValue properties) {
        producer.sendOneway(message, properties);
    }

    public BatchMessageSender createSequenceBatchMessageSender() {
        return producer.createSequenceBatchMessageSender();
    }

    public void addInterceptor(ProducerInterceptor interceptor) {
        producer.addInterceptor(interceptor);
    }

    public void removeInterceptor(ProducerInterceptor interceptor) {
        producer.removeInterceptor(interceptor);
    }

    public BytesMessage createTopicBytesMessage(String topic, byte[] body) {
        return producer.createTopicBytesMessage(topic, body);
    }

    public BytesMessage createQueueBytesMessage(String queue, byte[] body) {
        return producer.createQueueBytesMessage(queue, body);
    }

    public void startup() {
        producer.startup();
    }

    public void shutdown() {
        producer.shutdown();
    }
}
