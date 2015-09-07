package com.olights.jqueryable.samples.runner;

import java.util.Comparator;
import java.util.Optional;

import com.olights.jqueryable.IQueryable;
import com.olights.jqueryable.samples.fruits.Apple;
import com.olights.jqueryable.samples.fruits.FruitProduct;
import com.olights.jqueryable.samples.fruits.Orange;
import com.olights.jqueryable.samples.store.FruitStoreApi;
import com.olights.jqueryable.samples.store.FruitStoreFactory;
import com.olights.jqueryable.samples.store.FruitStoreManager;

public class Runner {

	public static void main(String[] args) {
		initFruitStore();
		
		FruitStoreApi store = FruitStoreFactory.getApi();
		
		curiousClient(store);
		cheapClient(store);
	}
	
	private static void initFruitStore() {
		FruitStoreManager manager = FruitStoreFactory.getManager();
		
		int serialNumber = 1;
		
		// Add 2 apples
		for (; serialNumber <= 2; serialNumber++) {
			Apple apple = new Apple(serialNumber, (float) (serialNumber * 0.1));
			manager.addApple(apple);
		}
		
		//Add 3 oranges
		for (; serialNumber <= 5; serialNumber++) {
			Orange orange = new Orange(serialNumber, (float) (serialNumber * 0.1));
			manager.addOrange(orange);
		}
		
		printStoreContent();
	}
	
	private static void printStoreContent() {
		System.out.println("The store initialy contains:");
		
		FruitStoreApi api = FruitStoreFactory.getApi();
		
		IQueryable<String> fruitsDescription = api.getFruits().map(f -> f.toString());
		System.out.println(String.join("\n", fruitsDescription));
	}
	
	private static void curiousClient(FruitStoreApi store) {
		System.out.println("\nA curious client just wants to ask if there are any fruits that are reall heavy...");
		
		if (store.getFruits().anyMatch(f -> f.getWeight() > 0.4)) {
			System.out.println("The curious client found fruits that weigh more than 0.4");
		}
	}
	
	private static void cheapClient(FruitStoreApi store) {
		System.out.println("\nA cheap client will buy the cheapest fruits:");
		
		Optional<Apple> apple = store.getApples().sorted(getComparator()).findFirst();
		if (apple.isPresent()) {
			System.out.println("The cheap client bought an " + apple.get().toString());
			store.buyApple(apple.get());
		}
		
		Optional<Orange> orange = store.getOranges().sorted(getComparator()).findFirst();
		if (orange.isPresent()) {
			System.out.println("The cheap client bought an " + orange.get().toString());
			store.buyOrange(orange.get());
		}
	}
	
	private static Comparator<FruitProduct> getComparator() {
		return new Comparator<FruitProduct>() {
			@Override
			public int compare(FruitProduct o1, FruitProduct o2) {
				return Float.compare(o1.getPrice(), o2.getPrice());
			}
		};	
	}

}
