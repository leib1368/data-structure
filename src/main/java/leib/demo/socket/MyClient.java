package leib.demo.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author:Leib
 * @Date 2020/4/24 14:31
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        //客户端 连接服务器发布的服务
        Socket socket = new Socket("127.0.0.1",9999);
        //接受服务器发来的信息 InputStream
        InputStream in = socket.getInputStream();


        //例接收普通文字hello   ↓存储的字节数组
        byte[] bs = new byte[100];
        //收发来的数组
        in.read(bs);
        System.out.println(new String(bs));

        //返回消息 即客户端向服务端发送信息啦
        OutputStream out = socket.getOutputStream();
        out.write("world".getBytes());

        //----------------------------------
        //接收文件
        InputStream inFile = socket.getInputStream();
        //接受发来的信息
        byte[] fileBytes = new byte[100];
        //定义的长度
        int len = -1;
        //输出到内存
        OutputStream fileOut = new FileOutputStream("D:\\myCode\\a123.txt");


        while((len = inFile.read(fileBytes))!=-1){
            fileOut.write(fileBytes,0,len);
        }
        System.out.println("下载成功");
        //循环读取


        fileOut.close();
        //out.close();
        in.close();
        socket.close();
    }

}
