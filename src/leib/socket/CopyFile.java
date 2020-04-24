package leib.socket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int date = 0;
		System.out.print("请输入您要拷贝的源文件：");
		String file1 = input.next();
		System.out.print("请输入您要拷贝的目标位置：");
		String file2 = input.next();
		try {
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			while ((date = fis.read()) != -1) {
				// 读取文件
				fos.write(date);
			}
			fis.close();
			fos.close();
			System.out.println("拷贝成功！");
		} catch (FileNotFoundException e) {
			System.out.println("源文件未找到！");
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
	}
}
