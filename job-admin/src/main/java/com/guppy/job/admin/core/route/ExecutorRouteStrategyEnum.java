package com.guppy.job.admin.core.route;

import com.guppy.job.admin.core.route.strategy.ExecutorRouteBusyover;
import com.guppy.job.admin.core.route.strategy.ExecutorRouteFailover;
import com.guppy.job.admin.core.util.I18nUtil;

/**
 * Created by xuxueli on 17/3/10.
 */
public enum ExecutorRouteStrategyEnum {

    FIRST(I18nUtil.getString("jobconf_route_first"), new com.xxl.job.admin.core.route.strategy.ExecutorRouteFirst()),
    LAST(I18nUtil.getString("jobconf_route_last"), new com.xxl.job.admin.core.route.strategy.ExecutorRouteLast()),
    ROUND(I18nUtil.getString("jobconf_route_round"), new com.xxl.job.admin.core.route.strategy.ExecutorRouteRound()),
    RANDOM(I18nUtil.getString("jobconf_route_random"), new com.xxl.job.admin.core.route.strategy.ExecutorRouteRandom()),
    CONSISTENT_HASH(I18nUtil.getString("jobconf_route_consistenthash"), new com.xxl.job.admin.core.route.strategy.ExecutorRouteConsistentHash()),
    LEAST_FREQUENTLY_USED(I18nUtil.getString("jobconf_route_lfu"), new com.xxl.job.admin.core.route.strategy.ExecutorRouteLFU()),
    LEAST_RECENTLY_USED(I18nUtil.getString("jobconf_route_lru"), new com.xxl.job.admin.core.route.strategy.ExecutorRouteLRU()),
    FAILOVER(I18nUtil.getString("jobconf_route_failover"), new ExecutorRouteFailover()),
    BUSYOVER(I18nUtil.getString("jobconf_route_busyover"), new ExecutorRouteBusyover()),
    SHARDING_BROADCAST(I18nUtil.getString("jobconf_route_shard"), null);

    ExecutorRouteStrategyEnum(String title, com.xxl.job.admin.core.route.ExecutorRouter router) {
        this.title = title;
        this.router = router;
    }

    private String title;
    private com.xxl.job.admin.core.route.ExecutorRouter router;

    public String getTitle() {
        return title;
    }
    public com.xxl.job.admin.core.route.ExecutorRouter getRouter() {
        return router;
    }

    public static ExecutorRouteStrategyEnum match(String name, ExecutorRouteStrategyEnum defaultItem){
        if (name != null) {
            for (ExecutorRouteStrategyEnum item: ExecutorRouteStrategyEnum.values()) {
                if (item.name().equals(name)) {
                    return item;
                }
            }
        }
        return defaultItem;
    }

}
