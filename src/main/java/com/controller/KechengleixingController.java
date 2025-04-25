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

import com.entity.KechengleixingEntity;
import com.entity.view.KechengleixingView;

import com.service.KechengleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-11 19:34:15
 */
@RestController
@RequestMapping("/kechengleixing")
public class KechengleixingController {
    @Autowired
    private KechengleixingService kechengleixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengleixingEntity kechengleixing,
		HttpServletRequest request){
        EntityWrapper<KechengleixingEntity> ew = new EntityWrapper<KechengleixingEntity>();



		PageUtils page = kechengleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengleixing), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengleixingEntity kechengleixing, 
		HttpServletRequest request){
        EntityWrapper<KechengleixingEntity> ew = new EntityWrapper<KechengleixingEntity>();

		PageUtils page = kechengleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengleixing), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengleixingEntity kechengleixing){
       	EntityWrapper<KechengleixingEntity> ew = new EntityWrapper<KechengleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengleixing, "kechengleixing")); 
        return R.ok().put("data", kechengleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengleixingEntity kechengleixing){
        EntityWrapper< KechengleixingEntity> ew = new EntityWrapper< KechengleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengleixing, "kechengleixing")); 
		KechengleixingView kechengleixingView =  kechengleixingService.selectView(ew);
		return R.ok("查询课程类型成功").put("data", kechengleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengleixingEntity kechengleixing = kechengleixingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(kechengleixing,deSens);
        return R.ok().put("data", kechengleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengleixingEntity kechengleixing = kechengleixingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(kechengleixing,deSens);
        return R.ok().put("data", kechengleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengleixingEntity kechengleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kechengleixing);
        kechengleixingService.insert(kechengleixing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengleixingEntity kechengleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kechengleixing);
        kechengleixingService.insert(kechengleixing);
        return R.ok().put("data",kechengleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengleixingEntity kechengleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengleixing);
        //全部更新
        kechengleixingService.updateById(kechengleixing);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
