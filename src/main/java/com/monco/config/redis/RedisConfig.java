package com.monco.config.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * @Author: Ryan
 * @Date: 2019/3/18 14:24
 * @Version 1.0
 * @Description: redis 配置类
 */
@EnableCaching
@Configuration
public class RedisConfig {
    /**
     * redis 端口
     */
    @Value("${spring.redis.port}")
    private String port;
    /**
     * redis 主机
     */
    @Value("${spring.redis.host}")
    private String host;
    /**
     * 密码
     */
    @Value("${spring.redis.password}")
    private String password;

    /**
     * redis key生成策略
     * target: 类
     * method: 方法
     * params: 参数
     *
     * @return KeyGenerator
     * <p>
     * 注意: 该方法只是声明了key的生成策略,还未被使用,需在@Cacheable注解中指定keyGenerator
     * 如: @Cacheable(value = "key", keyGenerator = "cacheKeyGenerator")
     */
    @Bean
    public KeyGenerator cacheKeyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                // 由于参数可能不同, hashCode肯定不一样, 缓存的key也需要不一样
                sb.append(JSON.toJSONString(obj).hashCode());
            }
            return sb.toString();
        };
    }

    /**
     * 实例化 RedisTemplate
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initRedisTemple(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 设置数据存入 redis 的序列化方式，并开启事务
     *
     * @param redisTemplate
     * @param redisConnectionFactory
     */
    private void initRedisTemple(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory redisConnectionFactory) {
        // 如果不配置serializer,那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置 setValueSerializer 为 Kryo
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(redisConnectionFactory);

//        redisTemplate.afterPropertiesSet();
    }

    /**
     * 注入封装RedisTemplate
     *
     * @param redisTemplate
     * @return
     */
    @Bean(name = "redisService")
    public RedisService redisUtil(RedisTemplate<String, Object> redisTemplate) {
        RedisService redisService = new RedisService();
        redisService.setRedisTemplate(redisTemplate);
        return redisService;
    }
}