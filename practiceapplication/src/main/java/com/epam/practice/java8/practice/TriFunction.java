package com.epam.practice.java8.practice;

public interface TriFunction<T, U, V, W> {

	W perform(T t, U u, V v);
}
