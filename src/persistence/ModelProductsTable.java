/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class ModelProductsTable extends AbstractTableModel{
    List<Product> products;
    String[] columnNames = {"Product Id","Name","Price" ,"Stock"};

    public ModelProductsTable(List<Product> products) {
        this.products = products;
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public void addProduct(Product product){
        this.products.add(product);
        this.fireTableDataChanged();
    }
    
    public void removeProduct(int rowIndex) {
    if (rowIndex >= 0 && rowIndex < products.size()) {
        products.remove(rowIndex);
        
        for (int i = rowIndex; i < products.size(); i++) {
            products.get(i).setProductId(i + 1); 
        }
        
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    }
    
    public void removeAll(){
        this.products.removeAll(products);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return this.products.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var product = this.products.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                product.getProductId();
            case 1 ->
                product.getName();
            case 2 ->
                product.getPrice();
            case 3 -> 
                product.getStock();
            default ->
                product;
        };
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }
     
}
