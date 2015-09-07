package com.olights.jqueryable.samples.store;

import com.olights.jqueryable.IQueryable;
import com.olights.jqueryable.Queryable;
import com.olights.jqueryable.QueryableList;
import com.olights.jqueryable.samples.fruits.Apple;
import com.olights.jqueryable.samples.fruits.FruitProduct;
import com.olights.jqueryable.samples.fruits.Orange;

class FruitStore implements FruitStoreManager, FruitStoreApi {

	private final QueryableList<FruitProduct> fruits = Queryable.newQueryableList();
	
	FruitStore() {}

	@Override
	public boolean hasApples() {
		return getApples().any();
	}

	@Override
	public boolean hasOranges() {
		return getOranges().any();
	}
	
	@Override
	public IQueryable<FruitProduct> getFruits() {
		return this.fruits;
	}
	
	@Override
	public void addApple(Apple apple) {
		this.fruits.add(apple);
	}

	@Override
	public void addOrange(Orange orange) {
		this.fruits.add(orange);
	}

	@Override
	public IQueryable<Apple> getApples() {
		return this.fruits.filter(f -> f instanceof Apple).map(f -> (Apple)f);
	}

	@Override
	public IQueryable<Orange> getOranges() {
		return this.fruits.filter(f -> f instanceof Orange).map(f -> (Orange)f);
	}

	@Override
	public void buyApple(Apple apple) {
		this.fruits.remove(apple);
	}

	@Override
	public void buyOrange(Orange orange) {
		this.fruits.remove(orange);
	}
	
}
