package com.songwen.ping.repostiory;

import com.songwen.ping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */
public interface UserRespository  extends JpaRepository<User,Integer>{

    @Query(value = "select *from t_user where age > 20",nativeQuery = true)
    public List<User> nativeQuery(int age);

    @Transactional
    @Modifying
    @Query(value = "delete from t_user where name =?1 and password=?2",nativeQuery = true)
    public   void deleteQuery(String name, String password);


}
