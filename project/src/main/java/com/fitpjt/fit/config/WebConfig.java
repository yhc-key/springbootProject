package com.fitpjt.fit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
		
		//templates에서 html 파일 읽을 수 있도록 위치 추가해준다
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/resources/templates/");
	}
	
	//등록할 인터셉터가 있다면
	//필드를 통해 의존성을 주입 받고 여기에 등록하면된다.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	}
	
	//CORS에러를 해결하기 위해서 컨트롤러에 각각 작성을 할수도 있지만 공통처리(전역처리)라면 여기에 한번에 할 수 있다.
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
//		registry.addMapping("/**").allowedMethods("GET", "POST"); //이런 식으로 특정 메서드만 허용할수도 있다.
	}
	
}
