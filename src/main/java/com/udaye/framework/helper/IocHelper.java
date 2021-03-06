package com.udaye.framework.helper;

import com.udaye.framework.annotation.Inject;
import com.udaye.framework.util.ArrayUtil;
import com.udaye.framework.util.CollectionUtil;
import com.udaye.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 控制反转（inversion of Control）
 * 依赖注入助手类
 * <p>
 * Created by chenlw on 16-8-5.
 */
public final class IocHelper {
    static {
        //获取所有的 Bean 类 与 bean 实例之间的映射关系（简称 BeanMap）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            //遍历 Bean Map
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //从 BeanMap 中获取Bean 类与 Bean 实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取 Bean 类定义的所有成员变量（简称 Bean Field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    //遍历 Bean Field
                    for (Field beanField : beanFields) {
                        //判断当前 Bean Field 是否带有 Inject 注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在Bean Map 中获取Bean Field 对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                //通过反射初始化 Bean Field 的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }

}
