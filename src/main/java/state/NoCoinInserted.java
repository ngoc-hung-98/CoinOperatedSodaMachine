package state;

import exception.CoinValidateException;
import machine.SodaMachine;
import model.Coin;
import model.Product;

public class NoCoinInserted implements State {
    private SodaMachine sodaMachine;

    public NoCoinInserted(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertCoin(int coin) {
        boolean checkCoin = Coin.hasCoin(coin);
        if (!checkCoin) {
            throw new CoinValidateException();
        }
        sodaMachine.getCoins().addItem(Coin.getCoin(coin));
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
