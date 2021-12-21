package hu.resanbt.visualparadigm.scripting.usecase;

import com.athaydes.automaton.Swinger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * https://github.com/renatoathaydes/Automaton
 */
public class CloseDialogOnCloseButtonUseCaseTest {

    Swinger swinger;
    MainApp myApp;

    @Before
    public void setup() {
        myApp = new MainApp();
        myApp.start();

        swinger = Swinger.forSwingWindow();
    }

    @After
    public void tearDown() {
        myApp.getDialog().dispose();
    }

    @Test
    public void testFeature() {

        swinger.clickOn("closeButton");

        //swinger.clickOn( "closeButton" );

        //assertNotNull(myApp.getDialog());
    }

}
