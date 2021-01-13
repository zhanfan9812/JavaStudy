package com.zhanfan.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.zhanfan.common.valid.AddGroup;
import com.zhanfan.common.valid.ListValue;
import com.zhanfan.common.valid.UpdateGroup;
import com.zhanfan.common.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 *
 * @author zhanfan
 * @email 869791827@qq.com
 * @date 2020-12-30 16:38:28
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @NotNull(message = "修改必须指定品牌ID", groups = {UpdateGroup.class})
    @Null(message = "新增不能指定品牌ID", groups = {AddGroup.class})
    @TableId
    private Long brandId;

    /**
     * 品牌名
     */
    @NotBlank(message = "品牌名不能为空", groups = {AddGroup.class, UpdateGroup.class})//至少包含一个非空白字符
    private String name;

    /**
     * 品牌logo地址
     */
    @NotEmpty(groups = {AddGroup.class})
    @URL(message = "logo必须是一个合法的url地址", groups = {AddGroup.class, UpdateGroup.class})
    private String logo;

    /**
     * 介绍
     */
    private String descript;

    /**
     * 显示状态[0-不显示；1-显示]
     */
    //自定义校验注解
    @NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
    @ListValue(vals = {0, 1}, groups = {AddGroup.class, UpdateGroup.class, UpdateStatusGroup.class})
    private Integer showStatus;

    /**
     * 检索首字母
     */
    //正则表达式，匹配一个英文字母
    @Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个英文字母", groups = {AddGroup.class, UpdateGroup.class})
    @NotEmpty(groups = {AddGroup.class})
    private String firstLetter;

    /**
     * 排序
     */
    @NotNull(groups = {AddGroup.class})
    @Min(value = 0, message = "该字段必须大于等于0", groups = {AddGroup.class, UpdateGroup.class})
    private Integer sort;

}
