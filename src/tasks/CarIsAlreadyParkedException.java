package tasks;

public class CarIsAlreadyParkedException extends Exception{

    public CarIsAlreadyParkedException(String message) {
        super(message);
    }
}