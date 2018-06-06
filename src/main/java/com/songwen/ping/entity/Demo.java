package com.songwen.ping.entity;

import com.songwen.ping.service.FlagValidator;
import org.hibernate.validator.constraints.Length;
import sun.awt.SunHints;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/14.
 */
public class Demo implements Serializable {


    @NotBlank
    @Length(min = 2,max = 10)
    private  String name;

    @Min(value = 1)
    private int age;


    @NotBlank
    @Email
    private  String mail;

    @FlagValidator(values = "1,2,3")
    private String flag;


    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
