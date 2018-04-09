package io.openmessaging.handler;

public interface Handler {

    String name();

    void preHandle(Context context);

    void postHandle(Context context);
}
