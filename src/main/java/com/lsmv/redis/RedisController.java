package com.lsmv.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    CacheManager cacheManager;

    @GetMapping("/displayCache")
    public void displayCache() {
        CacheManager cacheManagerApp = (CacheManager) applicationContext.getBean("cacheManager");
        iterateCache(cacheManagerApp);
        iterateCache(cacheManager);
    }


    public void iterateCache(CacheManager cacheManager) {
        SimpleValueWrapper simpleValueWrapper  = (SimpleValueWrapper) cacheManager.getCache("DEV2022.2.0_distributionCache").get("AG_AGX_MAIN_DS_distribution-rules-ref-date");
        if (null != simpleValueWrapper) {
            System.out.println(simpleValueWrapper.get());
        }else{
            System.out.println("NAD");
        }
    }
}
