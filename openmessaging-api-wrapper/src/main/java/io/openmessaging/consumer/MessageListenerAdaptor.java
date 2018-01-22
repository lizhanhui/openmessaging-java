package io.openmessaging.consumer;

import io.openmessaging.Message;

public class MessageListenerAdaptor implements MessageListener {

    public native void onMessage(Message message, Context context);

    @Override
    public void onReceived(Message message, Context context) {
        onMessage(message, context);
    }
}
