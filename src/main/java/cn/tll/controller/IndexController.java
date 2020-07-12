package cn.tll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author tll
 * @create 2020/7/12 10:38
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 用户登录
     * @return
     */
    @RequestMapping("/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session,
                        Model model){
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            //账号密码正确,可以进入主页面
            session.setAttribute("username",username);
            //登录成功,重定向防止表单重新提交
            return "redirect:/main.html";
        }

        //登录失败
        model.addAttribute("msg","账号或密码错误");
        return "redirect:/index.html";
    }

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
