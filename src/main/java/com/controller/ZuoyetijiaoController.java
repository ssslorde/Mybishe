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

import com.entity.ZuoyetijiaoEntity;
import com.entity.view.ZuoyetijiaoView;

import com.service.ZuoyetijiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 作业提交
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-11 19:34:15
 */
@RestController
@RequestMapping("/zuoyetijiao")
public class ZuoyetijiaoController {
    @Autowired
    private ZuoyetijiaoService zuoyetijiaoService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuoyetijiaoEntity zuoyetijiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			zuoyetijiao.setJiaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			zuoyetijiao.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuoyetijiaoEntity> ew = new EntityWrapper<ZuoyetijiaoEntity>();



		PageUtils page = zuoyetijiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyetijiao), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuoyetijiaoEntity zuoyetijiao, 
		HttpServletRequest request){
        EntityWrapper<ZuoyetijiaoEntity> ew = new EntityWrapper<ZuoyetijiaoEntity>();

		PageUtils page = zuoyetijiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyetijiao), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuoyetijiaoEntity zuoyetijiao){
       	EntityWrapper<ZuoyetijiaoEntity> ew = new EntityWrapper<ZuoyetijiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuoyetijiao, "zuoyetijiao")); 
        return R.ok().put("data", zuoyetijiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuoyetijiaoEntity zuoyetijiao){
        EntityWrapper< ZuoyetijiaoEntity> ew = new EntityWrapper< ZuoyetijiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuoyetijiao, "zuoyetijiao")); 
		ZuoyetijiaoView zuoyetijiaoView =  zuoyetijiaoService.selectView(ew);
		return R.ok("查询作业提交成功").put("data", zuoyetijiaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuoyetijiaoEntity zuoyetijiao = zuoyetijiaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zuoyetijiao,deSens);
        return R.ok().put("data", zuoyetijiao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuoyetijiaoEntity zuoyetijiao = zuoyetijiaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zuoyetijiao,deSens);
        return R.ok().put("data", zuoyetijiao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuoyetijiaoEntity zuoyetijiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zuoyetijiao);
        zuoyetijiaoService.insert(zuoyetijiao);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuoyetijiaoEntity zuoyetijiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zuoyetijiao);
        zuoyetijiaoService.insert(zuoyetijiao);
        return R.ok().put("data",zuoyetijiao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuoyetijiaoEntity zuoyetijiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuoyetijiao);
        //全部更新
        zuoyetijiaoService.updateById(zuoyetijiao);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuoyetijiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}
