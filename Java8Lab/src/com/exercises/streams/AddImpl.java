package com.exercises.streams;

import java.util.stream.Stream;

//implements FunctionalInterfaceAdd
public class AddImpl  {
	
	FunctionalInterfaceAdd t =(number)-> {
		
		Integer sum =0;
		sum =number.reduce(0, (acc,ele)-> acc+ele);
		return sum;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddImpl ai =new AddImpl();
		Integer sum =ai.t.add(Stream.of(1,2,3));
		
		System.out.println("Sum : "+sum);
	}
	
/*
 * 1.here we impleemnted functional interface: FunctionalInterfaceAdd, method add(), in AddImpl class
 * 2.calling this method on AddImpl object ai->FunctionalInterfaceAdd reference ->t->add(),
 *   by passing stream input. 
 */

}
