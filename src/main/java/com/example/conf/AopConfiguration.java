package com.example.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example.conf.aspect")
@EnableAspectJAutoProxy(exposeProxy = true)
public class AopConfiguration {

}
