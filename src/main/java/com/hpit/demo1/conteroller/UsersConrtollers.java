package com.hpit.demo1.conteroller;

import com.hpit.demo1.entity.Users;
import com.hpit.demo1.service.UsersService;
import com.hpit.demo1.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/jj/")
public class UsersConrtollers {
    @Autowired
    private UsersService usersService;
@RequestMapping("query")
@ResponseBody
 public String getUsers(String name){
    int users = usersService.getUsers(name);
    return "{\"result\":"+users+"}";
}
    @RequestMapping("addUesr")
    public String addUesrs(com.hpit.demo1.entity.Users users){
        int i = usersService.addUesrs(users);
        if (i>0){
            return "login";
        }
        return  "error";
    }

    @RequestMapping("deng")
    public String deng(String username, String password, Model model,HttpSession session){
        System.out.println("username = " + username+"="+password);
        Users usersname = usersService.deng(username, password);

        if (usersname==null){
            model.addAttribute("lock","用户和密码错误");
            return "login";
        }else
            session.setAttribute("usersname",usersname);
            session.setMaxInactiveInterval(600000);
        return  "guanli";
    }

}
