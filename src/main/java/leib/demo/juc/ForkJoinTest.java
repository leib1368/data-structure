package leib.demo.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Author:Leib
 * @Date 2020/5/21 16:30
 */
public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test2();//test1 time=8196  test2 time=?  test3 time=1516
    }

    public static void test1(){
        Long sum = 0L;
        Long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        Long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"time="+(end-start));
    }
    public static void test2() throws ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoin(0L,10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();

        Long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"time="+(end-start));
    }
    public static void test3(){
        Long start = System.currentTimeMillis();

        Long sum = LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0,Long::sum);
        Long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"time="+(end-start));
    }
}
