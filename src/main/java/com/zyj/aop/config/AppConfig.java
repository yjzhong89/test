package com.zyj.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.zyj.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}
