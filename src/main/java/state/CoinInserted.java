package state;


import exception.CancelException;
import exception.CoinValidateException;
import exception.ProductValidateException;
import machine.SodaMachine;

import model.Coin;
import model.Product;

import java.util.Optional;

public class CoinInserted implements State {
    private SodaMachine sodaMachine;

    public CoinInserted(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertCoin(int coin) {
        Optional<Coin> optionalCoin = Coin.getCoin(coin);
        if (!optionalCoin.isPresent()) {
            throw new CoinValidateException();
        }
        sodaMachine.getCoinUserInserted().add(coin);

    }

    @Override
    public void selectProduct(String name) {
        Optional<Product> optionalProduct = Product.getProduct(name);
        if (!optionalProduct.isPresent()) {
            throw new ProductValidateException();
        }
        sodaMachine.setCurrentProduct(optionalProduct.get());
        sodaMachine.setCurrentState(sodaMachine.getProductSelected());

    }

    @Override
    public void cancelRequest() {

        sodaMachine.getCoinUserInserted().clear();
        sodaMachine.setCurrentState(sodaMachine.getNoCoinInserted());
        sodaMachine.setCurrentProduct(null);
        throw new CancelException();
    }

    @Override
    public void releaseProductAndRemainingChange() {
        System.out.println("Bạn chưa chọn sản phẩm");
    }

}
