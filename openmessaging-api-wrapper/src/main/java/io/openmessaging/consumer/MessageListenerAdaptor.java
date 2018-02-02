package io.openmessaging.consumer;

import io.openmessaging.Message;

public class MessageListenerAdaptor implements MessageListener {

    private final String queue;

    public MessageListenerAdaptor(String queue) {
        this.queue = queue;
    }

    public native void onMessage(String queue, Message message, Context context);

    @Override
    public void onReceived(Message message, Context context) {
        onMessage(queue, message, context);
    }
}
