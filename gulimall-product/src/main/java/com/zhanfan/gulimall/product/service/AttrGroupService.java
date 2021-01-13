package com.zhanfan.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhanfan.common.utils.PageUtils;
import com.zhanfan.gulimall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author zhanfan
 * @email 869791827@qq.com
 * @date 2020-12-30 16:38:28
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);
}

