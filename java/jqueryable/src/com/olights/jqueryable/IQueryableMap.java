package com.olights.jqueryable;

import java.util.Map;

public interface IQueryableMap<K,V> extends Map<K,V> {

	IQueryable<K> queryKeys();
	
	IQueryable<V> queryValues();
	
}
