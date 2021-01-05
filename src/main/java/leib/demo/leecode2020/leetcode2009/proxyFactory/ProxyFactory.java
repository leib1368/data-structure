package leib.demo.leecode2020.leetcode2009.proxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 它用来生成代理对象
 * 它需要所有的参数
 * * 目标对象
 * * 增强
 * @author cxf
 */
/**
 * 1. 创建代理工厂
 * 2. 给工厂设置三样东西：
 *   * 目标对象：setTargetObject(xxx);
 *   * 前置增强：setBeforeAdvice(该接口的实现)
 *   * 后置增强：setAfterAdvice(该接口的实现)
 * 3. 调用createProxy()得到代理对象
 *   * 执行代理对象方法时：
 *   > 执行BeforeAdvice的before()
 *   > 目标对象的目标方法
 *   > 执行AfterAdvice的after()
 * @author cxf
 *
 */
public class ProxyFactory {
	private Object targetObject;//目标对象
	private BeforeAdvice beforeAdvice;//前置增强
	private AfterAdvice afterAdvice;//后置增强

	public Object createProxy() {
		/*
		 * 1. 给出三大参数
		 */
		ClassLoader loader = this.getClass().getClassLoader();
		Class[] interfaces = targetObject.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				/*
				 * 在调用代理对象的方法时会执行这里的内容
				 */
				// 执行前置增强
				if(beforeAdvice != null) {
					beforeAdvice.before();
				}
				
				Object result = method.invoke(targetObject, args);//执行目标对象的目标方法
				// 执行后置增强
				if(afterAdvice != null) {
					afterAdvice.after();
				}
				
				// 返回目标对象的返回值
				return result;
			}
		};
		/*
		 * 2. 得到代理对象
		 */
		Object proxyObject = Proxy.newProxyInstance(loader, interfaces, h);
		return proxyObject;
	}
	
	
	public Object getTargetObject() {
		return targetObject;
	}
	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}
	public BeforeAdvice getBeforeAdvice() {
		return beforeAdvice;
	}
	public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
		this.beforeAdvice = beforeAdvice;
	}
	public AfterAdvice getAfterAdvice() {
		return afterAdvice;
	}
	public void setAfterAdvice(AfterAdvice afterAdvice) {
		this.afterAdvice = afterAdvice;
	}
}
