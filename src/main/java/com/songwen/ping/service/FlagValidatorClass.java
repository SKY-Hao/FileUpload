package com.songwen.ping.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Administrator on 2018/5/14.
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Object>{


    //临时遍历保存flag值列表
    private String values;

    //初始化values的值
    @Override
    public void initialize(FlagValidator flagValidator) {
        //将直接内配置的值赋给临时变量
        this.values=flagValidator.values();
    }

    //实现验证
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

      //分割定义的有校值
        String[] valu_arry = values.split(",");
        boolean isFlag = false;
        //遍历比对有效值
        for (int i=0;i<valu_arry.length;i++){
            //存在一致跳出循环。赋值isFlag=true
            if(valu_arry[i].equals(value)){
                isFlag=true;
                break;
            }
        }

        //返回是否存在boolean
        return isFlag;
    }
}
