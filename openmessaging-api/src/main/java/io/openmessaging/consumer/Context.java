package io.openmessaging.consumer;

import io.openmessaging.KeyValue;

public interface Context {
    /**
     * Returns the attributes of this {@code MessageContext} instance.
     *
     * @return the attributes
     */
    KeyValue properties();

    /**
     * Acknowledges the specified and consumed message, which is related to this {@code MessageContext}.
     * <p>
     * Messages that have been received but not acknowledged may be redelivered.
     *
     * @throws OMSRuntimeException if the consumer fails to acknowledge the messages due to some internal error.
     */
    void ack();

    /**
     * Acknowledges the specified and consumed message with the specified attributes.
     * <p>
     * Messages that have been received but not acknowledged may be redelivered.
     *
     * @throws OMSRuntimeException if the consumer fails to acknowledge the messages due to some internal error.
     */
    void ack(KeyValue properties);
}
