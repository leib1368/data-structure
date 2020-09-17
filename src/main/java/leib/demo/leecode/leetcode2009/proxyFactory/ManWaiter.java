package leib.demo.leecode.leetcode2009.proxyFactory;

public class ManWaiter implements Waiter {
	public void serve() {
		System.out.println("服务中...");
	}
	
	public void shouQian() {
		System.out.println("混蛋，给我钱！");
	}
}
