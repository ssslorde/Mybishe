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
import com.entity.TokenEntity;
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

import com.entity.XueshengEntity;
import com.entity.view.XueshengView;

import com.service.XueshengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 学生
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-11 19:34:14
 */
@RestController
@RequestMapping("/xuesheng")
public class XueshengController {
    @Autowired
    private XueshengService xueshengService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		XueshengEntity u = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("xuehao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"xuesheng",  "学生" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody XueshengEntity xuesheng){
    	//ValidatorUtils.validateEntity(xuesheng);
    	XueshengEntity u = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("xuehao", xuesheng.getXuehao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		xuesheng.setId(uId);
        xueshengService.insert(xuesheng);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        XueshengEntity u = xueshengService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	XueshengEntity u = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("xuehao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        xueshengService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengEntity xuesheng,
		HttpServletRequest request){
        EntityWrapper<XueshengEntity> ew = new EntityWrapper<XueshengEntity>();



		PageUtils page = xueshengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuesheng), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengEntity xuesheng, 
		HttpServletRequest request){
        EntityWrapper<XueshengEntity> ew = new EntityWrapper<XueshengEntity>();

		PageUtils page = xueshengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuesheng), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengEntity xuesheng){
       	EntityWrapper<XueshengEntity> ew = new EntityWrapper<XueshengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuesheng, "xuesheng")); 
        return R.ok().put("data", xueshengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengEntity xuesheng){
        EntityWrapper< XueshengEntity> ew = new EntityWrapper< XueshengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuesheng, "xuesheng")); 
		XueshengView xueshengView =  xueshengService.selectView(ew);
		return R.ok("查询学生成功").put("data", xueshengView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengEntity xuesheng = xueshengService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xuesheng,deSens);
        return R.ok().put("data", xuesheng);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengEntity xuesheng = xueshengService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xuesheng,deSens);
        return R.ok().put("data", xuesheng);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengEntity xuesheng, HttpServletRequest request){
        if(xueshengService.selectCount(new EntityWrapper<XueshengEntity>().eq("xuehao", xuesheng.getXuehao()))>0) {
            return R.error("学号已存在");
        }
    	xuesheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuesheng);
    	XueshengEntity u = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("xuehao", xuesheng.getXuehao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		xuesheng.setId(new Date().getTime());
        xueshengService.insert(xuesheng);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueshengEntity xuesheng, HttpServletRequest request){
        if(xueshengService.selectCount(new EntityWrapper<XueshengEntity>().eq("xuehao", xuesheng.getXuehao()))>0) {
            return R.error("学号已存在");
        }
    	xuesheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuesheng);
    	XueshengEntity u = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("xuehao", xuesheng.getXuehao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		xuesheng.setId(new Date().getTime());
        xueshengService.insert(xuesheng);
        return R.ok().put("data",xuesheng.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengEntity xuesheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuesheng);
        if(xueshengService.selectCount(new EntityWrapper<XueshengEntity>().ne("id", xuesheng.getId()).eq("xuehao", xuesheng.getXuehao()))>0) {
            return R.error("学号已存在");
        }
        //全部更新
        xueshengService.updateById(xuesheng);
    if(null!=xuesheng.getXuehao())
    {
        // 修改token
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUsername(xuesheng.getXuehao());
        tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", xuesheng.getId()));
    }


        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








        /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_xuesheng_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<XueshengEntity> ew = new EntityWrapper<XueshengEntity>();
            List<Map<String, Object>> result = xueshengService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        Collections.sort(result, (map1, map2) -> {
            // 假设 total 总是存在并且是数值类型
            Number total1 = (Number) map1.get("total");
            Number total2 = (Number) map2.get("total");
            return Double.compare(total2.doubleValue(), total1.doubleValue());
        });
        return R.ok().put("data", result);
        }
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_xuesheng_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<XueshengEntity> ew = new EntityWrapper<XueshengEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = xueshengService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
}
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_xuesheng_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("yColumn", yColumnName);
            params.put("timeStatType", timeStatType);
            EntityWrapper<XueshengEntity> ew = new EntityWrapper<XueshengEntity>();
                    List<Map<String, Object>> result = xueshengService.selectTimeStatValue(params, ew);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            return R.ok().put("data", result);
        }
    }
    
        /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        java.nio.file.Path path = java.nio.file.Paths.get("value_xuesheng_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            String[] yColumnNames = yColumnNameMul.split(",");
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("timeStatType", timeStatType);
            List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EntityWrapper<XueshengEntity> ew = new EntityWrapper<XueshengEntity>();
            for(int i=0;i<yColumnNames.length;i++) {
                params.put("yColumn", yColumnNames[i]);
                List<Map<String, Object>> result = xueshengService.selectTimeStatValue(params, ew);
                for(Map<String, Object> m : result) {
                    for(String k : m.keySet()) {
                        if(m.get(k) instanceof Date) {
                            m.put(k, sdf.format((Date)m.get(k)));
                        }
                    }
                }
                result2.add(result);
            }
            return R.ok().put("data", result2);
        }
    }
    
        /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("group_xuesheng_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<XueshengEntity> ew = new EntityWrapper<XueshengEntity>();
            List<Map<String, Object>> result = xueshengService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
        }
    }    
    
    




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,XueshengEntity xuesheng, HttpServletRequest request){
        EntityWrapper<XueshengEntity> ew = new EntityWrapper<XueshengEntity>();
        int count = xueshengService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuesheng), params), params));
        return R.ok().put("data", count);
    }




}
