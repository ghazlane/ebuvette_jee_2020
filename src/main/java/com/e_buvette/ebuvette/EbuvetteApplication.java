package com.e_buvette.ebuvette;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan({ "com.e_buvette.ebuvette" })
public class EbuvetteApplication {
	static Logger logger = LoggerFactory.getLogger(EbuvetteApplication.class);

	public static void main(String[] args) {
//		SpringApplication application = new SpringApplication(SpringBootWriteConsoleLogApplication.class);
//		Properties properties = new Properties();
//		properties.setProperty("spring.main.banner-mode", "log");
//		properties.setProperty("logging.file", "logs/test.log");
//		properties.setProperty("logging.pattern.console", "");
//		application.setDefaultProperties(properties);

		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");

		SpringApplication.run(EbuvetteApplication.class, args);

	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.jsf");
	}

	@Bean
	public FilterRegistrationBean rewriteFilter() {
		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
		rwFilter.setDispatcherTypes(
				EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR));
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}

//	@Bean
//	public ServletContextInitializer initializer() {
//		return new ServletContextInitializer() {
//			@Override
//			public void onStartup(ServletContext servletContext) throws ServletException {
//				servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
//				servletContext.setInitParameter("com.sun.faces.expressionFactory", "com.sun.el.ExpressionFactoryImpl");
//				servletContext.setInitParameter("primefaces.UPLOADER", "auto");
//			}
//		};
//	}

}
