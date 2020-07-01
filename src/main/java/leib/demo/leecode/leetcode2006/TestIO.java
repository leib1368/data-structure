package leib.demo.leecode.leetcode2006;

import java.io.*;

/**
 * @Author:Leib
 * @Date 2020/6/21 9:58
 */
public class TestIO {
    public static void main(String[] args) throws IOException {
//        FileWriter fw = new FileWriter("Buffered.txt");
//        fw.write("ok168");
//		fw.close();

/*        BufferedWriter bufw = new BufferedWriter(fw);

        //使用缓冲区中的方法将数据写入到缓冲区中。
        bufw.write("hello world !");
        bufw.newLine();
        bufw.newLine();
        bufw.write("!hello world !");
        bufw.write("!hello world !");
        //使用缓冲区中的方法，将数据刷新到目的地文件中去。
        bufw.flush();
        //关闭缓冲区,同时关闭了fw流对象
        bufw.close();*/

/*        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');*/

        int b;
        b = 'A';
        System.out.println(b);
        System.out.write(b);
        System.out.write('\n');
        System.out.println(b);
    }
}
