package com.songwen.ping.service;

import com.songwen.ping.entity.User;
import com.songwen.ping.repostiory.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.persistence.Cacheable;
import java.util.List;

/**
 * Created by Administrator on 2018/5/14.
 */
@Service
public class UserServiceImpl{

    @Autowired
    private UserRespository userRespository;




}
