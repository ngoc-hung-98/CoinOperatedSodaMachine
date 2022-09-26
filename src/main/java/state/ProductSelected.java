package state;

import exception.CancelException;
import exception.CoinValidateException;
import machine.ISodaMachine;
import machine.SodaMachine;
import model.Coin;
import model.Product;

import java.util.Optional;

public class ProductSelected implements State {
    private SodaMachine sodaMachine;

    public ProductSelected(SodaMachine sodaMachine) {
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
        System.out.println("Bạn đã chọn sản phẩm rồi");
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
        try {
            sodaMachine.setCurrentState(sodaMachine.getProductSold());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
