package com.olights.jqueryable;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * This class is used to transform a @Stream of elements to a QueryableList
 * Usage: stream.collect(QueryableCollector.toQueryable());
 *
 * @param <T>
 */
public class QueryableCollector<T> implements Collector<T,QueryableList<T>,QueryableList<T>> {

	static final Set<Collector.Characteristics> CH_ID
    	= Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
	
	/**
	 * Return a new QueryableCollector
	 * 
	 * @return the new QueryableCollector
	 */
	public static <T> Collector<T,QueryableList<T>,QueryableList<T>> toQueryable() {
		return new QueryableCollector<T>();
	}

	@Override
	public Supplier<QueryableList<T>> supplier() {
		return QueryableList::new;
	}

	@Override
	public BiConsumer<QueryableList<T>, T> accumulator() {
		return QueryableList::add;
	}

	@Override
	public BinaryOperator<QueryableList<T>> combiner() {
		return (list1, list2) -> {
			list1.addAll(list2);
			return list1;
		};
	}

	@Override
	public Function<QueryableList<T>, QueryableList<T>> finisher() {
		return in -> in;
	}

	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		return CH_ID;
	}
	
}
