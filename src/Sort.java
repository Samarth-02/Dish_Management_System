
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Samarth
 *
 *
 */
class DishData {

    String index, ID, dishName, prize, quality;

    public DishData(String index, String ID, String dishName, String prize, String quality) {
        this.index = index;
        this.ID = ID;
        this.dishName = dishName;
        this.prize = prize;
        this.quality = quality;
    }
}

class indCompare implements Comparator<DishData> {

    @Override
    public int compare(DishData s1, DishData s2) {
        return s2.index.compareTo(s1.index);
    }
}

class idCompare implements Comparator<DishData> {

    @Override
    public int compare(DishData s1, DishData s2) {
        return s2.ID.compareTo(s1.ID);
    }
}

//dishNameCompare Class to compare the names
class dishNameCompare implements Comparator<DishData> {

    @Override
    public int compare(DishData s1, DishData s2) {
        return s2.dishName.compareTo(s1.dishName);
    }
}
//prizeCompare Class to compare the names

class prizeCompare implements Comparator<DishData> {

    @Override
    public int compare(DishData s1, DishData s2) {
        return s2.prize.compareTo(s1.prize);
    }
}
//qualityCompare Class to compare the names

class qualityCompare implements Comparator<DishData> {

    @Override
    public int compare(DishData s1, DishData s2) {
        return s2.quality.compareTo(s1.quality);
    }
}

public class Sort extends javax.swing.JInternalFrame {

    /**
     * Creates new form Search
     */
    public Sort() {
        initComponents();
        try {
            BufferedReader brSearch1 = new BufferedReader(new FileReader("MenuList.txt"));
            String key[] = new String[1024];
            String search;
            Object columns[] = {"ID", "NAME", "PRICE", "QUALITY"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);
            jTable1.setModel(model);
            Object row[] = new Object[4];
            while ((search = brSearch1.readLine()) != null) {

                key = search.split(",");
                row[0] = key[1];
                row[1] = key[2];
                row[2] = key[3];
                row[3] = key[4];
                model.addRow(row);
            }
            brSearch1.close();
        } catch (Exception ex) {
            System.out.println("Exception msg: " + ex);
        }
    }

    public boolean sort(idCompare id_cmp) {
        File file;
        boolean check = false;
        try {
            file = new File("MenuList.txt");

            //Creating BufferedReader object to read the input text file
            BufferedReader reader = new BufferedReader(new FileReader(file));

            //Creating ArrayList to hold DishData objects
            ArrayList<DishData> dishRecords = new ArrayList<DishData>();

            //Reading DishData records one by one
            String currentLine = reader.readLine();

            while (currentLine != null) {
                String[] dishDetail = currentLine.split(",");
                String index = dishDetail[0];
                String ID = dishDetail[1];
                String dishName = dishDetail[2];
                String prize = dishDetail[3];
                String quality = dishDetail[4];

                //Creating DishData object for every DishData record and adding it to ArrayList
                dishRecords.add(new DishData(index, ID, dishName, prize, quality));

                currentLine = reader.readLine();
            }

            //Sorting ArrayList dishRecords based on marks
            Collections.sort(dishRecords, id_cmp.reversed());

            //Creating BufferedWriter object to write into output text file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            //Writing every dishRecords into output text file
            for (DishData dishData : dishRecords) {
                writer.write(dishData.index);
                writer.write("," + dishData.ID);
                writer.write("," + dishData.dishName);
                writer.write("," + dishData.prize);
                writer.write("," + dishData.quality);

                //writer.write("," + dishData.IDno);
                writer.newLine();
            }

            //Closing the resources
            reader.close();
            writer.close();

        } catch (Exception ex) {
            System.out.println("Exception msg: " + ex);
        }
        return true;

    }

