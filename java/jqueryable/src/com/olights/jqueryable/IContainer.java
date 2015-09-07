package com.olights.jqueryable;

/**
 * Container is an @Iterable which can also be queried for a contained item.
 *
 * @param <Type> the type of the contained items
 */
public interface IContainer<Type> extends Iterable<Type> {

	boolean contains(Type item);
	
}
