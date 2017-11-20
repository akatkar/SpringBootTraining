package com.btc.training.spring.example01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired
	@Qualifier(value= "bubble")
	private SortAlgorithm sortAlgorithm;
	
//	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}
//	
	public int search(int[] numbers, int number) {
		
		int[] sorted = sortAlgorithm.sort(numbers);
		
		// seacrh in sorted
		
		return 3;
	}

	public SortAlgorithm getSortAlgorithm() {
		return sortAlgorithm;
	}

	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}
	
	
	
}
