package exception;

public class NoSufficientChangeException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Máy không đủ tiền trả lại cho người dùng";
    }
}
