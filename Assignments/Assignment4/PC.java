package com.ThreadAssignment;

import java.util.LinkedList;

// This class has a list, producer (adds items to list
// and consumber (removes items).
public class PC {
    // Create a list shared by producer and consumer
    // Size of list is 2.

    LinkedList<DbObject> list = new LinkedList<>();
    int capacity = 2;
    private static final int SLEEPTIME = 1000;

    // Function called by producer thread
    public void produce(DbObject dbObject) throws InterruptedException {

        boolean flag1 = true;

        while (flag1) {
            synchronized (this) {
                // producer thread waits while list
                // is full
                while (list.size()==capacity)
                    wait();

                System.out.println("Producer produced-" + dbObject.getName());

                // to insert the jobs in the list
                list.add(dbObject);

                // notifies the consumer thread that
                // now it can start consuming
                notify();

                // makes the working of program easier
                // to  understand
                Thread.sleep(SLEEPTIME);
            }

            flag1 = false;
        }

        flag1 = true;
    }



    // Function called by consumer thread
    public void consume(DbObject dbObject) throws InterruptedException {
        boolean flag2 = true;
        while (flag2) {
            synchronized (this) {
                // consumer thread waits while list
                // is empty
                while (list.size()==0)
                    wait();

                //to retrive the first job in the list
                DbObject val = list.removeFirst();

                System.out.println("Consumer consumed-" + dbObject.getName());

                // Wake up producer thread
                notify();

                // and sleep
                Thread.sleep(SLEEPTIME);
            }

            flag2 = false;
        }

        flag2 = true;
    }
}