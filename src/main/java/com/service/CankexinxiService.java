package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CankexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CankexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CankexinxiView;


/**
 * 参课信息
 *
 * @author 
 * @email 
 * @date 2025-01-11 19:34:15
 */
public interface CankexinxiService extends IService<CankexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CankexinxiVO> selectListVO(Wrapper<CankexinxiEntity> wrapper);
   	
   	CankexinxiVO selectVO(@Param("ew") Wrapper<CankexinxiEntity> wrapper);
   	
   	List<CankexinxiView> selectListView(Wrapper<CankexinxiEntity> wrapper);
   	
   	CankexinxiView selectView(@Param("ew") Wrapper<CankexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CankexinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CankexinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CankexinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CankexinxiEntity> wrapper);



}

