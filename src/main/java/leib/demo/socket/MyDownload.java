package leib.demo.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author:Leib
 * @Date 2020/4/24 15:35
 */
public class MyDownload implements  Runnable{
    private Socket socket;
    public  MyDownload(Socket socket){
        this.socket= socket;
    }
    @Override
    public void run() {

        try{
            System.out.println("服务器连接成功");
            //服务端向客户端发送信息
            OutputStream out = socket.getOutputStream();

            //例： 传输字符
            String info = "hello";
            //需要传输的是字节数组
            out.write(info.getBytes());

            //准备发送文件
            File file = new File("D:\\myCode\\a.txt");
            //讲文件读入内存
            InputStream fileIn = new FileInputStream(file);
            byte[] fileBytes = new byte[100];
            int len = -1;
            while ((len = fileIn.read(fileBytes)) != -1) {
                out.write(fileBytes, 0, len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
