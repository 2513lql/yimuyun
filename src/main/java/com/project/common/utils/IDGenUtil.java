package com.project.common.utils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by LQL on 2016/12/12.
 */
public class IDGenUtil {

    //生成数据表中的ID字段
    public static String generateId(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-","");
        return uuid;
    }

    //生成图片名
    public static String generateFileName(){

        StringBuffer result = new StringBuffer("");
        String time = DateUtil.startDate2str(new Date()).substring(0,10);
        time = time.replaceAll("-","") + generateId().substring(0,6);
        result.append(time);
        return result.toString();
    }

    //生成用户邀请码
    public static String generateInvitedCode(){
       return generateId().substring(0,8);
    }

    public static String generateRoomId(){
        Random random = new Random();
        String result="";
        for(int i=0;i<6;i++) {
            result += random.nextInt(10);
        }
        return result;
    }

    public static String generaUUID(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","");
        return uuid.substring(0,13);
    }

    public static void main(String[] args) {
//        System.out.println(generateId());
//        System.out.println(generateUserAccount());
//        System.out.println(generateInvitedCode());
        System.out.println(generateId());
    }

}
