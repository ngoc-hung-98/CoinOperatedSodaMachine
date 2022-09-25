package state;

import exception.CoinValidateException;
import machine.ISodaMachine;
import machine.SodaMachine;
import model.Coin;
import model.Product;

public class ProductSelected implements State{
    private SodaMachine sodaMachine;

    public ProductSelected(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertCoin(int coin) {
            boolean checkCoin = Coin.hasCoin(coin);
            if(!checkCoin){
                throw new CoinValidateException();
            }
            sodaMachine.setBalance(sodaMachine.getBalance() + coin);
    }

    @Override
    public void selectProduct(String name) {
        System.out.println("Bạn đã chọn sản phẩm rồi");
    }

    @Override
    public void cancelRequest() {

            sodaMachine.setBalance(0);
            sodaMachine.setCurrentState(sodaMachine.getNoCoinInserted());
            sodaMachine.setCurrentProduct(null);

    }

    @Override
    public void releaseProductAndRemainingChange() {
        try{
            sodaMachine.setCurrentState(sodaMachine.getProductSold());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}