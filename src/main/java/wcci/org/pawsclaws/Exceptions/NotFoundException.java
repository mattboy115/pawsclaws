package wcci.org.pawsclaws.Exceptions;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Pet not found. Pet is probably dead.");
    }
}
