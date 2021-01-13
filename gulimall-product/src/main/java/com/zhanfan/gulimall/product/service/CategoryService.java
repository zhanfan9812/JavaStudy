package com.zhanfan.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhanfan.common.utils.PageUtils;
import com.zhanfan.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author zhanfan
 * @email 869791827@qq.com
 * @date 2020-12-30 16:38:28
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);

    //找到catelogId的完整路径[父,子,孙]
    Long[] findCatelogPath(Long catelogId);

    void updateCascade(CategoryEntity category);
}

