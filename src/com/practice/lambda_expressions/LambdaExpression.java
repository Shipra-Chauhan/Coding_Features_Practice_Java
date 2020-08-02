package com.practice.lambda_expressions;

import java.io.File;
import java.io.FileFilter;

public class LambdaExpression {

	public static void main(String[] args) {

		// Anonymous Class
		FileFilter ff1 = new FileFilter() {

			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stub
				return file.getName().endsWith(".java");
			}
		};

		// Lambda Expression
		FileFilter ff2 = (File file) -> file.getName().endsWith(".java");

		File dir = new File(
				"C:\\Users\\rahul\\GitHub\\Project\\Book\\src\\main\\java\\com\\spring_boot\\example\\book\\controller");
		File[] files = dir.listFiles(ff1);

		for (File file2 : files) {
			System.out.println(file2);
		}

	}

}
