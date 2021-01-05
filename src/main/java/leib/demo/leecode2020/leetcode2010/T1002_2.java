package leib.demo.leecode2020.leetcode2010;

import java.util.concurrent.*;

/**
 * @Author:Leib
 * @Date 2020/10/2 15:29
 */
public class T1002_2 {
    public static void main(String[] args) {
// 自定义线程池！工作 ThreadPoolExecutor
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()); //队列满了，尝试去最早的竞争，也不会抛出异常！
        try {
// 最大承载：Deque + max
// 超过 RejectedExecutionException
            for (int i = 1; i <= 9; i++) {
// 使用了线程池之后，使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
// 线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }

}
