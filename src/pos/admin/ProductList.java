/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos.admin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Box;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pos.MainWindow;
import pos.products.Product;
import pos.products.ProductDetails;
import pos.products.ProductItem;

/**
 *
 * @author ralph
 */
public class ProductList extends javax.swing.JPanel {
    private final MainWindow mainWindow;

    /**
     * Creates new form ProductList
     */
    public ProductList(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initComponents();
        addProducts();
    }
    
    private void addProducts() {
        List<Product> products = Product.findAll(mainWindow.getDbManager());
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        for (Product product : products) {
            model.addRow(new Object[]{product.getId(), product.getName(), product.getDescription(),
                java.text.NumberFormat.getCurrencyInstance(java.util.Locale.GERMANY).format(product.getPrice() / 100.0),
                product.getStock(), product.getCategory().getName()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        addCategoryBtn = new javax.swing.JButton();
        removeProductBtn = new javax.swing.JButton();
        editProductBtn = new javax.swing.JButton();
        addProductBtn = new javax.swing.JButton();

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Description", "Price", "Stock", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);

        addCategoryBtn.setText("Add Category ...");

        removeProductBtn.setText("Remove Product ...");

        editProductBtn.setText("Edit Product ...");

        addProductBtn.setText("Add Product ...");
        addProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 92, Short.MAX_VALUE)
                        .addComponent(addProductBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editProductBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeProductBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCategoryBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCategoryBtn)
                    .addComponent(removeProductBtn)
                    .addComponent(editProductBtn)
                    .addComponent(addProductBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtnActionPerformed
        mainWindow.showPanel(new AddProduct(mainWindow));
    }//GEN-LAST:event_addProductBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCategoryBtn;
    private javax.swing.JButton addProductBtn;
    private javax.swing.JButton editProductBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productTable;
    private javax.swing.JButton removeProductBtn;
    // End of variables declaration//GEN-END:variables
}
