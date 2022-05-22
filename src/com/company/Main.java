package com.company;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Random rand = new Random();
        int storageSize = rand.Next(2, 5);
        int itemNumbers = rand.Next(3, 8);
        int consumers = rand.Next(2, 7);
        int producers = consumers;
        System.out.println("Storage size: " + storageSize + "\nNumber of items: "
                + itemNumbers + "\nConsumers: " + consumers + "\nProducers: " + producers);
        main.starter(storageSize, itemNumbers, consumers, producers);
    }

    private void starter(int storageSize, int itemNumbers, int consumers, int producers) {

        Manager manager = new Manager(storageSize);

        int all = consumers + producers;
        for (int i = 0; i < all; i++) {
            if (consumers > 0) {
                new Consumer(itemNumbers, manager, "Consumer " + (i + 1));
                consumers--;
            }
            if (producers > 0) {
                new Producer(itemNumbers, manager, "Producer " + (i + 1));
                producers--;
            }
        }


    }
}
