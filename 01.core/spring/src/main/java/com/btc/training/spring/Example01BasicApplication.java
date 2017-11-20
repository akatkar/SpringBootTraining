package com.btc.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.btc.training.spring.example01.BinarySearchImpl;

@SpringBootApplication
public class Example01BasicApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Example01BasicApplication.class, args);
		
		
//		BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
//		QuickSortAlgorithm quickSort = new QuickSortAlgorithm();
//		BinarySearchImpl binarySearchImpl = new BinarySearchImpl(quickSort);
		
		BinarySearchImpl binarySearchImpl = ctx.getBean(BinarySearchImpl.class);
		
		int result = binarySearchImpl.search(new int[] {12,23,4,5,6}, 5);
		System.out.println(result);
		
	}
}
