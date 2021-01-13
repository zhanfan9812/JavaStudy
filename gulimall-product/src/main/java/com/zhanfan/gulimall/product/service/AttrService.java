package com.zhanfan.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhanfan.common.utils.PageUtils;
import com.zhanfan.gulimall.product.entity.AttrEntity;
import com.zhanfan.gulimall.product.vo.AttrRespVo;
import com.zhanfan.gulimall.product.vo.AttrVo;

import java.util.Map;

/**
 * 商品属性
 *
 * @author zhanfan
 * @email 869791827@qq.com
 * @date 2020-12-30 16:38:28
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);
}

