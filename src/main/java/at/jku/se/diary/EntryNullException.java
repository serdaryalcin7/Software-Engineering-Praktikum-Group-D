package at.jku.se.diary;

/**
 * @author Team-D
 * This is a Exception class
 * appears if a field is not filled
 */
public class EntryNullException extends Throwable {

    public EntryNullException(String message) {
        super(message);
    }
}
