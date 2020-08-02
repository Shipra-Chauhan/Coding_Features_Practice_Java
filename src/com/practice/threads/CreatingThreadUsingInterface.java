package com.practice.threads;

public class CreatingThreadUsingInterface {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Hi1 obj1 = new Hi1();
		Hello1 obj2 = new Hello1();
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		t1.start();
		try {Thread.sleep(10);} catch (Exception e) {}
		t2.start();
	}
}

class Hi1 implements Runnable {

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
			} catch (Exception e) {
			}
		}
	}

}

class Hello1 implements Runnable {

	public void show() throws Exception {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hello");
			Thread.sleep(500);
		}
	}

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hello");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}

}
