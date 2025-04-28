package example.bank.exception;

public class AccountLimitReachedException extends RuntimeException {
    public AccountLimitReachedException(String message) {
        super(message);
    }
}
