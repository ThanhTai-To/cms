package com.thanhtai.cms.config;

import com.thanhtai.cms.fiter.NewFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<NewFilter> registrationBean() {
        FilterRegistrationBean<NewFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new NewFilter());
        registrationBean.addUrlPatterns("/customers/*");

        return registrationBean;
    }
}
