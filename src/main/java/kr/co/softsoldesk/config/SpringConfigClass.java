package kr.co.softsoldesk.config;

//import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Spring 환경설정 방법1
public class SpringConfigClass implements WebApplicationInitializer{
	                                            //web.xml
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Spring Framework 프로젝트 설정을 위한 클래스의 객체생성
		AnnotationConfigWebApplicationContext servletAppcontext = new AnnotationConfigWebApplicationContext();
		servletAppcontext.register(ServletAppContext.class);
		
		// 요청 발생 시 요청을 처리하는 서블릿을 DispatcherServlet으로 설정
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppcontext);
		// 매개변수로 선언된 servletAppContext객체를 이용하여 servlet 추가
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
		
		// 부가 설정 
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");	
		
		// ==========================================================================================================
		
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootAppContext.class);
		
		// listener 구현
		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		servletContext.addListener(listener);
		// filter 구현
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		// dispatcher에 의해서 편집한 경로 UTF-8로 세팅
		filter.addMappingForServletNames(null, false, "dispatcher");
		
	}

}
/*
// Spring 환경설정 방법2
public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer {
	   // DispatcherServlet에 매핑할 요청 주소를 셋팅한다.
	   @Override
	   protected String[] getServletMappings() {
	      // TODO Auto-generated method stub
	      return new String[] { "/" };
	   }

	   // Spring MVC 프로젝트 설정을 위한 클래스를 지정한다.
	   @Override
	   protected Class<?>[] getServletConfigClasses() {
	      // TODO Auto-generated method stub
	      return new Class[] { ServletAppContext.class };
	   }

	   // 프로젝트에서 사용할 Bean들을 정의하기 위한 클래스를 지정한다.
	   @Override
	   protected Class<?>[] getRootConfigClasses() {
	      // TODO Auto-generated method stub
	      return new Class[] { RootAppContext.class };
	   }

	   // 파라미터 인코딩 필터 설정
	   @Override
	   protected Filter[] getServletFilters() {
	      // TODO Auto-generated method stub
	      CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
	      encodingFilter.setEncoding("UTF-8");
	      return new Filter[] {encodingFilter};
	      
	 }
	   
}*/
