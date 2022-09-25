package state;

import exception.CoinValidateException;
import machine.SodaMachine;
import model.Coin;
import model.Product;

import java.util.Optional;

public class NoCoinInserted implements State {
    private SodaMachine sodaMachine;

    public NoCoinInserted(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertCoin(int coin) {
        Optional<Coin> optionalCoin = Coin.getCoin(coin);
        if (!optionalCoin.isPresent()) {
            throw new CoinValidateException();
        }
        sodaMachine.getCoins().addItem(optionalCoin.get());
        sodaMachine.setBalance(sodaMachine.getBalance() + coin);
        sodaMachine.setCurrentState(sodaMachine.getCoinInserted());
    }

    @Override
    public void selectProduct(String name) {
        System.out.println("Bạn chưa insert coin");
    }

    @Override
    public void cancelRequest() {
        System.out.println("Bạn chưa insert coin");
    }

    @Override
    public void releaseProductAndRemainingChange() {
        System.out.println("Bạn chưa insert coin");
    }


}
