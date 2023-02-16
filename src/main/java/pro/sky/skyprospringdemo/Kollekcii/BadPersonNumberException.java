package pro.sky.skyprospringdemo.Kollekcii;

public class BadPersonNumberException extends RuntimeException {
    public BadPersonNumberException(String message) { // принимаем сообщение с типом String
        super(message);
    }
}
