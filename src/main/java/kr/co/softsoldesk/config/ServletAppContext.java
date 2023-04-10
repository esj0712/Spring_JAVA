package kr.co.softsoldesk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
						
@ComponentScan("kr.co.softsoldesk.controller") // 스캔할 패키지
@EnableWebMvc // Controller로 등록되어 있는 클래스 세팅 [컨트롤러를 읽어들임]
@Configuration // 일반 Bean
public class ServletAppContext implements WebMvcConfigurer{

	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 기본 view 경로와 확장자 설정  view결과값을 저장하는곳
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 이미지, 영상, 소리, 등 정적파일 경로 매핑
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	

}
