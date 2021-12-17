package hu.resanbt.visualparadigm.scripting.common.eventbus;

@FunctionalInterface
public interface EventHandler<T extends Event> {
    void handleEvent(T e);
}
