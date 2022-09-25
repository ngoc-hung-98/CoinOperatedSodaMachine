package exception;

public class CoinValidateException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Coin không hợp lệ do không nằm trong mệnh giá quy định";
    }
}
