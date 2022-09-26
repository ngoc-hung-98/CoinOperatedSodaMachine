package machine;

import exception.NoFullPaidException;
import exception.NoSufficientChangeException;
import generic.Item;
import model.Coin;
import model.Product;
import state.*;

import java.util.*;

public class SodaMachine implements ISodaMachine {
    private Item<Product> products = new Item<>();
    private Item<Coin> coins = new Item<>();
    private State noCoinInserted;
    private State coinInserted;
    private State productSelected;
    private State productSold;
    private State soldOut;
    private State currentState = soldOut; // Trạng thái ban đầu của máy (giả sử ban đầu máy trống chưa có hàng)

    private Product currentProduct; // Sản phẩm người dùng muốn mua

    private List<Integer> coinUserInserted = new ArrayList<>(); // Coin của người dùng insert vào máy

    public SodaMachine() {
        init();
        System.out.println("Product avaiable");
        showProductAvaiable();
        noCoinInserted = new NoCoinInserted(this);
        coinInserted = new CoinInserted(this);
        productSelected = new ProductSelected(this);
        productSold = new ProductSold(this);
        soldOut = new SoldOut(this);
        if (products.getSize() > 0) {
            currentState = noCoinInserted;
        }
    }

    public void init() {
        products.put(Product.COKE, 4);
        products.put(Product.PEPSI, 10);
        products.put(Product.SODA, 8);
    }

    private void showProductAvaiable() {
        for (Product product : products.getItems().keySet()) {
            int quantity = products.getItems().get(product);
            System.out.println(product.getName() + " --- price: " + product.getPrice() + " --- quantity: " + quantity);
        }
    }

    @Override
    public void insertCoin(int coin) {
        currentState.insertCoin(coin);
    }

    @Override
    public void selectProduct(String name) {
        currentState.selectProduct(name);
    }

    @Override
    public void cancelRequest() {
        currentState.cancelRequest();
    }

    @Override
    public Product releaseProductAndRemainingChange() {
        currentState.releaseProductAndRemainingChange();
        return currentState.dispense();
    }

    // Release sản phẩm cho người dùng và tính lại số lượng trong máy
    public Product releaseProduct() {
        return products.take(currentProduct);
    }

    // Tính lại coin trong máy
    public void calCoinInMachine() {
        int count = coinUserInserted.stream().mapToInt(Integer::intValue).sum();
        if(count < currentProduct.getPrice()){
            throw new NoFullPaidException();
        } else {
            calCoinInMachine(coinUserInserted);
        }
    }

    public void calCoinInMachine(List<Integer> coins){
        for(int coin : coins){
            this.coins.addItem(Coin.getCoin(coin).get());
        }
    }

    public Item<Product> getProducts() {
        return products;
    }

    public void setProducts(Item<Product> products) {
        this.products = products;
    }

    public State getNoCoinInserted() {
        return noCoinInserted;
    }

    public void setNoCoinInserted(State noCoinInserted) {
        this.noCoinInserted = noCoinInserted;
    }

    public State getCoinInserted() {
        return coinInserted;
    }

    public void setCoinInserted(State coinInserted) {
        this.coinInserted = coinInserted;
    }

    public State getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(State productSelected) {
        this.productSelected = productSelected;
    }

    public State getProductSold() {
        return productSold;
    }

    public void setProductSold(State productSold) {
        this.productSold = productSold;
    }

    public State getSoldOut() {
        return soldOut;
    }

    public void setSoldOut(State soldOut) {
        this.soldOut = soldOut;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public Item<Coin> getCoins() {
        return coins;
    }

    public void setCoins(Item<Coin> coins) {
        this.coins = coins;
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public List<Integer> getCoinUserInserted() {
        return coinUserInserted;
    }

    public void setCoinUserInserted(List<Integer> coinUserInserted) {
        this.coinUserInserted = coinUserInserted;
    }
}
