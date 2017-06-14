package com.project.common.cache;

/**
 * 统一定义Memcached中存储的各种对象的Key前缀和超时时间.
 */
public enum MemcachedObjectType {
	MESSAGE("message:",10),		//消息10s失效

	USER("user:", 60 * 60 * 1), // 用户，1小时失效

	TOKEN_VALUE("tokenValue:", 60 * 60 * 24 * 7), // tokenValue。一周失效

	TOKEN("loginToken:", 60 * 60 * 1), // token，60分钟失效

	CHECK_CODE("checkCode:", 60 * 1), // 验证码，1分钟失效

	SMS_CODE("smsCode:", 60 * 10), // 短信验证码，10分钟失效

	CHESTS("chests:", 5 * 60 * 1), // 宝箱，5分钟失效

	PRODUCTS("products:", 60 * 60 * 24), // 商品，60分钟失效

	NOTICES("notices:", 60 * 60 * 24), // 商品，60分钟失效

	TASKS("tasks:", 60 * 60 * 24), // 任务，60分钟失效

	RANKING("ranking:", 60 * 60 * 24), // 排名，60分钟失效

	PLAYER_LIVE("player:",60 * 60 * 24),  //玩家在内存中存在时间

	APPLY_OWNER_LIVE_TIME("applyOwner:", 60 * 1), // 庄家候选人，1分钟失效

	BUREAU_CARD_LIVE_TIME("bureauCard:", 20 * 60 * 1), // 牌局扑克，20分钟失效

	//内存中永久有效
	FOREVER("forever",Integer.MAX_VALUE - 1)
	;


	private String prefix;

	private int expiredTime;

	MemcachedObjectType(String prefix, int expiredTime) {
		this.prefix = prefix;
		this.expiredTime = expiredTime;
	}

	public String getPrefix() {
		return "gameOptId:"
		// + Constants.GAME_OPT_ID
		        + ":" + prefix;
	}

	public int getExpiredTime() {
		return expiredTime;
	}

}
