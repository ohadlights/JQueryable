package com.olights.jqueryable.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.olights.jqueryable.QueryableList;

public class QueryableListTest {

	@Test
	public void testCreateEmptyQueryableList() {
		QueryableList<Integer> list = new QueryableList<>();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testCreateQueryableListFromSimpleList() {
		List<Integer> arrayList = createList(1, 2);
		QueryableList<Integer> queryable = new QueryableList<Integer>(arrayList);
		assertEquals(arrayList.size(), queryable.size());
		assertTrue(queryable.contains(1));
		assertTrue(queryable.contains(2));
	}
	
	@Test
	public void testCreateAQueryableListFromInlineArray() {
		QueryableList<Integer> queryable = new QueryableList<Integer>(1, 2);
		assertEquals(2, queryable.size());
		assertTrue(queryable.contains(1));
		assertTrue(queryable.contains(2));
	}
	
	@Test
	public void testFilterAQueryableList() {
		QueryableList<Integer> queryable = new QueryableList<Integer>(1, 2).filter(i -> i == 1);
		assertEquals(1, queryable.size());
		assertTrue(queryable.contains(1));
	}
	
	@Test
	public void testMapMany() {
		QueryableList<Integer> queryable = new QueryableList<Integer>(1, 2);
		
		QueryableList<String> result = queryable.mapMany(i -> {
			List<String> list = new ArrayList<>();
			list.add(Integer.toString(i));
			list.add(Integer.toString(i * 5));
			return list;
		});
		
		assertEquals(4, result.size());
		assertEquals("1", result.get(0));
		assertEquals("5", result.get(1));
		assertEquals("2", result.get(2));
		assertEquals("10", result.get(3));
	}
	
	private <T> List<T> createList(@SuppressWarnings("unchecked") T... items) {
		List<T> list = new ArrayList<T>();
		for (T item : items) {
			list.add(item);
		}
		return list;
	}
	
}
