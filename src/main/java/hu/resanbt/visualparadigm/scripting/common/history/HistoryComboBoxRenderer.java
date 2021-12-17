package hu.resanbt.visualparadigm.scripting.common.history;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SuppressWarnings({"squid:S3740"})
public class HistoryComboBoxRenderer extends JLabel implements ListCellRenderer {

    public HistoryComboBoxRenderer() {
        super();
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        HistoryRecord historyRecord = (HistoryRecord) value;

        if (historyRecord != null) {
            String decodedString = new String(Base64.getDecoder().decode(historyRecord.getScript()), StandardCharsets.UTF_8);
            setText(String.format("%.10s", decodedString));
            setToolTipText(String.format("%.200s", decodedString));
        } else {
            setText("");
        }

        setFont(list.getFont());

        return this;
    }
}
