package tasks;

public class Runner {
    public static void main(String[] args) {

        String[] parkedCars = {"A", "T", "J", "Z", "E"};
        int[] parkingTime = {1, 3, 8, 0, 12};

        Parking parking = new Parking(10, parkedCars, parkingTime);

        System.out.println(parking.toString());

//        parking.park("F", 2);

        parking.finish_parking("J", 9);

        System.out.println(parking.toString());
    }
}
