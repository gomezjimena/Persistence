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
public class ModelEditTable extends AbstractTableModel {
    List<Product> products;
    String[] columnNames = {"Product Id","Name","Price" ,"Stock"};

    public ModelEditTable(List<Product> products) {
        this.products = products;
    }
    
    public List<Product> getProducts() {
        return products;
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
        return column != 0;
    }
    
    public Product getProductAtRow(int rowIndex) {
        // Verificar si el índice de fila está dentro de los límites de la tabla
        if (rowIndex >= 0 && rowIndex < products.size()) {
            return products.get(rowIndex); // Devolver el producto en la fila especificada
        } else {
            return null; // Si el índice está fuera de los límites, devolver null
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }
}
