package com.quaint.blog.utils;

import org.modelmapper.ModelMapper;

import java.util.Objects;

/**
 * @Description: ModelMapper
 * @author: qi cong
 * @Date: Created in 2019-11-30 16:38
 */
public class MapperUtils {

    private static final ModelMapper modelMapper;

    static{
        modelMapper = new ModelMapper();
    }

    private MapperUtils() {
    }

    /**
     * 对象转换为对象
     * @param source 原对象
     * @param target 目标对象
     */
    public static void map(Object source,Object target){
        modelMapper.map(source,target);
    }

    /**
     * 将对象转换为目标class对象，并返回
     * @param source 原对象
     * @param destinationType 目标对象class
     * @param <T>
     * @return
     */
    public static <T> T map(Object source, Class<T> destinationType){
        if (Objects.isNull(source)) return null;
        return modelMapper.map(source,destinationType);
    }

}
