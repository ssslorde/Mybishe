package com.dao;

import com.entity.XuekeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuekeVO;
import com.entity.view.XuekeView;


/**
 * 学科
 * 
 * @author 
 * @email 
 * @date 2025-01-11 19:34:15
 */
public interface XuekeDao extends BaseMapper<XuekeEntity> {
	
	List<XuekeVO> selectListVO(@Param("ew") Wrapper<XuekeEntity> wrapper);
	
	XuekeVO selectVO(@Param("ew") Wrapper<XuekeEntity> wrapper);
	
	List<XuekeView> selectListView(@Param("ew") Wrapper<XuekeEntity> wrapper);

	List<XuekeView> selectListView(Pagination page,@Param("ew") Wrapper<XuekeEntity> wrapper);

	
	XuekeView selectView(@Param("ew") Wrapper<XuekeEntity> wrapper);
	

}
