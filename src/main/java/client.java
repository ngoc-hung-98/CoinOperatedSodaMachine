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
        // Insert tổng 30000 coin
        sodaMachine.insertCoin(20000);
        sodaMachine.insertCoin(10000);
        // Chọn mua Pepsi
        sodaMachine.selectProduct("Pepsi");
        // Bắt đầu mua
        Map<Product, Integer> map = sodaMachine.releaseProductAndRemainingChange();
        //Sau khi mua xong
        System.out.println("Release sản phẩm và tiền thừa cho người dùng: "+map.keySet().iterator().next().getName()+" --- "+map.get(map.keySet().iterator().next()));
        sodaMachine.selectProduct("Coke");
    }
}
