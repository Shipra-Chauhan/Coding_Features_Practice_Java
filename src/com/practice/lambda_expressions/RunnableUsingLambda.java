package com.practice.lambda_expressions;

public class RunnableUsingLambda {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 3; i++) {
					System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
				}
			}
		};

		Runnable run_lambda = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
			}
		};

		Thread t = new Thread(run_lambda);

		t.start();
		t.join();
	}

}
