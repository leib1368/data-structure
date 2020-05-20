package leib.demo.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:Leib
 * @Date 2020/4/24 14:29
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        //绑定端口 ip默认为本机ip
        ServerSocket server = new ServerSocket(9999);

        while(true){
            //返回值是socket 不是serverSocket
            Socket socket = server.accept();

            /*   //下载所用的线程
            MyDownload download = new MyDownload(socket);
            //Runnable 需要先转换为 Thread
            Thread downLoadThread = new Thread(download);
            downLoadThread.start();*/
            new Thread(new MyDownload(socket)).start();
        }


        /*
        接受客户端
        InputStream in  = socket.getInputStream();
        byte[] bs = new byte[100];
        in.read(bs);
        System.out.println("接收客户端"+new String(bs));

        fileIn.close();
        out.close();
        //in.close();
        socket.close();
        server.close();
        */


    }
}
