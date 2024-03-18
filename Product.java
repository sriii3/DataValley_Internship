import java.io.*;

class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public void printDetails() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Product Category: " + category);
        System.out.println("Product Price: " + price);
    }
}

public class Main {
    public static void main(String[] args) {
        
        Product product = new Product(101, "Laptop", "Electronics", 999.99);
        serializeProduct(product);

        
        Product deserializedProduct = deserializeProduct();
        System.out.println("Deserialized Product Details:");
        deserializedProduct.printDetails();
    }

    private static void serializeProduct(Product product) {
        try {
            FileOutputStream fileOut = new FileOutputStream("product.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(product);
            objectOut.close();
            fileOut.close();
            System.out.println("Product serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Product deserializeProduct() {
        Product product = null;
        try {
            FileInputStream fileIn = new FileInputStream("product.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            product = (Product) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }
}
