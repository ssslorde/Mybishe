package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XuekeEntity;
import com.entity.view.XuekeView;

import com.service.XuekeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 学科
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-11 19:34:15
 */
@RestController
@RequestMapping("/xueke")
public class XuekeController {
    @Autowired
    private XuekeService xuekeService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuekeEntity xueke,
		HttpServletRequest request){
        EntityWrapper<XuekeEntity> ew = new EntityWrapper<XuekeEntity>();



		PageUtils page = xuekeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueke), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuekeEntity xueke, 
		HttpServletRequest request){
        EntityWrapper<XuekeEntity> ew = new EntityWrapper<XuekeEntity>();

		PageUtils page = xuekeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueke), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuekeEntity xueke){
       	EntityWrapper<XuekeEntity> ew = new EntityWrapper<XuekeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueke, "xueke")); 
        return R.ok().put("data", xuekeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuekeEntity xueke){
        EntityWrapper< XuekeEntity> ew = new EntityWrapper< XuekeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueke, "xueke")); 
		XuekeView xuekeView =  xuekeService.selectView(ew);
		return R.ok("查询学科成功").put("data", xuekeView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuekeEntity xueke = xuekeService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xueke,deSens);
        return R.ok().put("data", xueke);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuekeEntity xueke = xuekeService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xueke,deSens);
        return R.ok().put("data", xueke);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuekeEntity xueke, HttpServletRequest request){
        if(xuekeService.selectCount(new EntityWrapper<XuekeEntity>().eq("xueke", xueke.getXueke()))>0) {
            return R.error("学科已存在");
        }
    	//ValidatorUtils.validateEntity(xueke);
        xuekeService.insert(xueke);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuekeEntity xueke, HttpServletRequest request){
        if(xuekeService.selectCount(new EntityWrapper<XuekeEntity>().eq("xueke", xueke.getXueke()))>0) {
            return R.error("学科已存在");
        }
    	//ValidatorUtils.validateEntity(xueke);
        xuekeService.insert(xueke);
        return R.ok().put("data",xueke.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XuekeEntity xueke, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueke);
        if(xuekeService.selectCount(new EntityWrapper<XuekeEntity>().ne("id", xueke.getId()).eq("xueke", xueke.getXueke()))>0) {
            return R.error("学科已存在");
        }
        //全部更新
        xuekeService.updateById(xueke);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuekeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
