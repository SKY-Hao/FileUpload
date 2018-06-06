package com.songwen.ping.web;

import com.songwen.ping.entity.User;
import com.songwen.ping.repostiory.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */
@RestController
public class UserController {

    @Autowired
    private UserRespository userRespository;

    @RequestMapping(value = "/list")
    public List<User> list(){


        return userRespository.findAll();
    }

    @RequestMapping(value = "/add")
    public String add(){
        User user = new User();

        user.setName("张珊");
        user.setAddress("青岛");
        user.setAge(120);
        user.setPassword("121212");
        userRespository.save(user);
        return "添加成功";
    }


    @RequestMapping(value = "/delete")
    public  String delete(Integer id){

        userRespository.deleteById(id);
        return "用户删除成功";
    }


    @RequestMapping(value = "/age")
    public List<User> age(){
        return userRespository.nativeQuery(20);
    }



    @RequestMapping(value = "/deleteWhere")
    public String deleteWhere(){

        userRespository.deleteQuery("test2","123456");
        return "删除成功";
    }



   /* @RequestMapping(value = "/cutPage")
    public List<User> cutPage(int page){

        User user = new User();
        user.setSize(2);
        user.setSord("desc");
        user.setPage(page);

        Sort.Direction sort = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord())?Sort.Direction.ASC:Sort.Direction.DESC;
        //设置排序对象参数
        Sort sorts = new Sort(sort,user.getSidx());
        //创建分页对象
        PageRequest pageRequest = new PageRequest(user.getPage()-1,
                user.getSize(),sorts);
        //执行分页查询
        return userRespository.findAll(pageRequest).getContent();
    }*/






















}
