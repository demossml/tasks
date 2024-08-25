package tasks;

import java.util.HashMap;
import java.util.HashSet;

public class Runner {
    public static void main(String[] args) throws CarNotFoundException, CarIsAlreadyParkedException {

        int capacity = 4;

        Parking parking = new Parking(capacity);
        System.out.println(parking.toString());

        parking.park("A", 2);
        parking.park("B", 5);
        parking.park("B", 5);
        parking.park("C", 7);
        parking.park("D", 2);
        parking.park("E", 8);
        parking.park("F", 12);
        parking.park("G", 1);

        parking.unpark("B", 5);

        System.out.println(parking.toString());
    }
}
