package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 成绩信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-01-11 19:34:15
 */
@TableName("chengjixinxi")
public class ChengjixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChengjixinxiEntity() {
		
	}
	
	public ChengjixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 成绩编号
	 */
					
	private String chengjibianhao;
	
	/**
	 * 课程名称
	 */
					
	private String kechengmingcheng;
	
	/**
	 * 课程封面
	 */
					
	private String kechengfengmian;
	
	/**
	 * 学科
	 */
					
	private String xueke;
	
	/**
	 * 发布时间
	 */
					
	private String fabushijian;
	
	/**
	 * 作业要求
	 */
					
	private String zuoyeyaoqiu;
	
	/**
	 * 作业提交
	 */
					
	private String zuoyetijiao;
	
	/**
	 * 提交时间
	 */
					
	private String tijiaoshijian;
	
	/**
	 * 教师账号
	 */
					
	private String jiaoshizhanghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 作业成绩
	 */
					
	private Double zuoyechengji;
	
	/**
	 * 批语
	 */
					
	private String piyu;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：成绩编号
	 */
	public void setChengjibianhao(String chengjibianhao) {
		this.chengjibianhao = chengjibianhao;
	}
	/**
	 * 获取：成绩编号
	 */
	public String getChengjibianhao() {
		return chengjibianhao;
	}
	/**
	 * 设置：课程名称
	 */
	public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
	}
	/**
	 * 获取：课程名称
	 */
	public String getKechengmingcheng() {
		return kechengmingcheng;
	}
	/**
	 * 设置：课程封面
	 */
	public void setKechengfengmian(String kechengfengmian) {
		this.kechengfengmian = kechengfengmian;
	}
	/**
	 * 获取：课程封面
	 */
	public String getKechengfengmian() {
		return kechengfengmian;
	}
	/**
	 * 设置：学科
	 */
	public void setXueke(String xueke) {
		this.xueke = xueke;
	}
	/**
	 * 获取：学科
	 */
	public String getXueke() {
		return xueke;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(String fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public String getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：作业要求
	 */
	public void setZuoyeyaoqiu(String zuoyeyaoqiu) {
		this.zuoyeyaoqiu = zuoyeyaoqiu;
	}
	/**
	 * 获取：作业要求
	 */
	public String getZuoyeyaoqiu() {
		return zuoyeyaoqiu;
	}
	/**
	 * 设置：作业提交
	 */
	public void setZuoyetijiao(String zuoyetijiao) {
		this.zuoyetijiao = zuoyetijiao;
	}
	/**
	 * 获取：作业提交
	 */
	public String getZuoyetijiao() {
		return zuoyetijiao;
	}
	/**
	 * 设置：提交时间
	 */
	public void setTijiaoshijian(String tijiaoshijian) {
		this.tijiaoshijian = tijiaoshijian;
	}
	/**
	 * 获取：提交时间
	 */
	public String getTijiaoshijian() {
		return tijiaoshijian;
	}
	/**
	 * 设置：教师账号
	 */
	public void setJiaoshizhanghao(String jiaoshizhanghao) {
		this.jiaoshizhanghao = jiaoshizhanghao;
	}
	/**
	 * 获取：教师账号
	 */
	public String getJiaoshizhanghao() {
		return jiaoshizhanghao;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：作业成绩
	 */
	public void setZuoyechengji(Double zuoyechengji) {
		this.zuoyechengji = zuoyechengji;
	}
	/**
	 * 获取：作业成绩
	 */
	public Double getZuoyechengji() {
		return zuoyechengji;
	}
	/**
	 * 设置：批语
	 */
	public void setPiyu(String piyu) {
		this.piyu = piyu;
	}
	/**
	 * 获取：批语
	 */
	public String getPiyu() {
		return piyu;
	}

}
