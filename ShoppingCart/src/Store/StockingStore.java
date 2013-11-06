package Store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author giacomo
 * Class StockingStore
 * Responsible for reading from files and populating a Map with List's containing the different Product Types mapped to a ProductType enum
 * 
 */
public class StockingStore {

    private Map<ProductType, List<Product>> productTypeToSelectionOfProductsMap = new HashMap<ProductType, List<Product>>();
    private Map<ProductType, ProductFactory<? extends Product>> productTypeToProductFactoryMap = 
                                new HashMap<ProductType, ProductFactory<? extends Product>>();

    /**
     * no-args constructor, responsible for mapping Factories to a ProductType enum and to then populate another 
     * Map with Lists containing the all products for that enum type
     */
    public StockingStore() {
        productTypeToProductFactoryMap.put(ProductType.DESKTOP, new DesktopFactory());
        productTypeToProductFactoryMap.put(ProductType.LAPTOP, new LaptopFactory());
        productTypeToProductFactoryMap.put(ProductType.MONITOR, new MonitorFactory());
        productTypeToProductFactoryMap.put(ProductType.KEYBOARD, new KeyboardFactory());
        productTypeToProductFactoryMap.put(ProductType.MOUSE, new MouseFactory());
        
        for (ProductType productType : ProductType.values()) {
            productTypeToSelectionOfProductsMap.put(productType, readItemsFromFile(productType));
        }
    }

    /**
     * Method readItemsFromFile
     * Method to read data from a file and construct an ArrayList containing Products produced from that information
     * 
     * @param productType
     * Enum containing the type of product to be read from file.
     * @return ArrayList containing Porducts which have been created from the file information
     */
    private ArrayList<Product> readItemsFromFile(ProductType productType) {
        BufferedReader br = null;
        ArrayList<Product> resultantProducts = new ArrayList<Product>();
        try {
            br = new BufferedReader(new FileReader(productType.getDisplayValue()));
            String lineRead;
            while ((lineRead = br.readLine()) != null) {
                String[] productSpecifications = lineRead.split(",");
                resultantProducts.add(productTypeToProductFactoryMap.get(productType)
                                                                    .createProduct(productSpecifications));
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                br.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return resultantProducts;
    }
    
    Map<ProductType, List<Product>> getProductTypesToSelectionOfProductsMap() {
        return productTypeToSelectionOfProductsMap;
    }
}
