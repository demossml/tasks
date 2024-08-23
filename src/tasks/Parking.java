package tasks;

import java.util.Arrays;

public class Parking {
    private int capacity;
    private String[] parkedCars;
    private int[] parkingTime;

    public Parking(int capacity, String[] parkedCars, int[] parkingTime) {
        this.capacity = capacity;
        this.parkedCars = new String[capacity];
        this.parkingTime = new int[capacity];

        for (int i = 0; i < Math.min(capacity, parkedCars.length); i++) {
            this.parkedCars[i] = parkedCars[i];
            this.parkingTime[i] = parkingTime[i];
        }
    }
    // Метод для парковки машины
    public boolean park(String carId, int hour) {
        for (int i = 0; i < capacity; i++) {
            if (parkedCars[i] == null) {
                parkedCars[i] = carId;
                parkingTime[i] = hour;
                System.out.printf("Машина idCar:%s припаркована!\n", carId);
                return true;
            }

        }
        System.out.println( "Парковка переполнена!");
        return false;
    }

    public int finish_parking(String carId, int hour) {
        for (int i = 0; i < capacity; i++) {
            if (carId.equals(parkedCars[i])){
                int startParkingHour = parkingTime[i];
                int totalSum = 0;

                for (int h = startParkingHour; h < hour; h++){
                    int dayOfWeek = (h / 24) % 7;
                    boolean isWeekend = dayOfWeek == 5 || dayOfWeek == 6;

                    int rate = ((h % 24) >= 22 || (h % 24) < 7) ? 30 : 50;

                    if (!isWeekend) {
                        rate /= 2;
                    }
                    totalSum += rate;

                }
                parkedCars[i] = null;
                parkingTime[i] = 0;

                System.out.printf("Машина с ID %s убрана из парковки. Общая сумма за парковку: %d\n", carId, totalSum);

                return totalSum;
            }


        }
        System.out.printf("Машина с ID %s не найдена в парковке.\n", carId);

        return 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public String[] getParkedCars() {
        return parkedCars;
    }

    public int[] getParkingTime() {
        return parkingTime;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "capacity=" + capacity +
                ", parkedCars=" + Arrays.toString(parkedCars) +
                ", parkingTime=" + Arrays.toString(parkingTime) +
                '}';
    }
}
