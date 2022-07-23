package at.jku.se.diary;

/**
 * This is an Exception class
 * appears if a field is not filled
 * @author Team-D
 */
public class EntryNullException extends Throwable {

    public EntryNullException(String message) {
        super(message);
    }
}
