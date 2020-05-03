package com.lsy.demo.cache;

import com.lsy.demo.commons.config.Constants;
import com.lsy.demo.commons.exception.StudyBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 * @author lsy
 * @date 2020/4/30
 */
@Slf4j
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplateProxy;

    private static RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void init() {
        this.redisTemplate = this.redisTemplateProxy;
    }

    /**
     * 普通缓存存储
     * @param key  键
     * @param obj  值
     */
    public static void set(String key, Object obj) {
        try {
            redisTemplate.opsForValue().set(key, obj);
        } catch (Exception e) {
            log.info("键为：" + key + "的缓存，存放错误！");
            throw new StudyBaseException(Constants.StatusType.REDIS_ERROR.getMsg(), Constants.StatusType.REDIS_ERROR.getCode());
        }
    }

    /**
     * 普通缓存放入并设置过期时间
     * @param key
     * @param obj
     * @param expiredTime
     */
    public static void set(String key, Object obj, Long expiredTime) {
        try {
            redisTemplate.opsForValue().set(key, obj, expiredTime, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info("键为：" + key + "的缓存，存放错误！");
            throw new StudyBaseException(Constants.StatusType.REDIS_ERROR.getMsg(), Constants.StatusType.REDIS_ERROR.getCode());
        }
    }

    /**
     * Map缓存放入
     * @param key      key
     * @param mapKey   map的key
     * @param obj      map的值
     */
    public static void setMap(String key, String mapKey, Object obj) {
        try {
            redisTemplate.opsForHash().put(key, mapKey, obj);
        } catch (Exception e) {
            log.info("键为：" + key + "的缓存，存放错误！");
            throw new StudyBaseException(Constants.StatusType.REDIS_ERROR.getMsg(), Constants.StatusType.REDIS_ERROR.getCode());
        }
    }

    /**
     * Map缓存放入
     * @param key      key
     * @param map      Map集合
     */
    public static void setMap(String key, Map map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
        } catch (Exception e) {
            log.info("键为：" + key + "的缓存，存放错误！");
            throw new StudyBaseException(Constants.StatusType.REDIS_ERROR.getMsg(), Constants.StatusType.REDIS_ERROR.getCode());
        }
    }

    /**
     * 根据key获取值
     * @param key   键
     * @return      Object
     */
    public static Object getVal(String key) {
        try {
            Object obj = redisTemplate.opsForValue().get(key);
            return obj;
        } catch (Exception e) {
            log.info("键为：" + key + "的缓存，获取错误！");
            throw new StudyBaseException(Constants.StatusType.REDIS_ERROR.getMsg(), Constants.StatusType.REDIS_ERROR.getCode());
        }
    }

    /**
     * 根据key获取Map
     * @param key    键
     * @return       Map
     */
    public static Map getMap(String key) {
        try {
            Map map = redisTemplate.opsForHash().entries(key);
            return map;
        } catch (Exception e) {
            log.info("键为：" + key + "的缓存，获取错误！");
            throw new StudyBaseException(Constants.StatusType.REDIS_ERROR.getMsg(), Constants.StatusType.REDIS_ERROR.getCode());
        }
    }

    /**
     * 批量删除普通缓存
     * @param key    键
     */
    public static void del(String...key) {
        try {
            if (null != key && key.length > 0) {
                if (key.length == 1) {
                    redisTemplate.delete(key[0]);
                }else {
                    redisTemplate.delete(CollectionUtils.arrayToList(key));
                }
            }
        } catch (Exception e) {
            log.info("键为：" + key.toString() + "的缓存，删除错误！");
            throw new StudyBaseException(Constants.StatusType.REDIS_ERROR.getMsg(), Constants.StatusType.REDIS_ERROR.getCode());
        }
    }

    /**
     * 根据key和mapKey删除Map
     * @param key         键
     * @param mapKey      map的键
     */
    public static void del(String key, String...mapKey) {
        try {
            redisTemplate.opsForHash().delete(key, mapKey);
        } catch (Exception e) {
            log.info("键为：" + key.toString() + "的缓存，删除错误！");
            throw new StudyBaseException(Constants.StatusType.REDIS_ERROR.getMsg(), Constants.StatusType.REDIS_ERROR.getCode());
        }
    }
}
