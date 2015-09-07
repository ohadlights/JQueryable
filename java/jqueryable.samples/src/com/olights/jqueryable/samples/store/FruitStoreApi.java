package com.olights.jqueryable.samples.store;

import com.olights.jqueryable.IQueryable;
import com.olights.jqueryable.samples.fruits.Apple;
import com.olights.jqueryable.samples.fruits.FruitProduct;
import com.olights.jqueryable.samples.fruits.Orange;

public interface FruitStoreApi {
	
	boolean hasApples();
	
	boolean hasOranges();
	
	IQueryable<FruitProduct> getFruits();
	
	IQueryable<Apple> getApples();
	
	IQueryable<Orange> getOranges();
	
	void buyApple(Apple apple);
	
	void buyOrange(Orange orange);
	
}
