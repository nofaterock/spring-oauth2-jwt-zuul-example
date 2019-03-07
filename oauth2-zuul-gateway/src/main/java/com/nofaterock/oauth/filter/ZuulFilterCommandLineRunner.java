package com.nofaterock.oauth.filter;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author nofaterock
 * @since 2019-02-26
 */
@Slf4j
@Component
public class ZuulFilterCommandLineRunner implements CommandLineRunner {

	@Value("${gateway.zuul.filters.base-path}")
	private String filterBasePath;

	@Override
	public void run(String... args) {
		FilterLoader.getInstance().setCompiler(new GroovyCompiler());
		try {
			log.info("load filter in : {}", filterBasePath);

			FilterFileManager.setFilenameFilter(new GroovyFileFilter());
			FilterFileManager.init(1,
				this.filterBasePath + "pre",
				this.filterBasePath + "route",
				this.filterBasePath + "post");
		} catch (Exception e) {
			log.error("load filter failure : " + filterBasePath, e);
			throw new RuntimeException(e);
		}
	}
}
