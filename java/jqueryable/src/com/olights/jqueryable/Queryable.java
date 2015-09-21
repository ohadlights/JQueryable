package com.olights.jqueryable;

import java.util.Collection;

/**
 * This class provides static methods to create new Queryable collections.
 *
 */
public class Queryable {

	/**
	 * Create an empty QueryableList
	 * @param <Type> the type of the contained item
	 * @return the new QueryableList
	 */
	public static <Type> QueryableList<Type> newQueryableList() {
		return new QueryableList<Type>();
	}
	
	/**
	 * Create a QueryableList which contains the elements from the given collection
	 * 
	 * @param collection collection to provide the initial elements of this QueryableList
	 * @param <Type> the type of the contained item
	 * @return the new QueryableList
	 */
	public static <Type> QueryableList<Type> newQueryableList(Collection<Type> collection) {
		return new QueryableList<Type>(collection);
	}
	
	/**
	 * Create a QueryableList which contains the elements from the given iterable
	 * 
	 * @param iterable collection to provide the initial elements of this QueryableList
	 * @param <Type> the type of the contained item
	 * @return the new QueryableList
	 */
	public static <Type> QueryableList<Type> newQueryableList(Iterable<Type> iterable) {
		return new QueryableList<Type>(iterable);
	}
	
	/**
	 * Create a QueryableList which contains the elements which are passed as arguments.  
	 * 
	 * @param items the elements that will contained in the QueryableList
	 * @param <Type> the type of the contained item
	 * @return the new QueryableList
	 */
	@SafeVarargs
	public static <Type> QueryableList<Type> newQueryableList(Type... items) {
		return new QueryableList<Type>(items);
	}
	
	/**
	 * Create an empty @QueryableMap
	 * 
	 * @param <K> the type of the map key
	 * @param <V> the type of the contained item
	 * @return the new QueryableMap
	 */
	public static <K,V> QueryableMap<K, V> newQueryableMap() {
		return new QueryableMap<K, V>();
	}

}
