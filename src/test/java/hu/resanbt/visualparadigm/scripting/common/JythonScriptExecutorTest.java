package hu.resanbt.visualparadigm.scripting.common;

import hu.resanbt.visualparadigm.scripting.script.JythonScriptExecutor;
import hu.resanbt.visualparadigm.scripting.script.ScriptExecutionException;
import hu.resanbt.visualparadigm.scripting.script.ScriptExecutor;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JythonScriptExecutorTest {

    @Test
    public void testResultAsInt() throws ScriptExecutionException {
        ScriptExecutor executor = new JythonScriptExecutor();
        Object result = executor.execute("result = 23");

        Assert.assertEquals(Integer.valueOf(23), result);
    }

    @Test
    public void testResultAsString() throws ScriptExecutionException {
        ScriptExecutor executor = new JythonScriptExecutor();
        Object result = executor.execute("result = 'test'");

        Assert.assertEquals("test", result);
    }

    @Test
    public void testResultAsIntList() throws  ScriptExecutionException {
        ScriptExecutor executor = new JythonScriptExecutor();
        Object result = executor.execute("result = [1,2,3,4]");

        Assert.assertTrue(result instanceof List);
        Assert.assertEquals(4, ((List)result).size());
        Assert.assertArrayEquals(new Integer[]{1,2,3,4}, (((List)result)).toArray(new Integer[0]));
    }

}
