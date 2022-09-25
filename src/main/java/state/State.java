package state;

import exception.CoinValidateException;
import generic.Item;
import model.Coin;
import model.Product;

import java.util.Map;

public interface State {
    void insertCoin(int coin);
    void selectProduct(String name);
    void cancelRequest();
    void releaseProductAndRemainingChange();

    default Item<Product> dispense(){return null;};// Tính toán lại số lượng sản phẩm
}
