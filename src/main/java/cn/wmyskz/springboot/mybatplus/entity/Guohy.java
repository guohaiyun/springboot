package cn.wmyskz.springboot.mybatplus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2018-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Guohy implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private String name;


}
