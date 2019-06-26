package com.bcu.judge.controller;

import com.bcu.judge.pojo.Exam;
import com.bcu.judge.pojo.ExamUser;
import com.bcu.judge.pojo.User;
import com.bcu.judge.service.ExamUserService;
import com.bcu.judge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ExamUserService examUserService;

    @RequestMapping(value = "/user/login",method = {RequestMethod.POST})
    @ResponseBody
    public HashMap dologin(String userId, String password,HttpServletRequest req)
    {
      HashMap rsMap=new HashMap();
      User u=userService.dologin(userId,password);
      if (u!=null)
      {
          rsMap.put("result",true);
          HttpSession session=req.getSession(true);
          session.setAttribute("user",u);
          List<Exam> examList=examUserService.getExamByUserId(userId);
          session.setAttribute("exam",examList);
          if (u.getUserType().equals("2"))
          {
              rsMap.put("type","2");
          }else {
              rsMap.put("type","1");
          }

      }else
      {
          rsMap.put("result",false);
      }
      return rsMap;
    }


    @RequestMapping(value = "/user/my",method = {RequestMethod.GET})
    public String toMe()
    {
        return "my";
    }

    @RequestMapping(value = "/user/admin",method = {RequestMethod.GET})
    public String toAdmin()
    {
        return "admin";
    }



}
