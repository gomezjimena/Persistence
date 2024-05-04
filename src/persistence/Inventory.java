/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package persistence;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Lenovo
 */
public final class Inventory extends javax.swing.JFrame {
    List<Product> products ;
    List<Product> productsl = new ArrayList<>();
    List<Product> products2;
    TableRowSorter<ModelProductsTable> tableRowSorter = new TableRowSorter<>();

    public List<Product> getProducts2() {
        return products2;
    }

    public void setProducts2(List<Product> products2) {
        this.products2 = products2;
    }
    
    /**
     * Creates new form Inventory
     */
    public Inventory() {
        initComponents();
        initObjects();
        empty();
        numericalEmpty();
        this.setProducts2(null);
        this.setLocationRelativeTo(null);
    }
    
    public Inventory(List<Product> editInventory) {
        initComponents();
        this.setProducts2(editInventory);
        initObjects();
        empty();
        numericalEmpty();
        this.setLocationRelativeTo(null);
    }

    private void initObjects() {
        if(this.getProducts2() == null){
            ModelProductsTable model = new ModelProductsTable(this.productsl);
            tableRowSorter = new TableRowSorter<>(model);

            tbl_products.setRowSorter(tableRowSorter);
            tbl_products.setModel(model);
        }else{
            products = new ArrayList<>();
        
            for (int i = 0; i < this.getProducts2().size(); i++) { 
                Product editInformation = new Product(i + 1, this.getProducts2().get(i).getName(), 
                     this.getProducts2().get(i).getPrice(), this.getProducts2().get(i).getStock());            
                products.add(editInformation);
            }
        
        ModelProductsTable model = new ModelProductsTable(this.products);
        tableRowSorter = new TableRowSorter<>(model);
        
        tbl_products.setModel(model);
        tbl_products.setRowSorter(tableRowSorter);
        }
    }
    
    private void empty(){
        txt_name.setText("");
        txt_price.setText("");
        txt_stock.setText("");
    }
    
    private void numericalEmpty(){
        txt_price.setText("");
        txt_stock.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_name = new javax.swing.JTextField();
        lbl_name = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        lbl_stock = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_deleteall = new javax.swing.JButton();
        scroll_products = new javax.swing.JScrollPane();
        tbl_products = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_name.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lbl_name.setText("Product Name: ");

        lbl_price.setText("Product Price: ");

        lbl_stock.setText("Product Stock: ");

        btn_add.setText("Add");
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_search.setText("Search");
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_deleteall.setText("Delete All");
        btn_deleteall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_deleteall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteallActionPerformed(evt);
            }
        });

        tbl_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scroll_products.setViewportView(tbl_products);

        btn_edit.setText("Edit");
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_name, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(txt_price)
                            .addComponent(txt_stock)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_search)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_deleteall)
                        .addGap(18, 18, 18)
                        .addComponent(btn_edit))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scroll_products, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_price))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_stock)
                    .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_add)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_delete)
                        .addComponent(btn_deleteall)
                        .addComponent(btn_edit)))
                .addGap(18, 18, 18)
                .addComponent(scroll_products, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (txt_name.getText().isEmpty() || txt_price.getText().isEmpty() || txt_stock.getText().isEmpty() ) {
        JOptionPane.showMessageDialog(this, "Fill out all the product information.",
                "Incomplete information", JOptionPane.ERROR_MESSAGE);
        }else if(!txt_price.getText().matches("\\d+") || !txt_stock.getText().matches("\\d+")){
            JOptionPane.showMessageDialog(this, "Price and stock must be numerical values and greater than zero.",
                "Wrong value", JOptionPane.ERROR_MESSAGE);
            numericalEmpty();
        }else {
            try {
            double price = Double.parseDouble(txt_price.getText());
            int stock = Integer.parseInt(txt_stock.getText());
            
            Product product = new Product();
            ModelProductsTable teamModel = (ModelProductsTable) this.tbl_products.getModel();
            
            product.setProductId(teamModel.getRowCount() + 1);
            product.setName(txt_name.getText());
            product.setPrice(price); 
            product.setStock(stock); 
            
            teamModel.addProduct(product);
            
            empty();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Price and stock must be numeric values.",
                "Invalid input", JOptionPane.ERROR_MESSAGE);
            numericalEmpty();
            }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        if(!txt_name.getText().isEmpty()){
            RowFilter<ModelProductsTable, Integer> rowFilter = RowFilter.regexFilter(txt_name.getText(), 1);
            tableRowSorter.setRowFilter(rowFilter);
            empty();
        }else if(!txt_price.getText().isEmpty()){
            RowFilter<ModelProductsTable, Integer> rowFilter = RowFilter.regexFilter(txt_price.getText(), 2);
            tableRowSorter.setRowFilter(rowFilter);
            empty();
        }else{
            RowFilter<ModelProductsTable, Integer> rowFilter = RowFilter.regexFilter(txt_stock.getText(), 3);
            tableRowSorter.setRowFilter(rowFilter);
            empty();
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if((txt_name.getText().isEmpty() && !txt_price.getText().isEmpty()) || (txt_name.getText().isEmpty() && 
                !txt_stock.getText().isEmpty())){
            JOptionPane.showMessageDialog(this, "You can only delete products by name.",
                "Invalid action", JOptionPane.ERROR_MESSAGE);
            numericalEmpty();
        }
        
        String productNameToRemove = txt_name.getText();
        
        ModelProductsTable teamModel = (ModelProductsTable) tbl_products.getModel();
    
        List<Product> productList = teamModel.getProducts();
        
        int indexToRemove = -1;
        for (int i = 0; i < productList.size(); i++) {
        Product product = productList.get(i);
            if (product.getName().equals(productNameToRemove)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            teamModel.removeProduct(indexToRemove);
        }
        
        txt_name.setText("");
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_deleteallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteallActionPerformed
        ModelProductsTable productModel = (ModelProductsTable) this.tbl_products.getModel();
        productModel.removeAll();
    }//GEN-LAST:event_btn_deleteallActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        if (productsl.isEmpty() && this.products == null) {
            JOptionPane.showMessageDialog(this, "There are no products to edit.",
                "Empty inventory", JOptionPane.ERROR_MESSAGE);
        } else if (this.products != null){
            EditInventory edit = new EditInventory(this.products);
            edit.setVisible(true);
            this.setVisible(false);
        }
        else {EditInventory edit = new EditInventory(this.productsl);
            edit.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btn_editActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Inventory().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_deleteall;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JScrollPane scroll_products;
    private javax.swing.JTable tbl_products;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_stock;
    // End of variables declaration//GEN-END:variables
}
