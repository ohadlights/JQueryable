package com.olights.jqueryable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * This class implements the @IQueryable interface.
 *
 * @param <Type> the type of the contained elements
 */
public class QueryableList<Type> extends ArrayList<Type> implements IQueryableList<Type> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create an empty QueryableList
	 */
	public QueryableList() {
	}
	
	/**
	 * Create a QueryableList which contains the elements from the given collection
	 * 
	 * @param collection collection to provide the initial elements of this QueryableList
	 */
	public QueryableList(Collection<Type> collection) {
		super(collection);
	}
	
	/**
	 * Create a QueryableList which contains the elements from the given iterable
	 * 
	 * @param iterable collection to provide the initial elements of this QueryableList
	 */
	public QueryableList(Iterable<Type> iterable) {
		for (Type item : iterable) add(item);
	}
	
	/**
	 * Create a QueryableList which contains the elements which are passed as arguments.  
	 * 
	 * @param items the elements that will contained in the QueryableList
	 */
	@SafeVarargs
	public QueryableList(Type... items) {
		for (Type item : items) add(item);
	}
	
	@Override
	public QueryableList<Type> filter(Predicate<Type> predicate) {
		return toQueryableList(stream().filter(predicate));
	}
	
	@Override
	public <Out> QueryableList<Out> map(Function<Type, Out> mapper) {
		return toQueryableList(stream().map(mapper));
	}
	
	@Override
	public <Out> QueryableList<Out> mapMany(Function<Type, Iterable<Out>> mapper) {
		QueryableList<Out> result = new QueryableList<Out>();
		stream().forEachOrdered(i -> result.addAll(toCollection(mapper.apply(i))));
		return result;
	}
	
	@Override
	public boolean any() {
		return count() > 0;
	}
	
	@Override
	public boolean anyMatch(Predicate<? super Type> predicate) {
		return stream().anyMatch(predicate);
	}
	
	@Override
	public int count() {
		return size();
	}
	
	@Override
	public int count(Predicate<Type> predicate) {
		return filter(predicate).count();
	}
	
	@Override
	public Type first() {
		return get(0);
	}
	
	@Override
	public Type first(Predicate<Type> predicate) {
		return filter(predicate).first();
	}
	
	@Override
	public Optional<Type> findFirst() {
		return stream().findFirst();
	}
	
	@Override
	public Optional<Type> findFirst(Predicate<Type> predicate) {
		return filter(predicate).findFirst();
	}
	
	@Override
	public Type last() {
		return get(size() - 1);
	}
	
	@Override
	public Type[] toArray(IntFunction<Type[]> generator) {
		Type[] array = generator.apply(size());
		for (int i = 0; i < size(); ++i) array[i] = get(i);
		return array;
	}
	
	@Override
	public IQueryable<Type> sorted() {
		return toQueryableList(stream().sorted()); 
	}

	@Override
	public IQueryable<Type> sorted(Comparator<? super Type> comparator) {
		return toQueryableList(stream().sorted(comparator));
	}
	
	@Override
	public IQueryable<Type> distinct() {
		return toQueryableList(stream().distinct());
	}
	
	private <OutType> QueryableList<OutType> toQueryableList(Stream<OutType> stream) {
		return stream.collect(QueryableCollector.toQueryable());
	}
	
	private <T> Collection<T> toCollection(Iterable<T> iterable) {
		Collection<T> collection = new ArrayList<>();
		for (T item : iterable) {
			collection.add(item);
		}
		return collection;
	}

}
