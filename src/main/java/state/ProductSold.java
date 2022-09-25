package state;

import generic.Item;
import machine.ISodaMachine;
import machine.SodaMachine;
import model.Coin;
import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductSold implements State{
    private SodaMachine sodaMachine;

    public ProductSold(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertCoin(int coin) {
        System.out.println("Vui lòng chờ giao dịch hiện tại hoàn tất");
    }

    @Override
    public void selectProduct(String name) {
        System.out.println("Vui lòng chờ giao dịch hiện tại hoàn tất");
    }

    @Override
    public void cancelRequest() {
        System.out.println("Không thể cancel do đã click vào mua hàng, vui lòng chờ giao dịch hoàn tất");
    }

    @Override
    public void releaseProductAndRemainingChange() {
        System.out.println("Vui lòng chờ giao dịch hiện tại hoàn tất");
    }

    @Override
    public Map<Product, Integer> dispense() {
        Map<Product, Integer> items = new HashMap<>();
        int balance = sodaMachine.getChangeAndCalCoinInMachine();
        Product product = sodaMachine.releaseProduct();
        if(sodaMachine.getProducts().getSize() > 0){
            sodaMachine.setCurrentState(sodaMachine.getNoCoinInserted());
        }else{
            sodaMachine.setCurrentState(sodaMachine.getSoldOut());
        }
        items.put(product, balance);
        return items;
    }
}
