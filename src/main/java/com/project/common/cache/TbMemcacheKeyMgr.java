package com.project.common.cache;

/**
 * Created by LQL on 2016/12/17.
 */
public class TbMemcacheKeyMgr {

    /**
     * TOKEN值的key
     */
    public static String getTokenValueKey(String userId) {
        return MemcachedObjectType.TOKEN_VALUE.getPrefix() + "userId:" + userId;
    }

    /**
     * LoginToken的key
     */
    public static String getTokenKey(String token) {
        return MemcachedObjectType.TOKEN.getPrefix() + "token:" + token;
    }

    /**
     * 短信验证码key
     */
    public static String getSmsCodeKey(String userId, String phone, String sessionName) {
        return MemcachedObjectType.SMS_CODE.getPrefix() + "userId:" + userId + "phone:" + phone + "sessionName:" + sessionName;
    }

    /**
     * 验证码key
     *
     */
    public static String getCheckCodeKey(Long userId, String operate) {
        return MemcachedObjectType.CHECK_CODE.getPrefix() + "userId:" + userId + "operate:" + operate;
    }

    /**
     * 获取user的key
     */
    public static String getUserKey(Long id) {
        return MemcachedObjectType.USER.getPrefix() + "userId:" + id;
    }

    /**
     * 商品key
     */
    public static String getProductsKey() {
        return MemcachedObjectType.PRODUCTS.getPrefix();
    }

    /**
     * 宝箱key
     *
     * @param token
     * @return
     */
    public static String getChestsKey(String token) {
        return MemcachedObjectType.CHESTS.getPrefix();
    }
}
