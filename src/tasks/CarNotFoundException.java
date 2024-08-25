package tasks;

public class CarNotFoundException extends Exception {

    public CarNotFoundException(String carId) {
        String message = "Машина с id: " + carId + " е найден!\n";
        super(message);
    }
}
