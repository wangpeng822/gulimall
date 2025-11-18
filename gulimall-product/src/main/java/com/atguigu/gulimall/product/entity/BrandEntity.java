package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

/**
 * 品牌
 * 
 * @author zhouxingxing
 * @email zhouxingxing822@gmail.com
 * @date 2025-11-15 23:09:18
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
    @NotBlank
	private String name;
	/**
	 * 品牌logo地址
	 */
    @URL(message="logo必须是一个合法url地址")
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	private Integer showStatus;
	/**
	 * 检索首字母
     * @Pattern()自定义规则注解 regexp=正则表达式
	 */
    @Pattern(regexp="/^[a-zA-Z]$/",message = "检索首字母必须是一个字母")
	private String firstLetter;
	/**
	 * 排序
	 */
    @Min(value = 0,message = "排序必须大于等于0")
	private Integer sort;

}
