package cn.wmyskz.springboot.util;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2018年12月29日 11:28
 */
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Created by beck on 2017/9/13.
 * for validate list param
 */
public class ListValidateWrapper<T> {
    @Valid
    @NotEmpty
    private List<T> list;

    @JsonCreator
    public ListValidateWrapper(List<T> list){
        this.list = list;
    }
    @JsonValue
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

