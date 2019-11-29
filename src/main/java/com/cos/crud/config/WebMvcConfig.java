package com.cos.crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//세션체크, 권한체크, 로그 남기기(log4j)
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	//.addPathPatterns("/**");
	//.excludePathPatterns("/user/*")
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new SessionInterceptor())
				.addPathPatterns("/board/**")
				.excludePathPatterns("/board/list")
				.excludePathPatterns("/board/detail/**");
		registry.addInterceptor(new AdminInterceptor())
		.addPathPatterns("/admin/**");
	}
}