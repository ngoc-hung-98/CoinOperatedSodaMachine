package machine;

import exception.NoSufficientChangeException;
import generic.Item;
import model.Coin;
import model.Product;
import state.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    private int balance; // tổng coin của người dùng insert vào máy

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
    public Map<Product, Integer> releaseProductAndRemainingChange() {
        currentState.releaseProductAndRemainingChange();
        return currentState.dispense();
    }

    // Release sản phẩm và tính lại số lượng
    public Product releaseProduct() {
        return products.take(currentProduct);
    }

    // Release coin cho người dùng và tính lại coin trong máy
    public int getChangeAndCalCoinInMachine() {
        int changeOfUser = balance - currentProduct.getPrice();
        if (changeOfUser > 0) {
            Optional<Coin> optionalCoin = Coin.getCoin(changeOfUser);
            if (optionalCoin.isPresent() && coins.hasItem(optionalCoin.get())) {
                coins.take(optionalCoin.get());
                return optionalCoin.get().getCoin();
            }
        }
        if (changeOfUser < 0) {
            throw new NoSufficientChangeException();
        }
//        while (balance > 0 && mount < currentProduct.getPrice()) {
//            if (balance >= Coin.TEN.getCoin() && coins.hasItem(Coin.TEN)) {
//                balance -= Coin.TEN.getCoin();
//                mount += Coin.TEN.getCoin();
//                coins.take(Coin.TEN);
//                change.add(Coin.TEN);
//            } else if (balance >= Coin.TWENTY.getCoin() && coins.hasItem(Coin.TWENTY)) {
//                balance -= Coin.TWENTY.getCoin();
//                mount += Coin.TWENTY.getCoin();
//                coins.take(Coin.TWENTY);
//                change.add(Coin.TWENTY);
//            } else if (balance >= Coin.FIFTY.getCoin() && coins.hasItem(Coin.FIFTY)) {
//                balance -= Coin.FIFTY.getCoin();
//                mount += Coin.FIFTY.getCoin();
//                coins.take(Coin.FIFTY);
//                change.add(Coin.FIFTY);
//            } else if (balance >= Coin.ONE_HUNDRED.getCoin() && coins.hasItem(Coin.ONE_HUNDRED)) {
//                balance -= Coin.ONE_HUNDRED.getCoin();
//                mount += Coin.ONE_HUNDRED.getCoin();
//                coins.take(Coin.ONE_HUNDRED);
//                change.add(Coin.ONE_HUNDRED);
//            } else if (balance >= Coin.TWO_HUNDRED.getCoin() && coins.hasItem(Coin.TWO_HUNDRED)) {
//                balance -= Coin.TWO_HUNDRED.getCoin();
//                mount += Coin.TWO_HUNDRED.getCoin();
//                coins.take(Coin.TWO_HUNDRED);
//                change.add(Coin.TWO_HUNDRED);
//            }
//            if (balance > 0 && coins.getSize() == 0) {
//                throw new NoSufficientChangeException();
//            }
//        }
        return 0;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
