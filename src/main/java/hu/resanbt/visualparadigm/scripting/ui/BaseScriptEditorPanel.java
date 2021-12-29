/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hu.resanbt.visualparadigm.scripting.ui;

/**
 * @author zsolt
 */
@SuppressWarnings({"squid:S1604", "squid:SS1172", "squid:S1450", "squid:S1172", "squid:S1135"})
public class BaseScriptEditorPanel extends javax.swing.JPanel {

    /**
     * Creates new form MyScriptEditorPanel
     */
    public BaseScriptEditorPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        splitPanel = new javax.swing.JSplitPane();
        scriptPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        languageComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        executeButton = new javax.swing.JButton();
        scriptTextScrollPane = new org.fife.ui.rtextarea.RTextScrollPane();
        scriptTextArea = new org.fife.ui.rsyntaxtextarea.RSyntaxTextArea();
        helpButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        historyComboBox = new javax.swing.JComboBox<>();
        appendToHistoryButton = new javax.swing.JButton();
        resultPanel = new javax.swing.JPanel();
        resultTabbedPane = new javax.swing.JTabbedPane();
        tableResultPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        exportButton = new javax.swing.JButton();
        tableFilterTextField = new javax.swing.JTextField();
        textualResultPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        logResultPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();
        bottomPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();

        topPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        splitPanel.setBorder(null);
        splitPanel.setDividerLocation(600);

        jLabel1.setText("Language:");

        languageComboBox.setName("languageComboBox"); // NOI18N

        jLabel2.setText("Script:");

        executeButton.setText("Execute");
        executeButton.setName("executeButton"); // NOI18N

        scriptTextArea.setColumns(20);
        scriptTextArea.setRows(5);
        scriptTextArea.setName("scriptTextArea"); // NOI18N
        scriptTextScrollPane.setViewportView(scriptTextArea);

        helpButton.setText("Help");
        helpButton.setName("helpButton"); // NOI18N

        jLabel4.setText("History:");

        historyComboBox.setName("historyComboBox"); // NOI18N
        historyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyComboBoxActionPerformed(evt);
            }
        });

        appendToHistoryButton.setText("Append");
        appendToHistoryButton.setName("appendToHistoryButton"); // NOI18N

        javax.swing.GroupLayout scriptPanelLayout = new javax.swing.GroupLayout(scriptPanel);
        scriptPanel.setLayout(scriptPanelLayout);
        scriptPanelLayout.setHorizontalGroup(
            scriptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriptPanelLayout.createSequentialGroup()
                .addGroup(scriptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scriptTextScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(scriptPanelLayout.createSequentialGroup()
                        .addComponent(executeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(helpButton))
                    .addGroup(scriptPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(scriptPanelLayout.createSequentialGroup()
                        .addGroup(scriptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(scriptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(scriptPanelLayout.createSequentialGroup()
                                .addComponent(historyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)
                                .addComponent(appendToHistoryButton))
                            .addComponent(languageComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        scriptPanelLayout.setVerticalGroup(
            scriptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriptPanelLayout.createSequentialGroup()
                .addGroup(scriptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(historyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appendToHistoryButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scriptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scriptTextScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scriptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(executeButton)
                    .addComponent(helpButton)))
        );

        splitPanel.setLeftComponent(scriptPanel);

        outputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        outputTable.setName("outputTable"); // NOI18N
        jScrollPane1.setViewportView(outputTable);

        jLabel5.setText("Filter:");

        exportButton.setText("Export...");
        exportButton.setName("exportButton"); // NOI18N

        tableFilterTextField.setName("tableFilterTextField"); // NOI18N

        javax.swing.GroupLayout tableResultPanelLayout = new javax.swing.GroupLayout(tableResultPanel);
        tableResultPanel.setLayout(tableResultPanelLayout);
        tableResultPanelLayout.setHorizontalGroup(
            tableResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableResultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tableResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(tableResultPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tableFilterTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportButton)))
                .addContainerGap())
        );
        tableResultPanelLayout.setVerticalGroup(
            tableResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableResultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tableResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tableFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportButton))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        resultTabbedPane.addTab("Table result", tableResultPanel);

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        outputTextArea.setName("outputTextArea"); // NOI18N
        jScrollPane2.setViewportView(outputTextArea);

        javax.swing.GroupLayout textualResultPanelLayout = new javax.swing.GroupLayout(textualResultPanel);
        textualResultPanel.setLayout(textualResultPanelLayout);
        textualResultPanelLayout.setHorizontalGroup(
            textualResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textualResultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );
        textualResultPanelLayout.setVerticalGroup(
            textualResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textualResultPanelLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        resultTabbedPane.addTab("Textual result", textualResultPanel);

        logTextArea.setColumns(20);
        logTextArea.setRows(5);
        logTextArea.setName("outputTextArea"); // NOI18N
        jScrollPane3.setViewportView(logTextArea);

        javax.swing.GroupLayout logResultPanelLayout = new javax.swing.GroupLayout(logResultPanel);
        logResultPanel.setLayout(logResultPanelLayout);
        logResultPanelLayout.setHorizontalGroup(
            logResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logResultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addContainerGap())
        );
        logResultPanelLayout.setVerticalGroup(
            logResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logResultPanelLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        resultTabbedPane.addTab("Log", logResultPanel);

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultTabbedPane))
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        splitPanel.setRightComponent(resultPanel);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPanel)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPanel)
                .addContainerGap())
        );

        closeButton.setText("Close");
        closeButton.setName("closeButton"); // NOI18N

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeButton))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void historyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_historyComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton appendToHistoryButton;
    private javax.swing.JPanel bottomPanel;
    protected javax.swing.JButton closeButton;
    protected javax.swing.JButton executeButton;
    protected javax.swing.JButton exportButton;
    protected javax.swing.JButton helpButton;
    protected javax.swing.JComboBox<String> historyComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    protected javax.swing.JComboBox<String> languageComboBox;
    protected javax.swing.JPanel logResultPanel;
    protected javax.swing.JTextArea logTextArea;
    protected javax.swing.JTable outputTable;
    protected javax.swing.JTextArea outputTextArea;
    private javax.swing.JPanel resultPanel;
    protected javax.swing.JTabbedPane resultTabbedPane;
    private javax.swing.JPanel scriptPanel;
    protected org.fife.ui.rsyntaxtextarea.RSyntaxTextArea scriptTextArea;
    protected org.fife.ui.rtextarea.RTextScrollPane scriptTextScrollPane;
    private javax.swing.JSplitPane splitPanel;
    protected javax.swing.JTextField tableFilterTextField;
    private javax.swing.JPanel tableResultPanel;
    protected javax.swing.JPanel textualResultPanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
