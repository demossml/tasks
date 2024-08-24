package tasks;

import java.util.*;

public class Parking {
    private int capacity;
    private Set<String> parkedCars;
    private Map<String, Integer> parkingTime;

    public Parking(int capacity, Set<String> parkedCars, Map<String, Integer> parkingTime) {
        this.capacity = capacity;
        this.parkedCars = new HashSet<>();
        this.parkingTime = new HashMap<>();
    }

    // Метод для парковки машины
    public boolean park(String carId, int hour) {
        if (parkedCars.size() < capacity){
            parkedCars.add(carId);
            parkingTime.put(carId, hour);
            System.out.printf("\"Машина idCar:%s припаркована!\n", carId);
            return true;
            }
        System.out.println("Парковка переполнена!");
        return false;
        }

    public int finish_parking(String carId, int hour) {
        if (parkedCars.contains(carId)) {
            int startHour = parkingTime.get(carId);
            int totalSum = 0;
            for (int h = startHour; h < hour; h++){
                    int dayOfWeek = (h / 24) % 7;
                    boolean isWeekend = dayOfWeek == 5 || dayOfWeek == 6;

                    int rate = ((h % 24) >= 22 || (h % 24) < 7) ? 30 : 50;

                    if (!isWeekend) {
                        rate /= 2;
                    }
                    totalSum += rate;

                }
            parkedCars.remove(carId);
            parkingTime.remove(carId);
            System.out.printf("Машина с ID %s убрана из парковки. Общая сумма за парковку: %d\n", carId, totalSum);
            return totalSum;

            // Получаем время въезда машины на парковку
        }
        System.out.printf("Машина с ID %s не найдена в парковке.\n", carId);
        return 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<String> getParkedCars() {
        return parkedCars;
    }

    public Map<String, Integer> getParkingTime() {
        return parkingTime;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "capacity=" + capacity +
                ", parkedCars=" + parkedCars +
                ", parkingTime=" + parkingTime +
                '}';
    }
}
