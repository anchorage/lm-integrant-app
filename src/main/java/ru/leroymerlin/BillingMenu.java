package ru.leroymerlin;

import ru.leroymerlin.counter.MinProfitCounter;
import ru.leroymerlin.counter.RevenueCounter;
import ru.leroymerlin.reader.ItemReader;
import ru.leroymerlin.reader.RevenueReader;
import ru.leroymerlin.reader.ServiceReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class BillingMenu {

    public static void greeting() throws URISyntaxException, IOException {
        System.out.println("Приветствуем в билинговой системе! Что вам требуется?");
        BillingMenu.print();

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();

            switch (input) {
                case "q": {
                    System.out.println("Надеемся, вам понравилось наше приложение!");
                    return;
                }
                case "1": {
                    for (int i = 0; i < ItemReader.getItems().size(); i++) {
                        MinProfitCounter sumItem = new MinProfitCounter(ItemReader.getItems().get(i));
                        sumItem.showData();
                    }
                    for (int i = 0; i < ItemReader.getItems().size(); i++) {
                        MinProfitCounter sumService = new MinProfitCounter(ServiceReader.getServices().get(i));
                        sumService.showData();
                    }
                    break;
                }
                case "2": {
                    RevenueCounter revenueCounter = new RevenueCounter(ItemReader.getItems(), ServiceReader.getServices(), RevenueReader.getRevenue());
                    if (revenueCounter.isItemRevenueIsEqual()) {
                        System.out.println("Сверка по прибыли из файла revenue равна прибыли, посчитанной по данным из файла items");
                    }
                    if (revenueCounter.isServiceRevenueIsEqual()) {
                        System.out.println("Сверка по прибыли из файла revenue равна прибыли, посчитанной по данным из файла services");
                    }
                    revenueCounter.showData();
                    break;
                }
                default: {
                    System.out.println("Команды не существует");
                }
            }
        }
    }

    private static void print() {
        System.out.println("Рассчёты: ");
        System.out.println("1 - Подсчёт минимальной прибыли по товару и услуге");
        System.out.println("2 - Сверка прибыли по услугам и товарам");
        System.out.println("Для завершения работы, нажмите 'q'");
    }
}
