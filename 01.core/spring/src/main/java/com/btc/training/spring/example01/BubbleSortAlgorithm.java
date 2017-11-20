package com.btc.training.spring.example01;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm{
	
	public BubbleSortAlgorithm() {
		System.out.println("BubbleSort Created");
	}

	public int[] sort(int[] numbers) {
		System.out.println("Bubble sorted");
		return numbers;
	}
}
