package exceptions;

public class FamilyNotFoundException extends RuntimeException {
  public FamilyNotFoundException(String message) {
    super(message);
  }
}