    public boolean sort(dishNameCompare dish_cmp) {
        File file;
        boolean check = false;
        try {
            file = new File("MenuList.txt");

            //Creating BufferedReader object to read the input text file
            BufferedReader reader = new BufferedReader(new FileReader(file));

            //Creating ArrayList to hold DishData objects
            ArrayList<DishData> dishRecords = new ArrayList<DishData>();

            //Reading DishData records one by one
            String currentLine = reader.readLine();

            while (currentLine != null) {
                String[] dishDetail = currentLine.split(",");
                String index = dishDetail[0];
                String ID = dishDetail[1];
                String dishName = dishDetail[2];
                String prize = dishDetail[3];
                String quality = dishDetail[4];

                //Creating DishData object for every DishData record and adding it to ArrayList
                dishRecords.add(new DishData(index, ID, dishName, prize, quality));

                currentLine = reader.readLine();
            }

            //Sorting ArrayList dishRecords based on marks
            Collections.sort(dishRecords, dish_cmp.reversed());

            //Creating BufferedWriter object to write into output text file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            //Writing every dishRecords into output text file
            for (DishData dishData : dishRecords) {
                writer.write(dishData.index);
                writer.write("," + dishData.ID);
                writer.write("," + dishData.dishName);
                writer.write("," + dishData.prize);
                writer.write("," + dishData.quality);

                //writer.write("," + dishData.IDno);
                writer.newLine();
            }

            //Closing the resources
            reader.close();
            writer.close();

        } catch (Exception ex) {
            System.out.println("Exception msg: " + ex);
        }
        return true;

    }

    public boolean sort(prizeCompare prize_cmp) {
        File file;
        boolean check = false;
        try {
            file = new File("MenuList.txt");

            //Creating BufferedReader object to read the input text file
            BufferedReader reader = new BufferedReader(new FileReader(file));

            //Creating ArrayList to hold DishData objects
            ArrayList<DishData> dishRecords = new ArrayList<DishData>();

            //Reading DishData records one by one
            String currentLine = reader.readLine();

            while (currentLine != null) {
                String[] dishDetail = currentLine.split(",");
                String index = dishDetail[0];
                String ID = dishDetail[1];
                String dishName = dishDetail[2];
                String prize = dishDetail[3];
                String quality = dishDetail[4];

                //Creating DishData object for every DishData record and adding it to ArrayList
                dishRecords.add(new DishData(index, ID, dishName, prize, quality));

                currentLine = reader.readLine();
            }

            //Sorting ArrayList dishRecords based on marks
            Collections.sort(dishRecords, prize_cmp.reversed());

            //Creating BufferedWriter object to write into output text file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.flush();

            //Writing every dishRecords into output text file
            for (DishData dishData : dishRecords) {
                writer.write(dishData.index);
                writer.write("," + dishData.ID);
                writer.write("," + dishData.dishName);
                writer.write("," + dishData.prize);
                writer.write("," + dishData.quality);

                //writer.write("," + dishData.IDno);
                writer.newLine();
            }

            //Closing the resources
            reader.close();
//            writer.flush();
            writer.close();

        } catch (Exception ex) {
            System.out.println("Exception msg: " + ex);
        }
        return true;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sort Dish");
        setMinimumSize(new java.awt.Dimension(122, 34));
        setPreferredSize(new java.awt.Dimension(594, 566));

        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(578, 532));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Sort Dish");
        jLabel1.setMaximumSize(new java.awt.Dimension(108, 29));
        jLabel1.setMinimumSize(new java.awt.Dimension(108, 29));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "PRICE" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Sort");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PRICE", "QUALITY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jButton1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Sort sor = new Sort();
        int item = jComboBox1.getSelectedIndex();
        if (item == 0) {
            sor.sort(new idCompare());
        }
        if (item == 1) {
            sor.sort(new dishNameCompare());
        }
        if (item == 2) {
            sor.sort(new prizeCompare());
        }
        try {
            BufferedReader brSearch1 = new BufferedReader(new FileReader("MenuList.txt"));
            String key[] = new String[1024];
            String search;
            Object columns[] = {"ID", "NAME", "PRICE", "QUALITY"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);
            jTable1.setModel(model);
            Object row[] = new Object[4];
            while ((search = brSearch1.readLine()) != null) {

                key = search.split(",");
                row[0] = key[1];
                row[1] = key[2];
                row[2] = key[3];
                row[3] = key[4];
                model.addRow(row);
            }
            brSearch1.close();
        } catch (Exception ex) {
            System.out.println("Exception msg: " + ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
