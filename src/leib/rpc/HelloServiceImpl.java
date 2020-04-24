package leib.rpc;

/**
 * @Author:Leib
 * @Date 2020/4/24 14:07
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHi(String name) {
        System.out.println("hi"+name);
    }
}
