package io.openmessaging.handler;

public interface Pipeline {

    Pipeline addLast(Handler handler);

    Pipeline add(int index, String name, Handler handler);
}
