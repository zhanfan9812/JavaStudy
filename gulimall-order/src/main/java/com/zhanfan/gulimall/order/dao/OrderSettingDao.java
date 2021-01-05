package com.zhanfan.gulimall.order.dao;

import com.zhanfan.gulimall.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author zhanfan
 * @email 869791827@qq.com
 * @date 2021-01-05 11:52:08
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}
