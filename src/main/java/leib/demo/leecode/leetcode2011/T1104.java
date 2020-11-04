package leib.demo.leecode.leetcode2011;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:Leib
 * @Date 2020/11/4 8:25
 */
public class T1104 {
    public static void main(String[] args) {
        String jsonArrStr = "[ { \"ID\": \"2016-05-25\", \"Name\": \"Fargo Chan\" },{ \"ID\": \"2016-05-23\", \"Name\": \"Aaron Luke\" },{ \"ID\": \"2016-05-26\", \"Name\": \"Dilip Singh\" }]";
        System.out.println("排序前："+jsonArrStr);
        String jsonArraySort = jsonArraySort(jsonArrStr);
        System.out.println("排序后："+jsonArraySort);
    }
    public static String jsonArraySort(String jsonArrStr) {

        List<MapTest> list= new Gson().fromJson(jsonArrStr,new TypeToken<List<MapTest>>(){}.getType());
        Map<String, List<MapTest>> collect = list.stream().collect(Collectors.groupingBy(MapTest::getID));
        String s = new Gson().toJson(collect);
        System.out.println("s = " + s);
        return s;
    }
}
@Data
class MapTest{
    String ID;
    String Name;
}
