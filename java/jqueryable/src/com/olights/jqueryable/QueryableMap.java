package com.olights.jqueryable;

import java.util.HashMap;

public class QueryableMap<K,V> extends HashMap<K,V> implements IQueryableMap<K,V> {

	private static final long serialVersionUID = 1L;

	@Override
	public IQueryable<K> queryKeys() {
		return Queryable.newQueryableList(keySet());
	}
	
	@Override
	public IQueryable<V> queryValues() {
		return Queryable.newQueryableList(values());
	}
	
}
