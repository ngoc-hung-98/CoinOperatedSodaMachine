package state;

import exception.NoProductException;
import machine.SodaMachine;
public class SoldOut implements State {
    private SodaMachine sodaMachine;

    public SoldOut(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertCoin(int coin) {
        throw new NoProductException();
    }

    @Override
    public void selectProduct(String name) {
        throw new NoProductException();
    }

    @Override
    public void cancelRequest() {
        throw new NoProductException();
    }

    @Override
    public void releaseProductAndRemainingChange() {
        throw new NoProductException();
    }

}
