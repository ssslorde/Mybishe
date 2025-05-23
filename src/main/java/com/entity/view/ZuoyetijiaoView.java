package com.entity.view;

import com.entity.ZuoyetijiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 作业提交
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-11 19:34:15
 */
@TableName("zuoyetijiao")
public class ZuoyetijiaoView  extends ZuoyetijiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuoyetijiaoView(){
	}
 
 	public ZuoyetijiaoView(ZuoyetijiaoEntity zuoyetijiaoEntity){
 	try {
			BeanUtils.copyProperties(this, zuoyetijiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
