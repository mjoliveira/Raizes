package com.thoughtworks.aceleradora.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        final VersionResourceResolver versionResolver = new VersionResourceResolver();
        versionResolver.addFixedVersionStrategy("test_version", "/**");

        VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
                .addVersionStrategy(new ContentVersionStrategy(),"/**");

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/assets/", "classpath:/static/")
                .setCachePeriod(60*60*24*365)
                .resourceChain(true)
                .addResolver(versionResourceResolver);
    }

}