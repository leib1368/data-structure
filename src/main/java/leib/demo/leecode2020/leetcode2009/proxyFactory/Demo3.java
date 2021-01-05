package leib.demo.leecode2020.leetcode2009.proxyFactory;

import org.junit.Test;

/*
 * 目标是让目标对象和增强都可以切换！
 */
public class Demo3 {
	@Test
	public void fun1() {
		ProxyFactory factory = new ProxyFactory();//创建工厂
		factory.setTargetObject(new ManWaiter());//设置目标对象
//		factory.setBeforeAdvice(new BeforeAdvice() {//设置前置增强
//			public void before() {
//				System.out.println("您好不好！");
//			}
//		});
		
		factory.setAfterAdvice(new AfterAdvice() {//设置后置增强
			public void after() {
				System.out.println("再见不见！");
			}
		});
		
		Waiter waiter = (Waiter)factory.createProxy();
		waiter.shouQian();
	}
	
	public void zhuanZhang() {
		/*
		 * 1.
		 * 2. 
		 * 3. 
		 */
	}
}
