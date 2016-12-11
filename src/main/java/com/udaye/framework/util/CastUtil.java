package com.udaye.framework.util;

/**
 * 转型操作工具类
 * Created by chenlw on 16-7-30.
 */
public class CastUtil {
    /**
     * 转为 String 类型
     *
     * @param object
     * @return
     */
    public static String castString(Object object) {
        return CastUtil.castString(object, "");

    }

    /**
     * 转为 String 类型
     *
     * @param object
     * @param defaultValue
     * @return
     */
    public static String castString(Object object, String defaultValue) {
        return object != null ? String.valueOf(object) : defaultValue;

    }

    /**
     * 转为 double类型
     *
     * @param object
     * @return
     */
    public static double castDouble(Object object) {
        return CastUtil.castDouble(object, 0);

    }

    /**
     * 转为 double类型
     *
     * @param object
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object object, double defaultValue) {
        double doubleValue = defaultValue;
        if (object != null) {
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }

            }

        }
        return doubleValue;
    }

    /**
     * 转为 long 类型
     *
     * @param object
     * @return
     */
    public static long castLong(Object object) {
        return CastUtil.castLong(object, 0);
    }

    /**
     * 转为 long 类型
     *
     * @param object
     * @param defaultValue
     * @return
     */
    public static long castLong(Object object, long defaultValue) {
        long longVaule = defaultValue;
        if (object != null) {
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    longVaule = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longVaule = defaultValue;
                }
            }

        }
        return longVaule;
    }

    /**
     * 转为int 型
     *
     * @param object
     * @return
     */
    public static int castInt(Object object) {
        return CastUtil.castInt(object, 0);
    }

    /**
     * 转为int 型
     *
     * @param object
     * @param defaultValue
     * @return
     */
    public static int castInt(Object object, int defaultValue) {
        int intValue = defaultValue;
        if (object != null) {
            String strVal = castString(object);
            if (StringUtil.isNotEmpty(strVal)) {
                try {
                    intValue = Integer.parseInt(strVal);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }

            }

        }
        return intValue;
    }

    /**
     * 转为 boolean 型
     *
     * @param object
     * @return
     */
    public static boolean castBoolean(Object object) {
        return CastUtil.castBoolean(object, false);
    }

    /**
     * 转为 boolean 型（提供默认值）
     *
     * @param object
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object object, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (object != null) {
            booleanValue = Boolean.parseBoolean(castString(object));
        }
        return booleanValue;
    }


}
