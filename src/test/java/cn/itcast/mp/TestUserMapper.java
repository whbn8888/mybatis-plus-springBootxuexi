package cn.itcast.mp;

import cn.itcast.mp.mapper.UserMapper;
import cn.itcast.mp.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setMail("1@wuhang");
        user.setAge(31);
        user.setName("仵1");
        user.setUserName("wuhang2");
        user.setPassword("12345461");
        user.setAddress("北京");
        int result = this.userMapper.insert(user);//result是数据库受影响的行数
        System.out.println("result =>"+result);

        //获取自增后的id值,自增长后的id值,会回填到我们的user中
        System.out.println("id="+user.getId());

    }

    @Test
    public void testSelectById(){
        User user = this.userMapper.selectById(1);
        System.out.println("user是"+user);
    }

    @Test
    public void updateByID(){
        User user = new User();
        user.setId(1l);//根据条件进行更新
        user.setAge(99);//更新的字段
        user.setPassword("666");//更新的字段
        int result = this.userMapper.updateById(user);
        System.out.println("result =>"+result);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setAge(12);
        user.setName("王博");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //根据userName是张三的
        queryWrapper.eq("user_name","zhangsan");
        //根据条件做更新
        int result = this.userMapper.update(user, queryWrapper);
        System.out.println("result =>"+result);
    }



    @Test
    public void testUpdate2(){

        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("age",21).set("password","9999")//更新的字段
        .eq("user_name","zhangsan");//更新的条件
        //根据条件做更新
        int result = this.userMapper.update(null, wrapper);
        System.out.println("result =>"+result);
    }

    @Test
    public void testdeleteById(){
        //根据Id删除数据
        int result = this.userMapper.deleteById(8l);
        System.out.println("result=>"+result);
    }









}
