package com.quaint.blog.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 用户上下文环境
 * @author: qi cong
 * @Date: Created in 2019-12-11 09:30
 */
public class MUOContext {

    private static ThreadLocal<Map<String,Object>> threadLocalMap = new ThreadLocal<>();

    // 用户id 的key
    private static final String MEMBER_ID = "member_id";

    /**
     * 获取用户id
     * @return
     */
    public static Integer getMemberId(){
        return getVal(MEMBER_ID);
    }

    /**
     * 设置用户id
     * @param memberId
     */
    public static void setMemberId(Integer memberId){
        setVal(MEMBER_ID, memberId);
    }


    // 获取map
    private static Map<String,Object> getMap(){
        Map<String,Object> map = threadLocalMap.get();
        // 防止并发产生多个map，导致 部分用户id 获取失败
        if(map == null) map = initMap();
        return map;
    }

    // 初始化map
    private synchronized static Map<String,Object> initMap(){
        if(threadLocalMap.get() == null)
            threadLocalMap.set(new HashMap<>());
        return threadLocalMap.get();
    }


    private static void setVal(String key, Object obj){
        getMap().put(key,obj);
    }

    private static <T> T getVal(String key){
        Object obj = getMap().get(key);
        return  obj == null ? null : (T) obj;
    }

    public static void clean() {
        threadLocalMap.remove();
    }


}
