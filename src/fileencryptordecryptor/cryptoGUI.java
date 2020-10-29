package fileencryptordecryptor;


import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import static java.util.logging.Level.parse;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
public class cryptoGUI extends javax.swing.JFrame {


    public cryptoGUI() {
        initComponents();
        
       //Setting app icon
       ImageIcon ico = new ImageIcon("src/icon/icon.png");
       setIconImage(ico.getImage());
      
       
       //Initialize combo
       init_combo();
       
       jTable1.setModel(tableModel);
       
       //Setting focus when the app start running
       txt_inputE.requestFocus();
      
       
       //Setting app location to the center when the app start running
       setLocationRelativeTo(null);
    }
    
    //Create information method
    public void info(String input){
        JOptionPane.showMessageDialog(this,input,"Information",JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Create method to clear components
    public void clear(){
        txt_inputE.setText("");
        txt_inputD.setText("");
        txt_len.setText("");
        txt_outputD.setText("");
        txt_outputE.setText("");
        txt_maxlen.setText("");
        txt_num.setText("");
        cmb_alg.setSelectedItem("AES");
        
        info("Successfully Cleared");
        txt_inputE.requestFocus();
    }
    
    //Create method to initialize combobox
    public void init_combo(){
        comboModel.addElement("AES");
        comboModel.addElement("DES");
        comboModel.addElement("DESede");
        comboModel.addElement("BLOWFISH");
        cmb_alg.setModel(comboModel);
    }
    
    // Create method to initialize table
    public void init_table(){
        tableModel.addRow(new Object[] {txt_inputE.getText(),txt_outputE.getText(),String.valueOf(cmb_alg.getSelectedItem()),
                                        txt_len.getText()}); 
        jTable1.setModel(tableModel);
    }
    
    // Method to clear table
    public void clear_table(){
        
        int row = jTable1.getRowCount()-1;
        int i = row;
        
        while (i >= 0){
           tableModel.removeRow(i);
           i--;
        }
        jTable1.setModel(tableModel);
        
    }


    public void processE(){
         long start, end, result;
       int loop;
      
        if (txt_num.getText().isEmpty()){
            txt_num.setText("1");
        }
        
        loop= Integer.parseInt(txt_num.getText());
        start = System.currentTimeMillis();
        for(int i=0; i < loop; i++){
        try {
            //Create object of encryptdecryptclass
            encryptdecryptclass crypto = new encryptdecryptclass(txt_inputE.getText(), String.valueOf(cmb_alg.getSelectedItem()));
               
            // Show the encryption result 
           txt_outputE.setText(crypto.encrypt());
           txt_inputD.setText(crypto.encrypt());
            
            //Show the decryption result
           txt_outputD.setText(crypto.decrypt());
            
            //Show the key length of encryption result
            txt_len.setText(String.valueOf(crypto.len_key()));
            
            txt_maxlen.setText(String.valueOf(crypto.max_len(String.valueOf(cmb_alg.getSelectedItem()))));
            
            init_table();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        
        end = System.currentTimeMillis();
        
        result = (end - start)/1000;
        txt_time.setText("Total time: "+Float.parseFloat(String.valueOf(result))+" seconds");
        
        info("Successfully encrypted and stored at 'E:/encrypted'");
        
        txt_inputE.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_time = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        txt_inputE = new javax.swing.JTextField();
        txt_outputE = new javax.swing.JTextField();
        l2 = new javax.swing.JLabel();
        btn_process = new javax.swing.JButton();
        l4 = new javax.swing.JLabel();
        txt_maxlen = new javax.swing.JTextField();
        btn_clear = new javax.swing.JButton();
        l3 = new javax.swing.JLabel();
        txt_len = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmb_alg = new javax.swing.JComboBox<>();
        txt_num = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        txt_inputE1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        l5 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        txt_inputD = new javax.swing.JTextField();
        txt_outputD = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("D-Crypto");
        setIconImages(null);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txt_time.setFont(new java.awt.Font("Baloo Bhaina", 0, 14)); // NOI18N
        txt_time.setForeground(new java.awt.Color(0, 102, 255));
        txt_time.setMaximumSize(new java.awt.Dimension(208, 29));
        txt_time.setMinimumSize(new java.awt.Dimension(208, 29));
        txt_time.setPreferredSize(new java.awt.Dimension(208, 29));

        title2.setFont(new java.awt.Font("Baloo Bhaina", 0, 24)); // NOI18N
        title2.setText("File Encryptor/Decryptor");

        title.setFont(new java.awt.Font("Baloo Bhaina", 0, 24)); // NOI18N
        title.setText("Java Cryptography");

        jTabbedPane.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane.setFont(new java.awt.Font("Baloo Bhaina", 0, 14)); // NOI18N
        jTabbedPane.setMinimumSize(new java.awt.Dimension(622, 143));
        jTabbedPane.setPreferredSize(new java.awt.Dimension(622, 362));
        jTabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneMouseClicked(evt);
            }
        });

        l1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l1.setText("Your file data ");

        txt_inputE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_inputEActionPerformed(evt);
            }
        });

        txt_outputE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_outputEActionPerformed(evt);
            }
        });

        l2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l2.setText("Encryption Result");

        btn_process.setBackground(new java.awt.Color(0, 102, 255));
        btn_process.setFont(new java.awt.Font("Baloo Bhaina", 0, 14)); // NOI18N
        btn_process.setForeground(new java.awt.Color(255, 255, 255));
        btn_process.setLabel("Encrypt");
        btn_process.setMaximumSize(new java.awt.Dimension(100, 40));
        btn_process.setMinimumSize(new java.awt.Dimension(100, 40));
        btn_process.setPreferredSize(new java.awt.Dimension(100, 40));
        btn_process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_processActionPerformed(evt);
            }
        });
        btn_process.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_processKeyPressed(evt);
            }
        });

        l4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l4.setText("Maximum Key Length");

        btn_clear.setBackground(new java.awt.Color(255, 0, 51));
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.setMaximumSize(new java.awt.Dimension(100, 40));
        btn_clear.setMinimumSize(new java.awt.Dimension(100, 40));
        btn_clear.setPreferredSize(new java.awt.Dimension(100, 40));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l3.setText("Current Key Length");

        txt_len.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Choose Algorithm");

        cmb_alg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_algActionPerformed(evt);
            }
        });

        txt_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("No.of Encryption");

        l7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l7.setText("Enter path of file");

        txt_inputE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_inputE1ActionPerformed(evt);
            }
        });

        jButton4.setText("Read File");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(l4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txt_maxlen, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_len, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_outputE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(l7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_inputE1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_inputE, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_alg, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(btn_process, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)))
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))))
                    .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l7)
                    .addComponent(txt_inputE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_inputE, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(l1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_alg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_process, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l2)
                    .addComponent(txt_outputE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l3)
                    .addComponent(txt_len, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maxlen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l4))
                .addContainerGap())
        );

        btn_process.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane.addTab("Encryption", jPanel5);

        l5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l5.setText("Key to Decrypt");

        l6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l6.setText("Output (Plain Text)");

        jButton9.setBackground(new java.awt.Color(255, 51, 51));
        jButton9.setFont(new java.awt.Font("Baloo Bhaina", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Clear");
        jButton9.setMaximumSize(new java.awt.Dimension(100, 40));
        jButton9.setMinimumSize(new java.awt.Dimension(100, 40));
        jButton9.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        txt_inputD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_inputDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(l6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(txt_outputD, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(l5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_inputD, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_inputD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l5))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_outputD, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l6))
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Decryption", jPanel6);

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 319));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Baloo Bhaina", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear History");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 102));
        jButton2.setFont(new java.awt.Font("Baloo Bhaina", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Export to Excel");
        jButton2.setMaximumSize(new java.awt.Dimension(117, 37));
        jButton2.setMinimumSize(new java.awt.Dimension(117, 37));
        jButton2.setPreferredSize(new java.awt.Dimension(117, 37));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 379, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("History", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txt_time, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(430, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(232, 232, 232))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title2)
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_inputEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_inputEActionPerformed
    }//GEN-LAST:event_txt_inputEActionPerformed

    private void btn_processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_processActionPerformed

        processE();
        String str;
        FileWriter myWriter;
        try {
            
      File myObj = new File("E:/fileEnc.txt.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        try {
            myWriter = new FileWriter("E:/encrypted.txt");
            str=txt_inputD.getText();
            myWriter.write(str);
            System.out.println(txt_inputD.getText());
            myWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(cryptoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      System.out.println("Successfully wrote to the file.");

    }//GEN-LAST:event_btn_processActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        //Clear all component
        if (txt_outputE.getText().equalsIgnoreCase("")){
        }
        else{
            clear();
        }
    }//GEN-LAST:event_btn_clearActionPerformed

    private void jTabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPaneMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
               
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int question = JOptionPane.showConfirmDialog(this, "Are you sure want to clear the history?","Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (question == 0){
        clear_table();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
 
        
        
      
    }//GEN-LAST:event_formComponentShown

    private void txt_lenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lenActionPerformed

    }//GEN-LAST:event_txt_lenActionPerformed

    private void txt_outputEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_outputEActionPerformed

    }//GEN-LAST:event_txt_outputEActionPerformed

    private void btn_processKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_processKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            processE();
        }
    }//GEN-LAST:event_btn_processKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        print_class p = new print_class();
        p.setSource(jTable1);
        p.setFile("E:\\Cryptography.xls");
        p.setReport_Title("Cryptography Details");
        p.setPosition(1);
        p.print_excel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numActionPerformed

    private void txt_inputDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_inputDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_inputDActionPerformed

    private void cmb_algActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_algActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_algActionPerformed

    private void txt_inputE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_inputE1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_inputE1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            BufferedReader reader = null;
            
            StringBuilder records= new StringBuilder();
            reader = new BufferedReader(new FileReader(txt_inputE1.getText()));
            String line;
            while ((line = reader.readLine()) != null)
            {
                records.append(line);
            }
            txt_inputE.setText(records.toString());
        } catch (FileNotFoundException ex) {
            info(ex.getMessage());
        } catch (IOException ex) {
             info(ex.getMessage());
        }
           
            
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //Clear all component
        if (txt_outputE.getText().equalsIgnoreCase("")){
        }
        else{
            clear();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    
    public static void main(String args[]) throws Exception {
 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cryptoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cryptoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cryptoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cryptoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //Setting look and feel using jTatto library
       //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
       //SwingUtilities.updateComponentTreeUI(new cryptoGUI());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cryptoGUI().setVisible(true);
            }
        });
          
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_process;
    private javax.swing.JComboBox<String> cmb_alg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title2;
    private javax.swing.JTextField txt_inputD;
    private javax.swing.JTextField txt_inputE;
    private javax.swing.JTextField txt_inputE1;
    private javax.swing.JTextField txt_len;
    private javax.swing.JTextField txt_maxlen;
    private javax.swing.JTextField txt_num;
    private javax.swing.JTextField txt_outputD;
    private javax.swing.JTextField txt_outputE;
    private javax.swing.JLabel txt_time;
    // End of variables declaration//GEN-END:variables
    int row = 0;
    static Object[] col = {"Plaintext", "Ciphertext", "Algorithm Used", "Key Length"};
    DefaultTableModel tableModel = new DefaultTableModel(col,row);
    DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
}
