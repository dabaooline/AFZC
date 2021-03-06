/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.UserInterface;

import flashablezipcreator.Adb.Adb;
import flashablezipcreator.DiskOperations.Read;
import flashablezipcreator.DiskOperations.Write;
import flashablezipcreator.Operations.JarOperations;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikhil
 */
public class FilterList extends javax.swing.JFrame {

    /**
     * Creates new form FilterListUI
     */
    public JDialog dialog;
    public ArrayList<String> filterList = new ArrayList<>();
    public ArrayList<String> phList = new ArrayList<>();

    public FilterList() {
        initComponents();
    }

    public FilterList(ArrayList<String> filterList) {
        this.filterList = filterList;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        this.phList.add("+/system/app/NovaLauncher/NovaLauncher.apk");
        this.phList.add("+/system/app/YouTube/*");
        this.phList.add("-/data/app/com.android.google/*");
        this.phList.add("-/system/media/audio");
        this.phList.add("+/system/media/audio/ui/tick.ogg");
        dialog = new JDialog(this, "Filter List", true);
        dialog.setResizable(false);
        panelMain = new javax.swing.JPanel();
        txtPath = new PHTextField(getPHText());
        jspListPath = new javax.swing.JScrollPane();
        model = new DefaultListModel();
        listPath = new javax.swing.JList(model);
        btnAdd = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        txtPath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        listPath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jspListPath.setViewportView(listPath);
        Adb.filteredFilePath = new ArrayList<>();
        File f = new File("FilterList");
        if (f.exists()) {
            Read r = new Read();
            try {
                String strToRead = r.getFileString(f.getAbsolutePath());
                for (String str : strToRead.split("\n")) {
                    Adb.filteredFilePath.add(str);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FilterList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Adb.filteredFilePath.forEach((path) -> {
            model.addElement(path);
        });
        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(this::btnAddActionPerformed);

        lblHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblHeader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Advanced Filter");

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.setContentAreaFilled(false);
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnRemove.setBackground(new java.awt.Color(255, 255, 255));
        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.setContentAreaFilled(false);
        btnRemove.addActionListener(this::btnRemoveActionPerformed);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                                .addContainerGap(36, Short.MAX_VALUE)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jspListPath, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addGap(169, 169, 169)
                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnRemove)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtPath, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(36, 36, 36))
        );
        panelMainLayout.setVerticalGroup(
                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jspListPath, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        dialog.getContentPane().add(panelMain);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dialog.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }// </editor-fold>     

    private String getPHText() {
        Random rand = new Random();
        int n = rand.nextInt(this.phList.size());
        return this.phList.get(n);
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        String text = txtPath.getText();
        if (text.startsWith("+") || text.startsWith("-")) {
            String indicator = text.charAt(0) + "";
            text = text.substring(1, text.length());
            if (text.startsWith("/")) {
                boolean flag = false;
                for (String path : this.filterList) {
                    if (text.startsWith(path + "/") && !text.equals(path + "/")) {
                        flag = true;
                    }
                }
                if (flag) {
                    text = indicator + " \"" + text + "\"";
                    model.addElement(text);
                    Adb.filteredFilePath.add(text);
                    txtPath.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Path!\nThe path should start with the partitions selected on Home page!\n"
                            + "Path should not be equal to patition selected on Home page!\n"
                            + "Save the list! Go Back! Select appropriate partition to add filter or try again with a different filter!");
                    txtPath.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "The path should start with / after indicator " + indicator + " is mentioned!");
                txtPath.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "The path should start with + or - indicating Inclusion or Exclusion of entered path!");
            txtPath.setText("");
        }
    }

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int i = listPath.getSelectedIndex();
            String elem = model.get(i).toString();
            Adb.filteredFilePath.remove(elem);
            model.remove(i);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Select an entry first!");
        }
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        Write w = new Write();
        File f = new File("FilterList");
        String strToWrite = "";
        if (Adb.filteredFilePath.size() > 0) {
            if (f.exists()) {
                int choice = JOptionPane.showConfirmDialog(this, "The file already exists,"
                        + " do you want to overwrite it?", "File Exists", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    try {
                        for (String path : Adb.filteredFilePath) {
                            strToWrite += path + "\n";
                        }
                        if (!strToWrite.equals("")) {
                            strToWrite = strToWrite.substring(0, strToWrite.length() - 1);
                            w.writeStringToFile(strToWrite, "FilterList");
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Nothing to Save!");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(FilterList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                try {
                    for (String path : Adb.filteredFilePath) {
                        strToWrite += path + "\n";
                    }
                    if (!strToWrite.equals("")) {
                        strToWrite = strToWrite.substring(0, strToWrite.length() - 1);
                        w.writeStringToFile(strToWrite, "FilterList");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Nothing to Save!");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FilterList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nothing to Save!");
        }
    }

//    public static void loadDeviceList() {		
//         for (String list : JarOperations.supported_devices.split("\n")) {		
//             if (list.contains("xxx")) {		
//                 deviceBlackList.add(list.substring(0, list.indexOf("_")));		
//             } else {		
//                 deviceWhiteList.add(list.substring(0, list.indexOf("_")));		
//             }		
//             list = list.substring(0, list.indexOf("_"));		
//             deviceList.add(list);		
//         }		
//     }
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jspListPath;
    private DefaultListModel model;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JList<String> listPath;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTextField txtPath;
    // End of variables declaration                   
}
