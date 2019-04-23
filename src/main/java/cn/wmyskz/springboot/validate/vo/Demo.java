package cn.wmyskz.springboot.validate.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2018年12月29日 11:32
 */
@Data
public class Demo {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
}
