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
        System.out.println(sodaMachine.getCoins().getSize());
        sodaMachine.insertCoin(20000);
        System.out.println(sodaMachine.getCoins().getSize());
    }
}
