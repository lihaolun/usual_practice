package com.atguigu.exer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 多线程交替打印
 * @author lihaolun
 *
 */
class ShareResource {
	private int num = 1;
	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();

	public void print5(int totalLoop) {
		lock.lock();
		try {
			if (num != 1) {
				condition1.await();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t totalLoop" + totalLoop);
			}
			num = 2;
			condition2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print10(int totalLoop) {
		lock.lock();
		try {
			if (num != 2) {
				condition2.await();
			}
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t totalLoop" + totalLoop);
			}
			num = 3;
			condition3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print15(int totalLoop) {
		lock.lock();
		try {
			if (num != 3) {
				condition3.await();
			}
			for (int i = 0; i < 15; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t totalLoop" + totalLoop);
			}
			num = 1;
			condition1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}

public class LoopPrint {
	public static void main(String[] args) {
		ShareResource shareResource = new ShareResource();
		new Thread(() -> {
			for (int i = 1; i <= 10; i++)
				shareResource.print5(i);
		}, "A").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++)
				shareResource.print10(i);
		}, "B").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++)
				shareResource.print15(i);
		}, "C").start();
	}

}
