package tasks;

public class CarIsAlreadyParkedException extends Exception{

    public CarIsAlreadyParkedException(String carId) {
        String message = "Машина с id: " + carId + " уже припаркована!\n";
        super(message);
    }
}