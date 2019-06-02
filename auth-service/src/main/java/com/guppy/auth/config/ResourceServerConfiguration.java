package com.guppy.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源服务配置
 *
 * @author Guppy
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        String matcher = "/current";
        http
                .requestMatchers()
                .antMatchers(matcher)
                .and()
                .authorizeRequests()
                .antMatchers(matcher)
                .access("#oauth2.hasScope('read')");

    }
}
