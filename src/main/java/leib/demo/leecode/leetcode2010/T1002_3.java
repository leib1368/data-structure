package leib.demo.leecode.leetcode2010;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Author:Leib
 * @Date 2020/10/2 19:11
 */
public class T1002_3 {
    public static void main(String[] args) throws ExecutionException,
            InterruptedException {
// test1(); // 12224
 test2(); // 10038
// test3(); // 153
    }

    // 普通程序员
    public static void test1() {
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间：" + (end - start));
    }

    // 会使用ForkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);

//        ForkJoinTask<Long> submit = forkJoinPool.submit(task);// 提交任务
//        Long sum = submit.get();
        forkJoinPool.execute(task);
        long end = System.currentTimeMillis();
        System.out.println("sum=" + "sum"+ " 时间：" + (end - start));
    }

    public static void test3() {
        long start = System.currentTimeMillis();
// Stream并行流 () (]
        long sum = LongStream.rangeClosed(0L,
                10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println("sum=" + "时间：" + (end - start));
    }


}
