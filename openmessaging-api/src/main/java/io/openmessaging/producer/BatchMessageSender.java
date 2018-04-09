package io.openmessaging.producer;

import io.openmessaging.KeyValue;
import io.openmessaging.Message;

/**
 * A message sender created through {@link Producer#batch()}, to send
 * messages in batch way, and commit or roll back at the appropriate time.
 *
 * @version OMS 1.0.0
 * @since OMS 1.0.0
 */
public interface BatchMessageSender {

    /**
     * Submits a message to this sender
     *
     * @param message a message to be sent
     */
    BatchMessageSender submit(Message message);

    /**
     * Submits a message to this sender, using the specified attributes.
     *
     * @param message a message to be sent
     * @param properties the specified attributes
     */
    BatchMessageSender submit(Message message, KeyValue properties);

    /**
     * Commits all the uncommitted messages in this sender.
     */
    BatchMessageSender send();

    /**
     * Discards all the uncommitted messages in this sender.
     */
    BatchMessageSender discard();
}