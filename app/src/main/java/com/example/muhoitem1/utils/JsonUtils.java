package com.example.muhoitem1.utils;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public final class JsonUtils {

    private static Gson gson;

    static {
        gson = new Gson();

    }

    /**
     * @param json 数据
     * @param cls  类型
     * @return 单个Object
     */
    public static <T> T getObject(String json, Class<T> cls) {
        T t = null;
        if (!TextUtils.isEmpty(json)) {
            try {
                t = gson.fromJson(json, cls);
            }catch (Exception e){
                Log.d("====","r  "+e.getMessage());
                return t;
            }
        }
        return t;
    }

    /**
     * @param json
     * @param cls
     * @return List<Object>类型
     */
    public static <T> List<T> getListObject(String json, Class<T> cls) {
        List<T> list = null;
        if (!TextUtils.isEmpty(json)) {
            list = JSON.parseArray(json, cls);
//            Type listType = new TypeToken<List<T>>() {}.getType();
//            list = gson.fromJson(json, listType);
        }
        return list;
    }

    public static <T> T getObjectBody(String data, Class<T> clazz) {
        if (TextUtils.isEmpty(data)) {
            return null;
        }
        return gson.fromJson(data, clazz);
    }


    private static final String TAG = JsonUtils.class.getName();

    public static final String EMPTY_JSON = "{}"; 		// 空的JSON数据
    public static final String EMPTY_JSON_ARRAY = "[]"; // 空的数组(集合)数据
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss SSS"; // 默认的日期，时间字段的格式化模式
    public static final boolean DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE = false; //是否排除未标记字段(默认值)

    public static final double SINCE_VERSION_10 = 1.0d;
    public static final double SINCE_VERSION_11 = 1.1d;
    public static final double SINCE_VERSION_12 = 1.2d;

    /*--------------------------------------------------------------------------
    | 将给定的目标对象根据所指定的条件参数转换成JSON格式的字符串
    --------------------------------------------------------------------------*/
    public static String toJson(Object target) {
        return toJson(target, null, false, null, null, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE);
    }

    public static String toJson(Object target, Type targetType) {
        return toJson(target, targetType, false, null, null, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE);
    }

    public static String toJson(Object target, Type targetType, Double version) {
        return toJson(target, targetType, false, version, null, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE);
    }

    public static String toJson(Object target, Type targetType, boolean excludesFieldsWithoutExpose) {
        return toJson(target, targetType, false, null, null, excludesFieldsWithoutExpose);
    }

    public static String toJson(Object target, Type targetType, Double version, boolean excludesFieldsWithoutExpose) {
        return toJson(target, targetType, false, version, null, excludesFieldsWithoutExpose);
    }

    public static String toJson(Object target, boolean excludesFieldsWithoutExpose) {
        return toJson(target, null, false, null, null, excludesFieldsWithoutExpose);
    }

    /**
     * 将给定的目标对象根据所指定的条件参数转换成JSON格式的字符串
     * @param target 目标对象
     * @param targetType 目标对象的类型
     * @param isSerializeNulls 是否序列化Null值字段
     * @param version 字段的版本号注解
     * @param datePattern 日期字段的格式化模式
     * @param excludesFieldsWithoutExpose 是否排除未标注@Expose注解的字段
     * @return 目标对象的JSON格式的字符串
     *
     */
    public static String toJson(Object target, Type targetType, boolean isSerializeNulls, Double version, String datePattern, boolean excludesFieldsWithoutExpose) {
        if (target == null) {
            return EMPTY_JSON;
        }
        GsonBuilder builder = new GsonBuilder();
        if (isSerializeNulls) {
            builder.serializeNulls();
        }
        if (version != null) {
            builder.setVersion(version.doubleValue());
        }
        if (TextUtils.isEmpty(datePattern)) {
            datePattern = DEFAULT_DATE_PATTERN;
        }
        builder.setDateFormat(datePattern);
        if (excludesFieldsWithoutExpose) {
            builder.excludeFieldsWithoutExposeAnnotation();
        }
        return toJson(target, targetType, builder);
    }

    /**
     * 将给定的目标对象根据所指定的条件参数转换成JSON格式的字符串。
     * 该方法转换发生错误时，不会抛出任何异常。若发生错误时，对象返回"{}"，集合或数组对象返回 "[]"， 其本基本类型，返回相应的基本值
     * @param target 目标对象。
     * @param targetType 目标对象的类型
     * @param builder 可定制的Gson构建器
     * @return 目标对象的JSON格式的字符串
     *
     */
    public static String toJson(Object target, Type targetType, GsonBuilder builder) {
        if (target == null) {
            return EMPTY_JSON;
        }
        Gson gson = null;
        if (builder == null) {
            gson = new Gson();
        } else {
            gson = builder.create();
        }
        String result = EMPTY_JSON;
        try {
            if (targetType == null) {
                result = gson.toJson(target);
            } else {
                result = gson.toJson(target, targetType);
            }
        } catch (Exception e) {
            if (target instanceof Collection<?> || target instanceof Iterator<?> || target instanceof Enumeration<?> || target.getClass().isArray()) {
                result = EMPTY_JSON_ARRAY;
            }
        }
        return result;
    }


    /*--------------------------------------------------------------------------
    | 将给定的目标对象根据所指定的条件参数转换成JSON格式的字符串
    --------------------------------------------------------------------------*/
    public static <T> T fromJson(String json, Class<T> cls) {
        return fromJson(json, cls, null);
    }

    public static <T> T fromJson(String json, TypeToken<T> token) {
        return fromJson(json, token, null);
    }

    /**
     * 将给定的JSON字符串转换成指定的类型对象
     *
     * @param json 给定的JSON字符串
     * @param cls 要转换的目标类
     * @param datePattern 日期格式
     * @return 给定的JSON字符串表示的指定的类型对象
     */
    public static <T> T fromJson(String json, Class<T> cls, String datePattern) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        GsonBuilder builder = new GsonBuilder();
        if (TextUtils.isEmpty(datePattern)) {
            datePattern = DEFAULT_DATE_PATTERN;
        }
        Gson gson = builder.create();
        try {
            return gson.fromJson(json, cls);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    /**
     * 将给定的JSON字符串转换成指定的类型对象
     *
     * @param json 给定的JSON字符串
     * @param token 类型
     * @param datePattern 日期格式
     * @return 给定的JSON字符串表示的指定的类型对象
     */
    public static <T> T fromJson(String json, TypeToken<T> token, String datePattern) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        GsonBuilder builder = new GsonBuilder();
        if (TextUtils.isEmpty(datePattern)) {
            datePattern = DEFAULT_DATE_PATTERN;
        }
        Gson gson = builder.create();
        try {
            return gson.fromJson(json, token.getType());
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }
}
