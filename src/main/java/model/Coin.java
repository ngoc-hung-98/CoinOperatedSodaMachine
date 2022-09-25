package model;

import java.util.Optional;

public enum Coin {
    TEN(10000),
    TWENTY(20000),
    FIFTY(50000),
    ONE_HUNDRED(100000),
    TWO_HUNDRED(200000);
    private int coin;

    Coin(int coin) {
        this.coin = coin;
    }

    public static Optional<Coin> getCoin(int coin) {
        Coin c = null;
        for (Coin key : Coin.values()) {
            if (key.getCoin() == coin) {
                 c = key;
            }
        }
        return Optional.ofNullable(c);
    }

    public int getCoin() {
        return coin;
    }

}
