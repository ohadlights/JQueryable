package jqueryable.samples.store;

import jqueryable.samples.fruits.Apple;
import jqueryable.samples.fruits.FruitProduct;
import jqueryable.samples.fruits.Orange;

import com.olights.jqueryable.IQueryable;

public interface FruitStoreApi {
	
	boolean hasApples();
	
	boolean hasOranges();
	
	IQueryable<FruitProduct> getFruits();
	
	IQueryable<Apple> getApples();
	
	IQueryable<Orange> getOranges();
	
	void buyApple(Apple apple);
	
	void buyOrange(Orange orange);
	
}
