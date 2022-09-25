package machine;

import model.Coin;
import model.Product;

import java.util.Map;

public interface ISodaMachine {
    void insertCoin(int coin);
    void selectProduct(String name);
    void cancelRequest();
    Map<Product, Integer> releaseProductAndRemainingChange(); // key là sản phẩm và value là tiền thừa trả cho người dùng
}
