package com.sterlite.demo.spring.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;

import com.sterlite.demo.spring.views.PdfView;
import com.sterlite.demo.spring.views.XlsView;
/**
 * @author Dharmaraj Pawale
 * @copyright Sterlite Technologies Ltd.
 * @version 1.0
 * @creationdate 25-JUN-2020
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
				.defaultContentType(MediaType.TEXT_HTML)
				.mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML);
				//.ignoreAcceptHeader(true);
	}
	
	 @Override
	 public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/", ".jsp").viewClass(JstlView.class);
		registry.enableContentNegotiation(new PdfView(),new XlsView());
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts");
		registry.addResourceHandler("/styles/**").addResourceLocations("/styles");
	}
}
