package tasks;

import java.util.*;

public class Parking {
    private static final int NIGHT_RATE = 30;  // Ставка за ночь
    private static final int DAY_RATE = 50;    // Ставка за день
    private int capacity; //Вместимость парковки
    private Map<String, Integer> parkingTime = new HashMap<>();

    public Parking(int capacity) {
        this.capacity = capacity;

    }

    // Метод для парковки машины. Возвращает true, если удалось припарковаться
    public boolean park(String carId, int hour) {
        try {
            if (parkingTime.containsKey(carId)) {
                throw new CarIsAlreadyParkedException(String.format("Машина с id: %s уже припаркована! ", carId));
            }

            if (parkingTime.size() < capacity) {
                parkingTime.put(carId, hour);
                System.out.printf("Машина с id:%s припаркована!\n", carId);
                return true;
            } else {
                System.out.println("Парковка переполнена!");
                return false;
            }
        } catch (CarIsAlreadyParkedException e) {
            System.out.println(e);
            return false;
        }
    }

    public int unpark(String carId, int hour) {
        try {
            if (!parkingTime.containsKey(carId)) {
                throw new CarNotFoundException(String.format("Машина с ID %s не найдена в парковке.\n", carId));
            }
            int startHour = parkingTime.get(carId);
            int totalSum = 0;
            for (int h = startHour; h <= hour; h++){
                    int dayOfWeek = (h / 24) % 7;
                    boolean isWeekend = dayOfWeek == 5 || dayOfWeek == 6;

                    int rate = ((h % 24) >= 22 || (h % 24) < 7) ? NIGHT_RATE : DAY_RATE;

                    if (!isWeekend) {
                        rate /= 2;
                    }
                    totalSum += rate;

                }
            parkingTime.remove(carId);
            System.out.printf("Машина с ID %s убрана из парковки. Общая сумма за парковку: %d\n", carId, totalSum);
            return totalSum;

        } catch (CarNotFoundException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }


    @Override
    public String toString() {
        return "Parking{" +
                "capacity=" + capacity +
                ", parkingTime=" + parkingTime +
                '}';
    }
}
