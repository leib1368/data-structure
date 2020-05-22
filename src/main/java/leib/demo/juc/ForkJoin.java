package leib.demo.juc;

import java.util.concurrent.RecursiveTask;

/**
 * @Author:Leib
 * @Date 2020/5/21 16:54
 */
public class ForkJoin extends RecursiveTask<Long> {
    private Long start ;
    private Long end  ;

    private Long temp =10000L;

    ForkJoin(Long start, Long end){
        this.start = start ;
        this.end = end ;
    }
    @Override
    protected Long compute() {
        if((end-start)<temp){
            Long sum = 0L;
            for (Long i = 0L; i <= end ; i++) {
                sum += i;
            }
            return  sum;
        }else {
            long middle = (start+end) / 2 ;
            ForkJoin task1 = new ForkJoin(start,middle);
            task1.fork();
            ForkJoin task2 = new ForkJoin(middle+1,end);
            task2.fork();

            return task1.join()+task2.join();
        }
    }
}
