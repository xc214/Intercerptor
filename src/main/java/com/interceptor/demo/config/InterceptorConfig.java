package com.interceptor.demo.config;

import com.interceptor.demo.interceptor.TestInterceptor;
import com.interceptor.demo.interceptor.TestInterceptor1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Xiao Cong  xiaoc@corp.21cn.com
 * @Date: 2020/1/6
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

  @Autowired
  private TestInterceptor testInterceptor;
  @Autowired
  private TestInterceptor1 testInterceptor1;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(testInterceptor)
        .addPathPatterns("/test/**")
        .excludePathPatterns("/error/**");

    registry.addInterceptor(testInterceptor1)
        .addPathPatterns("/testConfig/**")
        .excludePathPatterns("/error/**");
  }
}
