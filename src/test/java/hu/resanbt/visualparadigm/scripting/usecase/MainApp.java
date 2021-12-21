package hu.resanbt.visualparadigm.scripting.usecase;

import hu.resanbt.visualparadigm.scripting.ui.ScriptEditorDialog;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class MainApp {

    private ScriptEditorDialog dialog;

    public void start() {

        try {

            SwingUtilities.invokeAndWait(() -> {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                dialog = new ScriptEditorDialog(null);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                dialog.setVisible(true);
            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ScriptEditorDialog getDialog(){
        return dialog;
    }


}
