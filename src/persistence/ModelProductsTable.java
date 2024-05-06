/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Lenovo
 */
public class ModelProductsTable extends AbstractTableModel{
    List<Product> products;
    private Integer productIdCounter;
    String[] columnNames = {"Product Id","Name","Price" ,"Stock"};

    public ModelProductsTable(List<Product> products) {
        this.products = products;
        this.productIdCounter = calculateMaxProductId() + 1;
    }
    
    private int calculateMaxProductId() {
        int maxId = 0;
        for (Product product : products) {
            if (product.getProductId() > maxId) { 
            }
        }
        return maxId;
    }

    public List<Product> getProducts() {
        return products;
    }
    
    public void readInformation() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("Products.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray productsArray = (JSONArray) jsonObject.get("list");

            for(int i = 0; i < productsArray.size(); i++) {
                Product product = new Product();
                JSONObject objectProductJSON = (JSONObject) productsArray.get(i);

                product.setProductId(((Long) objectProductJSON.get("Product Id")).intValue());
                product.setName((String) objectProductJSON.get("Name"));
                product.setPrice((Double) objectProductJSON.get("Price"));
                product.setStock(((Long) objectProductJSON.get("Stock")).intValue());

                this.products.add(product);   
            }
            
            adjustProductIdCounter();
        
        } catch(FileNotFoundException ex) {
            System.out.println("Error reading product file (FNF)" + ex);
        } catch(IOException ex) {
            System.out.println("Error reading product file (IOS)" + ex);
        } catch(ParseException ex) {
            System.out.println("Error reading product file (PE)" + ex);
        }
    }
    
    private void adjustProductIdCounter() {
        for (Product product : products) {
            if (product.getProductId() >= productIdCounter) {
                productIdCounter = product.getProductId() + 1;
            }
        }
    }
    
    public void WriteInformation(){
        if(!products.isEmpty()){
            
            JSONObject productsJSON = new JSONObject();
            JSONArray list = new JSONArray();
            
            for(int i = 0; i < products.size(); i++){
                
                JSONObject objtJSON = new JSONObject();
                
                objtJSON.put("Product Id", products.get(i).getProductId());
                objtJSON.put("Name", products.get(i).getName());
                objtJSON.put("Price", products.get(i).getPrice());
                objtJSON.put("Stock", products.get(i).getStock());
                
                list.add(objtJSON);
            }
            
            productsJSON.put("list", list);
            
            try(FileWriter file = new FileWriter("Products.json")){
                file.write(productsJSON.toString());
                file.flush();
            }catch (IOException ex){
                System.out.println("Error writing JSON file information " + ex);
            }
        }
    }
    
    public void addProduct(Product product){
        product.setProductId(productIdCounter); 
        products.add(product);
        productIdCounter++;
        this.fireTableDataChanged();
    }
    
    public void removeProduct(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < products.size()) {
            products.remove(rowIndex);

            for (int i = rowIndex; i < products.size(); i++) {
                products.get(i).setProductId(products.get(i).getProductId() - 1);
            }
            productIdCounter = productIdCounter - 1;
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }
    
    public void removeAll(){
        this.products.removeAll(products);
        productIdCounter = 1;
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

    public Product getProductAtRow(int rowIndex) {
        
        if (rowIndex >= 0 && rowIndex < products.size()) {
            return products.get(rowIndex); 
        } else {
            return null; 
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 0;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }
     
}
