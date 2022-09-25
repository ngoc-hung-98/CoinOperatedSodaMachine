package machine;

import generic.Item;
import model.Coin;
import model.Product;

import java.util.Map;

public interface ISodaMachine {
    void insertCoin(int coin);
    void selectProduct(String name);
    void cancelRequest();
    Item<Product> releaseProductAndRemainingChange(); // key là sản phẩm và value là tiền thừa trả cho người dùng
}
