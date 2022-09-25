package exception;

public class NoFullPaidException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Coin không đủ để mua sản phẩm này";
    }
}
