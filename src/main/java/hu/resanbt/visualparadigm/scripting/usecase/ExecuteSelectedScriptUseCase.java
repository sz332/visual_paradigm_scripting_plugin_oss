package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.result.CastedList;
import hu.resanbt.visualparadigm.scripting.common.result.ListResult;
import hu.resanbt.visualparadigm.scripting.common.result.TabularResult;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.*;
import hu.resanbt.visualparadigm.scripting.script.ScriptExecutionException;
import hu.resanbt.visualparadigm.scripting.script.ScriptExecutor;

public class ExecuteSelectedScriptUseCase implements UseCase {

    private final EventBus eventBus;
    private final ScriptExecutor executor;

    public ExecuteSelectedScriptUseCase(EventBus eventBus, ScriptExecutor executor) {
        this.eventBus = eventBus;
        this.executor = executor;
        eventBus.subscribe(ScriptExecutionRequestedEvent.class, this::onScriptExecutionRequested);
    }

    private void onScriptExecutionRequested(ScriptExecutionRequestedEvent event) {
        try {
            Object value = executor.execute(event.getScript());

            if (value == null) {
                eventBus.publish(new EmptyResultCreatedEvent());
            } else if (value instanceof ListResult) {
                eventBus.publish(new ListResultCreatedEvent(((ListResult) value).asList()));
            } else if (value instanceof TabularResult) {
                eventBus.publish(new TabularResultCreatedEvent((TabularResult) value));
            } else if (value instanceof Iterable || isArray(value)) {
                CastedList.of(value).ifPresent(list -> eventBus.publish(new ListResultCreatedEvent(list.asList())));
            } else {
                eventBus.publish(new StringResultCreatedEvent(value.toString()));
            }

        } catch (ScriptExecutionException e) {
            eventBus.publish(new ScriptExecutionFailedEvent(e));
        } catch (Exception e) {
            eventBus.publish(new ExceptionOccurredEvent(e));
        }
    }

    private boolean isArray(Object array) {
        return array != null && (array.getClass().isArray());
    }

}
