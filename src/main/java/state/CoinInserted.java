package state;


import exception.CoinValidateException;
import exception.ProductValidateException;
import machine.SodaMachine;

import model.Coin;
import model.Product;

import java.util.Optional;

public class CoinInserted implements State{
    private SodaMachine sodaMachine;

    public CoinInserted(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertCoin(int coin)  {
        boolean checkCoin = Coin.hasCoin(coin);
        if(!checkCoin){
            throw new CoinValidateException();
        }
        sodaMachine.setBalance(sodaMachine.getBalance() + coin);

    }

    @Override
    public void selectProduct(String name) {

            Optional<Product> optionalProduct = Product.hasProduct(name);
            if(!optionalProduct.isPresent()){
                throw new ProductValidateException();
            }
            sodaMachine.setCurrentProduct(optionalProduct.get());
            sodaMachine.setCurrentState(sodaMachine.getProductSelected());

    }

    @Override
    public void cancelRequest() {

            sodaMachine.setBalance(0);
            sodaMachine.setCurrentState(sodaMachine.getNoCoinInserted());
            sodaMachine.setCurrentProduct(null);

    }

    @Override
    public void releaseProductAndRemainingChange() {
        System.out.println("Bạn chưa chọn sản phẩm");
    }

}
