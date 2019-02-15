package com.nine.cloud.nine.nacos.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NineNacosConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NineNacosConfigServerApplication.class, args);
    }


    @RestController
    @RequestMapping("/config")
    @RefreshScope
    public class ConfigController {

        @Value("${useLocalCache:false}")
        private boolean useLocalCache;

        @RequestMapping("/get")
        public boolean get() {
            return useLocalCache;
        }
    }
}

