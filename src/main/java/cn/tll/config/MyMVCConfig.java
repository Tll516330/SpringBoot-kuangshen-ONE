package cn.tll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author tll
 * @create 2020/7/12 15:26
 */
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {

    /**
     *添加视图控制
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    /**
     * 放入SpringBean中
     * 自定义的国际化组件
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截请求,及拦截那些请求,不拦截那些请求
        //过滤静态资源文件
        registry.addInterceptor(new MyHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/login","/css/**","/js/**","/img/**");
    }
}
