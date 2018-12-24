package com.atguigu.exer;

import java.util.Arrays;
/**
 * ��������
 * @author lihaolun
 *
 */
public class QuickSort {
	public static void sort(int[] arry, int left, int right) {
		if (left >= right) {
			return;
		}
		//���������Ϊ��׼Ϊ������ÿ�εݹ�ı�
		int key = arry[left];
		// ��ΪҪ�ݹ���ã�������i,j������left��right
		int i = left, j = right;
		while (i < j) {
			//���������ҵ�һ��С��key��Ԫ��
			while (arry[j] > key && i < j) {
				j--;
			}
			//���������ҵ�һ������key��Ԫ��
			while (arry[i] <= key && i < j) {
				i++;
			}
			//i��jֽ���Ԫ�ؽ���
			if (i < j) {
				int temp = arry[i];
				arry[i] = arry[j];
				arry[j] = temp;
			}
		}
		//����׼��i�����������ã������ٴεݹ�������Ϊleft
		arry[left]=arry[i];
		arry[i]=key;
		// ����key��λ��
		sort(arry, left, i - 1);
		sort(arry, i+1, right);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 5, 78, 22, 80 };
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
