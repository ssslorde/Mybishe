package com.entity.vo;

import com.entity.ZuoyetijiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 作业提交
 * @author 
 * @email 
 * @date 2025-01-11 19:34:15
 */
public class ZuoyetijiaoVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 课程名称
	 */
	
	private String kechengmingcheng;
		
	/**
	 * 学科
	 */
	
	private String xueke;
		
	/**
	 * 课程封面
	 */
	
	private String kechengfengmian;
		
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tijiaoshijian;
		
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
	 * 批改状态
	 */
	
	private String pigaizhuangtai;
				
	
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
	 
	public void setTijiaoshijian(Date tijiaoshijian) {
		this.tijiaoshijian = tijiaoshijian;
	}
	
	/**
	 * 获取：提交时间
	 */
	public Date getTijiaoshijian() {
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
	 * 设置：批改状态
	 */
	 
	public void setPigaizhuangtai(String pigaizhuangtai) {
		this.pigaizhuangtai = pigaizhuangtai;
	}
	
	/**
	 * 获取：批改状态
	 */
	public String getPigaizhuangtai() {
		return pigaizhuangtai;
	}
			
}
