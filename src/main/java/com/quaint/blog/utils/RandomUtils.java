package com.quaint.blog.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019/11/29 11:14
 */
public class RandomUtils {

    public static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LETTER_CHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBER_CHAR = "0123456789";


    /**
     * 生成指定范围内的随机数
     * @param scopeMin
     * @param scopeMax
     * @return
     */
    public static int getInteger(int scopeMin, int scopeMax) {
        Random random = new Random();
        return (random.nextInt(scopeMax) % (scopeMax - scopeMin + 1) + scopeMin);
    }

    /**
     * 返回固定长度的数字
     * @param length
     * @return
     */
    public static String getNumber(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String getString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯字母字符串(只包含大小写字母)
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String getLetterString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(LETTER_CHAR.charAt(random.nextInt(LETTER_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个UUID
     * @return 小写的UUID
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

}
