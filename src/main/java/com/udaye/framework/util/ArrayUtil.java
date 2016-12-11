package com.udaye.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by chenlw on 16-8-5.
 */
public class ArrayUtil {
    /**
     * 判断数组是否为非空
     *
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }

}
