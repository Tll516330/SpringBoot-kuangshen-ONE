package cn.tll.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/7/12 23:56
 * 拦截器
 */
public class MyHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断session 如果有则放行,否则不放行
        Object username = request.getSession().getAttribute("username");
        if (username==null){
            request.setAttribute("msg","没有权限");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            //已经登录,放行
            return true;
        }

    }
}
