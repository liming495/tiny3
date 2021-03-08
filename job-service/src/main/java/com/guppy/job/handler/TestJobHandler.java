package com.guppy.job.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Description
 *
 * @author guppy
 * @since 2021/2/8 10:09
 */
@Component
@Slf4j
public class TestJobHandler {

    @XxlJob("demoJobHandler")
    public ReturnT<String> demoJobHandler(String param) throws Exception {
        try {
            String[] tableNameList = new String[]{"order_amazon","order_amazon_detail"};//要同步的表名

            CountDownLatch latch = new CountDownLatch(tableNameList.length);//设置与表相同的线程计数器，同时备份表
            for(String tableName : tableNameList){
                new Thread(() -> {
                    try {
                        XxlJobLogger.log(String.format("tableName: %s is back", tableName));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }).start();
            }
            latch.await();
            return ReturnT.SUCCESS;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return ReturnT.FAIL;
        }
    }
}
