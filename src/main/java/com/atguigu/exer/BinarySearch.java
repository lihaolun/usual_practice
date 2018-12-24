package com.atguigu.exer;

/**
 * 二分法查找
 * 
 * @author lihaolun
 *
 */
public class BinarySearch {
	public static <E extends Comparable<E>> int binarySearch(E[] array, int from, int to, E key)
			throws IllegalAccessException {
		if (from < 0 || to < 0) {
			throw new IllegalAccessException("params fromtoArr must large than 0");
		}
		if (from <= to) {
			int middle = (from >>> 1) + (to >>> 1);
			E word = array[middle];

			if (word.compareTo(key) > 0) {
				to = middle - 1;
			} else if (word.compareTo(key) < 0) {
				from = middle + 1;
			} else {
				return middle;
			}
		}
		return binarySearch(array, from, to, key);
	}

	public static void main(String[] args) throws Exception{
		Integer arr[] = { 1, 2, 3, 12, 45, 67, 67, 89, 100 };
		Integer integer = new Integer(100);
		System.out.println(binarySearch(arr, 0, arr.length-1, integer));
	}
}
