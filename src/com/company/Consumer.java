package com.company;

public class Consumer implements Runnable {
    private final int itemNumbers;
    private final Manager manager;
    private final String name;

    public Consumer(int itemNumbers, Manager manager, String name) {
        this.itemNumbers = itemNumbers;
        this.manager = manager;
        this.name = name;


        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < itemNumbers; i++) {
            String item;
            try {
                manager.empty.acquire();
                Thread.sleep(500);
                manager.access.acquire();

                item = manager.storage.get(0);
                manager.storage.remove(0);
                System.out.println(" - Took " + item + " by " + name);

                manager.access.release();
                manager.full.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}