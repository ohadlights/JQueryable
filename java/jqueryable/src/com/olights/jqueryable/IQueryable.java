package com.olights.jqueryable;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * IQueryable combines the functionality of a @Stream and an @IContainer. 
 *
 * @param <Type> the type of the contained items
 */
public interface IQueryable<Type> extends IContainer<Type> {

	/**
	 * Returns an IQueryable consisting of the elements of this IQueryable that match the given predicate.
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to each element to determine if it should be included
	 * @return the new IQueryable
	 */
	IQueryable<Type> filter(Predicate<Type> predicate);
	
	/**
	 * Returns a IQueryable consisting of the results of applying the given function to the elements of this IQueryable
	 * This is an intermediate operation.
	 * 
	 * @param mapper a non-interfering, stateless function to apply to each element
	 * @param <Out> the result of mapping the original type
	 * @return the new IQueryable
	 */
	<Out> IQueryable<Out> map(Function<Type, Out> mapper);
	
	/**
	 * Returns a IQueryable consisting of the results of applying the given function to the elements of this IQueryable
	 * This is an intermediate operation.
	 * 
	 * @param mapper a non-interfering, stateless function to apply to each element
	 * @param <Out> the result of mapping the original type
	 * @return the new IQueryable
	 */
	<Out> IQueryable<Out> mapMany(Function<Type, Iterable<Out>> mapper);
	
	/**
	 * Check if this IQueryable contains any elements. 
	 * 
	 * @return true if the IQueryable contains at least one element, otherwise false
	 */
	boolean any();
	
	/**
	 * Returns whether any elements of this IQueryable match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the IQueryable is empty then false is returned and the predicate is not evaluated.
	 * This is a short-circuiting terminal operation.
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to elements of this queryable.
	 * @return true if any elements of the stream match the provided predicate, otherwise false
	 */
	boolean anyMatch(Predicate<? super Type> predicate);
	
	/**
	 * Return the number of elements in this IQueryable
	 * 
	 * @return number of elements
	 */
	int count();
	
	/**
	 * Return number of elements in this queryable that passes the given predicate. 
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to elements of this queryable.
	 * @return the number of elements that passed the predicate
	 */
	int count(Predicate<Type> predicate);
	
	/**
	 * Returns the first item in this IQueryable
	 * 
	 * @return the first item if exists
	 */
	Type first();
	
	/**
	 * Returns the first item in this IQueryable
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to elements of this stream
	 * @return the first item if exists
	 */
	Type first(Predicate<Type> predicate);
	
	/**
	 * Returns the first item in this IQueryable if exists
	 * 
	 * @return the first item
	 */
	Optional<Type> findFirst();
	
	/**
	 * Returns the first item in this IQueryable if exists
	 * 
	 * @param predicate a non-interfering, stateless predicate to apply to elements of this stream
	 * @return the first item
	 */
	Optional<Type> findFirst(Predicate<Type> predicate);
	
	/**
	 * Returns the last item in this IQueryable
	 * 
	 * @return the last item if exists
	 */
	Type last();
	
	/**
	 * Returns an array containing the elements of this IQueryable.
	 * This is a terminal operation.
	 * 
	 * @param generator function that generates a new array of the given type and size
	 * @return an array containing the elements of this IQueryable
	 */
	Type[] toArray(IntFunction<Type[]> generator);
	
	/**
	 * Returns a queryalbe consisting of the elements of this queryalbe, sorted according to natural order. If the elements of this queryalbe are not Comparable, a java.lang.ClassCastException may be thrown when the terminal operation is executed.
	 * 
	 * For ordered queryalbes, the sort is stable. For unordered queryalbes, no stability guarantees are made.
	 * 
	 * This is a stateful intermediate operation.
	 * 
	 * @return the new queryable
	 */
	IQueryable<Type> sorted();
	
	/**
	 * Returns a queryalbe consisting of the elements of this queryalbe, sorted according to the provided Comparator.
	 * 
	 * For ordered queryalbes, the sort is stable. For unordered queryalbes, no stability guarantees are made.
	 * 
	 * This is a stateful intermediate operation.
	 * 
	 * @param comparator comparator - a non-interfering, stateless Comparator to be used to compare queryalbe elements
	 * 
	 * @return the new queryable
	 */
	IQueryable<Type> sorted(Comparator<? super Type> comparator);
	
	/**
	 * Returns an queryable consisting of the distinct elements (according to Object.equals(Object)) of this queryable.
	 * 
	 * @return the queryable result
	 */
	IQueryable<Type> distinct();

}