package com.grange.board.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.grange.board.core.interceptor.AuthInterceptor;

@Configuration
public class ContextConfig implements WebMvcConfigurer {
	
	@Autowired
	private AuthInterceptor authInterceptor;
	
	@Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        return templateEngine;
    }

   @Bean
    public ClassLoaderTemplateResolver thymeleafTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/"); // 모든 뷰 페이지는 /resources/templates/ 내부에서 검색한다.
        templateResolver.setSuffix(".html"); // 모든 뷰 페이지는 .html 이다.
        templateResolver.setTemplateMode("HTML"); // HTML 형식으로 읽는다.
        templateResolver.setCacheable(false); // 캐싱하지 않는다.
        return templateResolver;
    }
   
   @Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)	// 우리가 만든 interceptor 적용
			.addPathPatterns("/board/**");	// 경로 추가. 주어진 모든 경로에서 공통 기능(어느 창에서 들어가도 로그인 정보가 없으면 로그인 창으로 들어가지게) 추가
	}
   
}
