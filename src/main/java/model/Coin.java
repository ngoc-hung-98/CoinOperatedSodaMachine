package model;

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

    public static boolean hasCoin(int coin){
        try{
            for(Coin c : Coin.values()){
                if(c.getCoin() == coin){
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static Coin getCoin(int coin){
        for(Coin c : Coin.values()){
            if(c.getCoin() == coin){
                return c;
            }
        }
        return null;
    }

    public int getCoin() {
        return coin;
    }

}
