package cn.wmyskz.springboot.ueditor.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Ueditor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String path;

    private String name;


}
