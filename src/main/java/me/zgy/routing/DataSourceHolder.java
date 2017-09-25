package me.zgy.routing;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Rayee on 2017/9/22.
 */
@Service
public class DataSourceHolder {

    private RoutingDataSource routingDataSource;

    public DataSourceHolder(RoutingDataSource routingDataSource) {
        this.routingDataSource = routingDataSource;
    }

    private static final ThreadLocal<String> routingKey = new ThreadLocal<>();

    private static Map<Object, Object> dataSourceMap = new ConcurrentHashMap<>();

    private static String defaultDataSource = "dataSource1";

    public static void put(String dataSource) {
        routingKey.set(dataSource);
    }

    public static Object get() {
        return routingKey.get();
    }

    public static void clear() {
        routingKey.remove();
    }

    public static Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

}
