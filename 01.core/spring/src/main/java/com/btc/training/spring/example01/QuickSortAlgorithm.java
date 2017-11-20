package com.btc.training.spring.example01;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm{

	public QuickSortAlgorithm() {
		// TODO Auto-generated constructor stub
		System.out.println("QuickSort Created");
	}
	
	@Override
	public int[] sort(int[] numbers) {
		// TODO Auto-generated method stub
		System.out.println("Quick sorted");
		return numbers;
	}

}
