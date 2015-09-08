JQueryable
====

**Latest release: [1.0](https://github.com/ohadlights/JQueryable/releases)**

**Documentation:** [Wiki](https://github.com/ohadlights/JQueryable/wiki)

**License:** GNU GENERAL PUBLIC LICENSE 2.0

Queryable Java collections based on Java 8 Stream class and lambda capabilities.


The new Stream class is a great addition to Java collections but it comes with a few inconveniences.

In order to query a List<T>, one needs to first call stream() and then perform the query operations.
When the query is done, the result stream cannot be saved for later reuse. Instead it has to be transformed back to a list using collect() & Collectors class.

JQueryable comes to make the use of these new capabilities simpler.

1.  It hides the call for stream()
2.  When the query is done, the result is a IQeuryable<T> which can be saved for later resue or even more querying.

QueryableList<T> inherits from ArrayList<T>, so it has all the List methods, plus the querying functionality.
Of course, after a query is done on a QueryableList, the result is still a QueryableList.


IQueryable<T> interface contains methods for filtering, sorting, mapping and so on.
	
