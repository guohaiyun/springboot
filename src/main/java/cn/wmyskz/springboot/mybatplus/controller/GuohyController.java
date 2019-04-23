package cn.wmyskz.springboot.mybatplus.controller;
import cn.wmyskz.springboot.mybatplus.entity.Guohy;
import cn.wmyskz.springboot.mybatplus.service.IGuohyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2018-12-27
 */
///官方插件地址https://mp.baomidou.com/guide/mybatisx-idea-plugin.html#%E5%8A%9F%E8%83%BD

@RestController
@RequestMapping("/mybatplus/guohy")
@SessionScope
public class GuohyController {
    @Autowired
    private IGuohyService service;
    @RequestMapping("/getUser")
    public void hello(@RequestBody Guohy guohy) {
        service.save(guohy);
        System.out.println(guohy.getId());
    }

    @RequestMapping("/getUser2")
    public void hello2(@RequestBody List<Guohy> guohy, HttpServletRequest request) {
        request.getCookies();
        request.getSession();
        service.saveBatch(guohy,5);
    }
    @RequestMapping("/getUser3")
    public void hello3(@RequestBody Guohy guohy) {
        service.saveOrUpdate(guohy);
    }
    @RequestMapping("/getUser4")
    public void hello4(@RequestBody List<Guohy> guohy) {
        service.saveOrUpdateBatch(guohy);
    }
    @RequestMapping("/getUser5")
    public void hello5(String guohyId) {
        service.removeById(guohyId);
    }

    @RequestMapping("/getUser6")
    public void hello6() {
        QueryWrapper<Guohy> queryWrapper =
                new QueryWrapper<Guohy>()
                        .eq(false,"","");
        service.remove(queryWrapper);
        Map map=new HashMap();
        map.put("id","1");
        map.put("name","1");
        service.removeByMap(map);
    }
    @RequestMapping("/getUser7")
    public void hello(String name) {
        Guohy guohy=new Guohy();
        guohy.setName(name);
        service.save(guohy);
        //System.out.println(guohy.getId());
    }

    @RequestMapping("/getUser8")
    public void hello8(String name) {
        service.list();
//        Guohy guohy=new Guohy();
//        guohy.setName(name);
//        service.save(guohy);
        //System.out.println(guohy.getId());
    }
}
