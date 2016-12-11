package com.udaye.framework;

import com.udaye.framework.helper.*;
import com.udaye.framework.util.ClassUtil;

/**
 * 加载相应的 helper 类
 * Created by chenlw on 16-8-5.
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                AopHelper.class,
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class,
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
