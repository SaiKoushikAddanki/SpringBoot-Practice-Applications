package com.revision.demo.controller;

public interface TriFunction<T, U, V, W> {

	W perform(T t, U u, V v);
}
