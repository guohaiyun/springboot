package cn.wmyskz.springboot.validate.vo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2018年12月29日 10:01
 */
@Data
public class ValidatorDemo2 {
    @Valid //验证集合的对象
    @NotEmpty //判断集合是否为空,和集合的长度
    private List<Demo> demos;
    private String tes;
}
