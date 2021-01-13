package com.zhanfan.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhanfan.common.utils.PageUtils;
import com.zhanfan.gulimall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author zhanfan
 * @email 869791827@qq.com
 * @date 2020-12-30 16:38:28
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

