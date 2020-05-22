package leib.demo.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author:Leib
 * @Date 2020/5/20 13:19
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //如何启动callable
        new Thread().start();

        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread);

        new Thread(futureTask,"a").start();

        Integer o = (Integer) futureTask.get();
        System.out.println(o);
    }
}
class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}
