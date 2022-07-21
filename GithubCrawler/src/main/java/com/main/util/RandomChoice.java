package com.main.util;

import java.util.List;
import java.util.Random;

/**
 * Random choose an element from a collection or map
 */
public class RandomChoice {
	public static <E> E oneFromCollection(List<E> inputCollect) {
		
		if (inputCollect.size() == 0) {
			return null;
		}
		Random rand = new Random();
		E elm = inputCollect.get(rand.nextInt(inputCollect.size()));
		return elm;
	}
}
