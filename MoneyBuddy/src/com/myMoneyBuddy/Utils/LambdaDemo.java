package com.myMoneyBuddy.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class LambdaDemo {
	
	public static void main(String args[])   {
		
		List<People> people = Arrays.asList(
								new People("Savvy","Wadhwani","33"),
								new People("Vicky","Mittal","35"),
								new People("Aesha","Mittal","7"),
								new People("Anita","Devi","64")
								);
		
		Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
			
		
		System.out.println("Printing all ");
		printConditional(people, p -> true, p -> System.out.println(p));
		
		System.out.println("Printing last name starting with M ");
		printConditional(people, p -> p.getLastName().startsWith("M"),p -> System.out.println(p.getLastName()));
			
		
	}
	
	private static void printConditional(List<People> people, Predicate<People> predicate, Consumer<People> consumer) {
		for (People p : people) 
			if (predicate.test(p))
				consumer.accept(p);
		
	}

}
