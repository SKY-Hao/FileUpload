package com.songwen.ping.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/11.
 */
@RestController
public class LoggerController {
    private   final static Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping(value = "/loger")
    public  String index(){

        logger.debug("记录了debug日志");
        logger.info("访问了Index方法");
        logger.error("记录了erro错误日志");
        return "index";
    }

}
