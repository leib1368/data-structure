package leib.demo.thread.demo;



import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @Author:Leib
 * @Date 2020/5/14 14:32
 */
public class TestCallable implements Callable<Boolean> {
    private String url ;
    private String name ;

    public TestCallable( String url ,String name){
        this.url = url ;
        this.name = name ;
    }
    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.dowanloader(url,name);
        System.out.println("下载名为"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://www.pinterest.com/pin/666673551071273918/","1.png");
        TestCallable t2 = new TestCallable("https://www.pinterest.com/pin/666673551071273918/","2.png");
        TestCallable t3 = new TestCallable("https://www.pinterest.com/pin/666673551071273918/","3.png");

        //创建执行服务：线程池
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);

        //获取结果
        Boolean r1 = result1.get();
        Boolean r2 = result2.get();
        Boolean r3 = result3.get();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        //关闭服务
        ser.shutdownNow();
    }
}

class WebDownloader{
    public void dowanloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("try catch 异常");
        }
    }
}

