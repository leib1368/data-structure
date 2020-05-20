package leib.demo.thread.demo;

/**
 * @Author:Leib
 * @Date 2020/5/14 13:17
 */
public class TestThread02 extends Thread{

    private String url ;
    private String name ;

    public TestThread02( String url ,String name){
        this.url = url ;
        this.name = name ;
    }

    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.dowanloader(url,name);
        System.out.println("下载名为"+name);
    }

    public static void main(String[] args) {
        TestThread02 t1 = new TestThread02("https://www.pinterest.com/pin/666673551071273918/","1.png");
        TestThread02 t2 = new TestThread02("https://www.pinterest.com/pin/666673551071273918/","2.png");
        TestThread02 t3 = new TestThread02("https://www.pinterest.com/pin/666673551071273918/","3.png");

        t1.start();
        t2.start();
        t3.start();
    }
}

/*class WebDownloader{
    public void dowanloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("try catch 异常");
        }
    }
}*/
