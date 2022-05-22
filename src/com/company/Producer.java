package com.company;

public class Producer implements Runnable {
    private final int itemNumbers;
    private final Manager manager;
    private final String name;

    public Producer(int itemNumbers, Manager manager, String name) {
        this.itemNumbers = itemNumbers;
        this.manager = manager;
        this.name = name;

        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < itemNumbers; i++) {
            try {
                manager.full.acquire();
                manager.access.acquire();

                manager.storage.add("item " + manager.Items);
                System.out.println(" + Added item " + manager.Items + " by " + name);
                manager.Items++;
                manager.access.release();
                manager.empty.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}