/*
 * Output : 
 * Hi
 * Hello
 * Hi
 * Hello
 * Hello
 * Hi
 * Hi
 * Hello
 * Hello
 * Hi
 * This output is because both the thread starts at almost same time. But in CPU,
 * there is a scheduler which manages the threads. Now, these threads at the same time 
 * request scheduler to execute. But scheduler can only run one thread at a time for
 * a single core. Also, scheduler executes thread on basis of certain criteria like
 * priority, less time taken. Here, these both threads are same and does not have any
 * priority so the scheduler randomly choose one. Hence, the output. 
 * */
package com.practice.threads;

public class PrintOutputOfMultipleThreads {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Hi obj1 = new Hi();
		Hello obj2 = new Hello();
		
		/*
		 * obj1.show(); // It will print all Hi first obj2.show(); // After printing all
		 * Hi, all Hello will be printed
		 * 
		 * To print Hi and Hello alternatively or to run thread parallely and not one
		 * after another we need to define run().
		 */
		obj1.start();
		// This will cause delay of 10ms and now everytime first Hi prints and then Hello
		//try {Thread.sleep(10);} catch (Exception e) {}
		obj2.start();

		
	}

}

/*
 * Extending the Thread class will make a class a thread but will not run it. To
 * run it we need to call start() method.
 */

class Hi extends Thread {

	public void show() throws Exception {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hi");
			Thread.sleep(1000);
		}
	}

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hi");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}

}

class Hello extends Thread {

	public void show() throws Exception {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hello");
			Thread.sleep(500);
		}
	}

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hello");
			try {Thread.sleep(1000);} catch (Exception e) {}
		}
	}

}
