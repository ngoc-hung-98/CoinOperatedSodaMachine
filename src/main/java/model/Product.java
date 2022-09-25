package model;

import java.util.Optional;

public enum Product {
    COKE("Coke", 10000),
    PEPSI("Pepsi", 10000),
    SODA("Soda", 20000);

    private String name;
    private int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Optional<Product> hasProduct(String name){
        Product product = null;
        try{
            for(Product key : Product.values()){
                if(key.getName().trim().equalsIgnoreCase(name)){
                    product = key;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.ofNullable(product);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
