package cn.tll.config;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author tll
 * @create 2020/7/12 16:39
 */
public class MyLocaleResolver implements LocaleResolver {
    /**
     * 解析请求
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("l");
        //如果没有 就使用默认的
        Locale locale = Locale.getDefault();
        //判断language是否为空
        if (!language.isEmpty()){
            //切割字符串
            String[] split = language.split("_");
            //国家  地区
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
