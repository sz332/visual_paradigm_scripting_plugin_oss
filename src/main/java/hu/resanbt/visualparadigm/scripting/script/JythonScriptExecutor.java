package hu.resanbt.visualparadigm.scripting.script;

import com.vp.plugin.ApplicationManager;
import hu.resanbt.visualparadigm.scripting.vp.ModelHelper;
import org.python.util.PythonInterpreter;

import java.io.StringWriter;

public class JythonScriptExecutor implements ScriptExecutor {

    @Override
    public String getLanguage() {
        return "Python";
    }

    @Override
    public ScriptExecutionResult execute(String script) throws ScriptExecutionException {

        var errorStream = new StringWriter();

        try {

            var logger = new ScriptLogger();

            var interpreter = new PythonInterpreter();

            interpreter.set("app_manager", ApplicationManager.instance());
            interpreter.set("model_helper", new ModelHelper());
            interpreter.set("logger", logger);
            interpreter.setErr(errorStream);
            interpreter.exec(script);

            var evaluationResult = interpreter.get("result");
            var evaluationResultAsJava = new PythonResult(evaluationResult).asJava();

            return new ScriptExecutionResult(evaluationResultAsJava, logger.getLog());

        } catch (Exception e) {
            throw new JythonScriptExecutionException(e);
        }
    }

}
