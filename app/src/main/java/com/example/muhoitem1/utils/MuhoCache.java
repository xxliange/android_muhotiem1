package com.example.muhoitem1.utils;

import android.content.Context;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

/**
 * Created by ricardo on 2017/12/6.
 */

public class MuhoCache {
    private static MuhoCache instance = new MuhoCache();
    private DB mDB;

    public static MuhoCache getInstance() {
        return instance;
    }

    public void init(Context context) {
        try {
            mDB = DBFactory.open(context);
        } catch (SnappydbException e) {
            e.printStackTrace();
            mDB = null;
        }
    }

    public void put(String key, Object obj) {
        try {
            mDB.put(key, obj instanceof String ? obj.toString()
                    : JsonUtils.toJson(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> T get(String key, Class<T> clazz) {
        try {
            return JsonUtils.fromJson(mDB.get(key), clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String get(String key) {
        try {
            return mDB.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
