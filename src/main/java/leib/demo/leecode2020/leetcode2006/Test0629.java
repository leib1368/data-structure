package leib.demo.leecode2020.leetcode2006;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author:Leib
 * @Date 2020/6/29 15:06
 */
@SpringBootTest
public class Test0629 {
    @Autowired
    private StringRedisTemplate stringRedisTemplate ;

    @Test
    public void A(){
        BoundValueOperations<String, String> ops = stringRedisTemplate.boundValueOps("kill3");
        ops.append("xxx");
        String s = ops.get();
        System.out.println(s);

    }
}
