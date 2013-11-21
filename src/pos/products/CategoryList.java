/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos.products;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Box;
import pos.MainWindow;

/**
 *
 * @author ralph
 */
public class CategoryList extends javax.swing.JPanel {

    private final MainWindow mainWindow;

    /**
     * Creates new form CategoryList
     */
    public CategoryList(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initComponents();
        addCategories();
    }
    
    private void addCategories() {
        List<Category> cats = Category.findAll(mainWindow.getDbManager());
        for (final Category category : cats) {
            CategoryItem categoryItem = new CategoryItem(category);
            categoryItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mainWindow.showPanel(new ProductList(mainWindow, category));
                }
            });
            categories.add(categoryItem);
        }
        categories.add(Box.createVerticalGlue());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basket = new pos.orders.BasketPanel(mainWindow);
        categoriesScrollPane = new javax.swing.JScrollPane();
        categories = new javax.swing.JPanel();

        categories.setLayout(new javax.swing.BoxLayout(categories, javax.swing.BoxLayout.Y_AXIS));
        categoriesScrollPane.setViewportView(categories);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categoriesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(basket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoriesScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(basket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 124, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pos.orders.BasketPanel basket;
    private javax.swing.JPanel categories;
    private javax.swing.JScrollPane categoriesScrollPane;
    // End of variables declaration//GEN-END:variables
}
