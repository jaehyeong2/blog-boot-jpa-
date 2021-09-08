package com.jaeh.blog.api;

import com.jaeh.blog.dto.ResponseDto;
import com.jaeh.blog.model.RoleType;
import com.jaeh.blog.model.User;
import com.jaeh.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
//    @PostMapping("/api/user/login")
//    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
//        System.out.println("Userapi컨트롤러 호출됨");
//        User principal = userService.login(user);
//
//        if( principal!=null ){
//            session.setAttribute("principal",principal);
//        }
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }
}
