package machine;

import model.Coin;
import model.Product;

public interface ISodaMachine {
    void insertCoin(int coin);
    void selectProduct(String name);
    void cancelRequest();
    void releaseProductAndRemainingChange();
}
