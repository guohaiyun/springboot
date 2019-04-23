package cn.wmyskz.springboot.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2018年12月26日 10:19
 */
@TableName("Course")
public class User {

//    @TableField(exist=false)
    @TableId
    @NotBlank
    private String cno;
//    @NotBlank
    @Range(min = 0,max = 100,message = "年龄必须在[0,100]")
    private Integer cname;
    private String tno;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Integer getCname() {
        return cname;
    }

    public void setCname(Integer cname) {
        this.cname = cname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }
}
