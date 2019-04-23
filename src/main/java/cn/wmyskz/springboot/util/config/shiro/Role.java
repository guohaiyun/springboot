package cn.wmyskz.springboot.util.config.shiro;

//import cn.wmyskz.springboot.shiro.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月22日 15:37
 */
@Data
public class Role {

    private int id;
    private String roleName;

//    private User user;

    private List<Permission> permissions;


}
