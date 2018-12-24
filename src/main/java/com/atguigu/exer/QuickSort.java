package com.atguigu.exer;

import java.util.Arrays;
/**
 * 快速排序
 * @author lihaolun
 *
 */
public class QuickSort {
	public static void sort(int[] arry, int left, int right) {
		if (left >= right) {
			return;
		}
		//设置最左边为基准为，往后每次递归改变
		int key = arry[left];
		// 因为要递归调用，所以用i,j来接收left和right
		int i = left, j = right;
		while (i < j) {
			//从右往左找第一个小于key的元素
			while (arry[j] > key && i < j) {
				j--;
			}
			//从左往右找第一个大于key的元素
			while (arry[i] <= key && i < j) {
				i++;
			}
			//i和j纸箱的元素交换
			if (i < j) {
				int temp = arry[i];
				arry[i] = arry[j];
				arry[j] = temp;
			}
		}
		//将基准与i交换重新设置，否则再次递归又重置为left
		arry[left]=arry[i];
		arry[i]=key;
		// 调整key的位置
		sort(arry, left, i - 1);
		sort(arry, i+1, right);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 5, 78, 22, 80 };
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
