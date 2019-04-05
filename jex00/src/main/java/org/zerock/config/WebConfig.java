package org.zerock.config;

import org.springframework.web.servlet.support.
AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends
	AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// getRootConfig() 클래슨는 'root-context.xml'을 대신하는 클래스를 지정하는데
		// 예제는 RootConfig 클래스를 사용하므로 아래와 같이 메서드의 내용을 변경함.
		return new Class[] {RootConfig.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
	
	@Override
	protected String[] getServletMappings() {
		return null;
	}
}
