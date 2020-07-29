package fastjosn;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class JsonTest {

    public static void main(String[] args) {
        ResMessage resMessage = new ResMessage();

        resMessage.setRpid("111");

        User user1 = new User();
        user1.setUsername("aaa");

        User user2 = new User();
        user2.setUsername("bbb");

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        resMessage.put("resultList", userList);

        String text = JSON.toJSONString(resMessage);
        System.out.println(text);
    }
}
