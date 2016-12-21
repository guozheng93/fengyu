package com.fengyu.web.shop.action.news;

import com.fengyu.facade.user.login.entity.po.UserPO;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * @author admin
 * @version V1.0
 * @date 2016/12/17
 */
public class WebAction {

    public static void c1(){
        UserPO userPO = new UserPO();
        userPO.setId(11111);
        System.out.println(userPO +"========="+userPO.getId());
        c2(userPO);
        System.out.println(userPO +"========="+userPO.getId());

    }
    public static void c2(UserPO userPO){
        userPO.setId(2);
        System.out.println(userPO +"========="+userPO.getId());
    }

    public static void c3(){
        String i= "1111111111111";
        System.out.println(i);
        c4(i);
        System.out.println(i);

    }
    public static void c4(String i){
        i+= "222222";
        System.out.println(i);
    }

    public static void main(String[] args) {
        c1();
    }


}
