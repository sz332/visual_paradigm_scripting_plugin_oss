package hu.resanbt.visualparadigm.scripting.common.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.Consumer;

public class KeyPressedForwarder extends KeyAdapter {

    private final Consumer<KeyEvent> consumer;

    public KeyPressedForwarder(Consumer<KeyEvent> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        consumer.accept(e);
    }
}
