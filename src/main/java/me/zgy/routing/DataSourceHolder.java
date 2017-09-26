package me.zgy.routing;

import org.springframework.stereotype.Service;

/**
 * Created by Rayee on 2017/9/22.
 */
@Service
public class DataSourceHolder {

    private static final ThreadLocal<String> routingKey = new ThreadLocal<>();

    public static void put(String dataSource) {
        routingKey.set(dataSource);
    }

    public static Object get() {
        return routingKey.get();
    }

    public static void clear() {
        routingKey.remove();
    }

}
