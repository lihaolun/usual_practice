package com.atguigu.exer;
/**
 * ����
 * @author lihaolun
 *
 */
//����ʽ
public class Single {
	private static Single single = null;

	private Single() {

	}

	public static Single getInstance() {
		if (single == null) {
			synchronized (Single.class) {
				if (single==null) {
					single = new Single();
				}
			}
			
		}
		return single;
	}
}

// ����ʽ
class Single2 {
	private static Single2 single2 = new Single2();

	private Single2() {

	}

	public static Single2 getInstance() {
		return single2;
	}
}
