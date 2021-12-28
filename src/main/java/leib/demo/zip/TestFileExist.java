package leib.demo.zip;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import java.io.File;

public class TestFileExist {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/lixuedan/Desktop/leib常用文档/档案产品部沟通会议记录表.xls");
        boolean result = isParseFile(file);
    }

    private static boolean isParseFile(File file) throws Exception {
        try {
            Tika tika = new Tika();
            String filecontent = tika.parseToString(file);
            //System.out.println(filecontent);
            System.out.println("true");
            return true;
        } catch (TikaException e) {
            System.out.println("false");
            return false;
        }
    }
}
