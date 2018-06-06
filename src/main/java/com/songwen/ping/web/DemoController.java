package com.songwen.ping.web;
import com.songwen.ping.entity.Demo;
import org.springframework.context.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2018/5/14.
 */
@RestController
public class DemoController {

    @Autowired
    MessageSource messageSource;



    @RequestMapping(value = "/validator")
    public  String validator(@Valid Demo demo, BindingResult result){
        if (result.hasErrors()){
            StringBuffer msg = new StringBuffer();
            //获取错误字段集合
            List<FieldError> fieldErrors = result.getFieldErrors();
            //获取本地local。zh_cn
            Locale currentLocale = LocaleContextHolder.getLocale();
            //遍历错误字段获取错误信息
            for (FieldError fieldError : fieldErrors){
                //获取错误信息
                String erroMessage = messageSource.getMessage(fieldError,currentLocale);
                //添加到错误消息集合内
                msg.append(fieldError.getField() + ":" + erroMessage + ",");
            }
            return msg.toString();
        }
        return "验证通过，"+"名称：" + demo.getName() + "年龄："+ demo.getAge() + "邮箱地址：" + demo.getMail();

    }


}
