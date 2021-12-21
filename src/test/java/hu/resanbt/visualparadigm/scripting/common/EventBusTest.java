package hu.resanbt.visualparadigm.scripting.common;

import hu.resanbt.visualparadigm.scripting.common.eventbus.Event;
import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.eventbus.EventHandler;
import org.junit.Assert;
import org.junit.Test;

public class EventBusTest {

    @Test
    public void test() {
        EventBus bus = new EventBus();

        // create an event handler. It must be not directly a lambda expression because
        // otherwise it cannot be removed
        EventHandler<MyStringEvent> stringCallback = (MyStringEvent e) -> System.out.println("Received msg = " + e.getMessage());
        EventHandler<MyIntegerEvent> integerCallback = this::handleMyIntegerEvent;

        // subscribe to events
        bus.subscribe(MyStringEvent.class, stringCallback);
        bus.subscribe(MyIntegerEvent.class, integerCallback);

        // publish events
        bus.publish(new MyIntegerEvent(23));
        bus.publish(new MyStringEvent("Hello world"));

        // unsubscribe
        bus.unsubscribe(stringCallback);

        // this message is not handled anymore
        bus.publish(new MyStringEvent("This shall not be visible"));

        // yet this is
        bus.publish(new MyIntegerEvent(42));

        // unsubscribe all listeners
        bus.unsubscribeAll();

        // and this not
        bus.publish(new MyIntegerEvent(69));

        // re subscription shall work
        bus.subscribe(MyStringEvent.class, stringCallback);
        bus.publish(new MyStringEvent("Works again"));

        Assert.assertNotNull(bus);
    }

    public void handleMyIntegerEvent(MyIntegerEvent e) {
        System.out.println("Handle my integer event " + e.getValue());
    }

    public static void main(String[] args) {
        new EventBusTest();
    }


    static class MyIntegerEvent implements Event {

        private final Integer value;

        public MyIntegerEvent(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }


    static class MyStringEvent implements Event {

        private final String message;

        public MyStringEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

}
