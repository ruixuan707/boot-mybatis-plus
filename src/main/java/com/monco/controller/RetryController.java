package com.monco.controller;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author : monco
 * @date : 2019/10/11 1:46
 * className: RetryController
 * description: 使用guava-retry进行接口异常重复调用
 */
public class RetryController {

    private static Retryer<Boolean> retryer;

    static {
        retryer = RetryerBuilder.<Boolean>newBuilder()
                // 抛出异常会进行重试
                .retryIfException()
                // 如果接口返回的结果不符合预期,也需要重试
                .retryIfResult(Predicates.equalTo(false))
                // 重试策略, 此处设置的是重试间隔时间
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))
                // 重试次数
                .withStopStrategy(StopStrategies.stopAfterAttempt(5))
                .build();
    }

    public boolean uploadFile(String fileName) {
        try {
            return retryer.call(new Callable<Boolean>() {
                int count = 0;

                @Override
                public Boolean call() throws Exception {
                    return new RetryController().uploadPicture(fileName, count++);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean uploadPicture(String fileName, int count) {
        System.out.println("开始上传文件:" + fileName);
        // 模拟在第3次重试成功
        if (count == 3) {
            System.out.println("文件上传成功, 重试次数:" + count);
            return true;
        }
        // 模拟因网络等原因导致的图片上传服务超时
        return false;
    }

    public static void main(String[] args) {
        new RetryController().uploadFile("testFile");
    }
}
