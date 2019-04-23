package cn.wmyskz.springboot.util.config.shiro;
import lombok.Data;


/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月22日 15:44
 */
@Data

public class Permission {


    private int id;
    private String permission;

    private Role role;


}