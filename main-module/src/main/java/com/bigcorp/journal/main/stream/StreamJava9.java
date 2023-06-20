package com.bigcorp.journal.main.stream;

import java.util.stream.Stream;

public class StreamJava9 {

	public static void main(String[] args) {

		System.out.println("\r\nUtilisation de Stream.iterate");
		Stream.iterate(1, i -> i <= 21, i -> i + 2).forEach(System.out::println);

		System.out.println("\r\nUtilisation de takeWhile");
		Stream.of(1, 2, 3, 4, 3, 2, 1).takeWhile(e -> e < 4).forEach(System.out::println);

		System.out.println("\r\nUtilisation de dropWhile");
		Stream.of(1, 2, 3, 4, 3, 2, 1).dropWhile(e -> e < 4).forEach(System.out::println);
	}

}
