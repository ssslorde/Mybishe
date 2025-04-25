package com.dao;

import com.entity.CankexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CankexinxiVO;
import com.entity.view.CankexinxiView;


/**
 * 参课信息
 * 
 * @author 
 * @email 
 * @date 2025-01-11 19:34:15
 */
public interface CankexinxiDao extends BaseMapper<CankexinxiEntity> {
	
	List<CankexinxiVO> selectListVO(@Param("ew") Wrapper<CankexinxiEntity> wrapper);
	
	CankexinxiVO selectVO(@Param("ew") Wrapper<CankexinxiEntity> wrapper);
	
	List<CankexinxiView> selectListView(@Param("ew") Wrapper<CankexinxiEntity> wrapper);

	List<CankexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<CankexinxiEntity> wrapper);

	
	CankexinxiView selectView(@Param("ew") Wrapper<CankexinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CankexinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CankexinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CankexinxiEntity> wrapper);



}
