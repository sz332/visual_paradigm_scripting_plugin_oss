package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.common.eventbus.EventBus;
import hu.resanbt.visualparadigm.scripting.common.result.CastedList;
import hu.resanbt.visualparadigm.scripting.common.result.ListResult;
import hu.resanbt.visualparadigm.scripting.common.result.TabularResult;
import hu.resanbt.visualparadigm.scripting.common.usecase.UseCase;
import hu.resanbt.visualparadigm.scripting.event.*;
import hu.resanbt.visualparadigm.scripting.script.ExecutorNotFoundException;
import hu.resanbt.visualparadigm.scripting.script.ScriptExecutionException;
import hu.resanbt.visualparadigm.scripting.script.ScriptExecutor;

import java.util.List;

public class ExecuteSelectedScriptUseCase implements UseCase {

    private final EventBus eventBus;
    private final List<ScriptExecutor> executors;

    public ExecuteSelectedScriptUseCase(EventBus eventBus, List<ScriptExecutor> executors) {
        this.eventBus = eventBus;
        this.executors = executors;
        eventBus.subscribe(ScriptExecutionRequestedEvent.class, this::onScriptExecutionRequested);
    }

    private void onScriptExecutionRequested(ScriptExecutionRequestedEvent event) {
        try {

            var language = event.getLanguage();

            var executor = executors
                    .stream()
                    .filter(e -> e.getLanguage().equals(event.getLanguage()))
                    .findFirst()
                    .orElseThrow(ExecutorNotFoundException::new);

            var executionResult = executor.execute(event.getScript());

            var result = executionResult.getResult();

            if (result == null) {
                eventBus.publish(new EmptyResultCreatedEvent());
            } else if (result instanceof ListResult) {
                eventBus.publish(new ListResultCreatedEvent(((ListResult) result).asList()));
            } else if (result instanceof TabularResult) {
                eventBus.publish(new TabularResultCreatedEvent((TabularResult) result));
            } else if (result instanceof Iterable || isArray(result)) {
                CastedList.of(result).ifPresent(list -> eventBus.publish(new ListResultCreatedEvent(list.asList())));
            } else {
                eventBus.publish(new StringResultCreatedEvent(result.toString()));
            }

            if (!executionResult.getLog().isEmpty()) {
                eventBus.publish(new ScriptLogCreatedEvent(executionResult.getLog()));
            }

        } catch (ScriptExecutionException e) {
            eventBus.publish(new ScriptExecutionFailedEvent(e));
        } catch (ExecutorNotFoundException e) {
            eventBus.publish(new ExecutorNotFoundEvent(e));
        } catch (Exception e) {
            eventBus.publish(new ExceptionOccurredEvent(e));
        }
    }

    private boolean isArray(Object array) {
        return array != null && (array.getClass().isArray());
    }

}
