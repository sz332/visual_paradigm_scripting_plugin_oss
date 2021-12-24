package hu.resanbt.visualparadigm.scripting;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.ViewManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import hu.resanbt.visualparadigm.scripting.ui.ScriptEditorDialog;

import javax.swing.*;
import java.awt.*;

public class ScriptEditorController implements VPActionController {

    @Override
    public void performAction(VPAction vpAction) {
        var viewManager = ApplicationManager.instance().getViewManager();
        var parentFrame = viewManager.getRootFrame();

        var rootFrame = (JFrame) SwingUtilities.getRoot(parentFrame);

        var dialog = new ScriptEditorDialog(rootFrame);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(rootFrame);

        dialog.setVisible(true);
    }

    @Override
    public void update(VPAction vpAction) {
        // not needed
    }
}
