package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CankexinxiDao;
import com.entity.CankexinxiEntity;
import com.service.CankexinxiService;
import com.entity.vo.CankexinxiVO;
import com.entity.view.CankexinxiView;

@Service("cankexinxiService")
public class CankexinxiServiceImpl extends ServiceImpl<CankexinxiDao, CankexinxiEntity> implements CankexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CankexinxiEntity> page = this.selectPage(
                new Query<CankexinxiEntity>(params).getPage(),
                new EntityWrapper<CankexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CankexinxiEntity> wrapper) {
		  Page<CankexinxiView> page =new Query<CankexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CankexinxiVO> selectListVO(Wrapper<CankexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CankexinxiVO selectVO(Wrapper<CankexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CankexinxiView> selectListView(Wrapper<CankexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CankexinxiView selectView(Wrapper<CankexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<CankexinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<CankexinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<CankexinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
