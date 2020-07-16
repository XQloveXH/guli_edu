package com.zxq.eduservice.controller;

import com.zxq.commonutils.R;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @Author zxq
 * @Date 2020/6/15 20:50
 * @Version 1.0
 */
@RestController
@RequestMapping("eduservice/user")
@CrossOrigin
public class EduLoginController {

    @PostMapping("login")
    public R login(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("token","admin");
        return R.ok(map);
    }

    @GetMapping("info")
    public R info(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","小强");
        map.put("avatar","https://tse4-mm.cn.bing.net/th/id/OIP.Z8cO0OriANaUVakbQ6n0BwAAAA?w=151&h=165&c=7&o=5&dpr=1.25&pid=1.7");
        return R.ok(map);
    }
    @GetMapping("test")
    public R test(){
        return R.ok("");
    }

}
