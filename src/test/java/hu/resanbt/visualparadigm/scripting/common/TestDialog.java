package hu.resanbt.visualparadigm.scripting.common;

import hu.resanbt.visualparadigm.scripting.ui.ScriptEditorDialog;

import javax.swing.*;

public class TestDialog {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            ScriptEditorDialog dialog = new ScriptEditorDialog(null);
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            dialog.setVisible(true);
        });
    }

}
