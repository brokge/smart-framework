package com.udaye.framework.helper;

import com.udaye.framework.annotation.Action;
import com.udaye.framework.annotation.Controller;
import com.udaye.framework.bean.Handler;
import com.udaye.framework.bean.Request;
import com.udaye.framework.util.ArrayUtil;
import com.udaye.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 用于存放 请求与处理器的映射关系 （简称 Action Map）
 * <p>
 * Created by chenlw on 16-8-5.
 */
public class ControllerHelper {

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取 所有的 Controller 类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();

        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            //遍历这些 controller 类
            for (Class<?> controllerCLass : controllerClassSet) {
                //获取 Controller 类中定义的方法
                Method[] methods = controllerCLass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    //遍历这些类中的方法
                    for (Method method : methods) {
                        //判断这些方法中是否 有 action 注解
                        if (method.isAnnotationPresent(Action.class)) {
                            //从Action注解中获取 url 映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证 URL 映射规则
                            if (mapping.matches("\\w+:/||w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                    //获取请求方法与请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerCLass, method);
                                    //初始化 Action Map
                                    ACTION_MAP.put(request, handler);
                                }
                            }

                        }

                    }

                }

            }

        }

    }


    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }

}
