import generic.Item;
import machine.ISodaMachine;
import machine.SodaMachine;
import model.Product;

import java.util.HashMap;
import java.util.Map;

public class client {
    public static void main(String[] args) {
        System.out.println("------------------------------");
        System.out.println("Welcome to Coin Operated Soda Machine");
        System.out.println("------------------------------");
        SodaMachine sodaMachine = new SodaMachine();
        // Insert tổng coin
//        sodaMachine.insertCoin(20000);
        sodaMachine.insertCoin(10000);
        // Chọn mua Pepsi
        sodaMachine.selectProduct("Soda");
        // Bắt đầu mua
        Product product = sodaMachine.releaseProductAndRemainingChange();
        //Sau khi mua xong
        System.out.println("Release sản phẩm: " + product.getName());
        sodaMachine.selectProduct("Coke");
    }
}
