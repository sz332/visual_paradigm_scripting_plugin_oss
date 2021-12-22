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
    public Object execute(String script) throws ScriptExecutionException {

        var errorStream = new StringWriter();

        try {
            PythonInterpreter interpreter = new PythonInterpreter();

            interpreter.set("app_manager", ApplicationManager.instance());
            interpreter.set("model_helper", new ModelHelper());
            interpreter.setErr(errorStream);
            interpreter.exec(script);

            var result = interpreter.get("result");

            return new PythonResult(result).asJava();

        } catch (Exception e) {
            throw new JythonScriptExecutionException(e);
        }
    }

}
