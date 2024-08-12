package cyou.devify.blog.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cyou.devify.blog.interceptors.StackInterceptor;

@Configuration
public class WebMvcDefaultConfigurer implements WebMvcConfigurer {
    @Autowired
    StackInterceptor stackInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stackInterceptor);
    }
}
