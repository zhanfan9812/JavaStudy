package com.zhanfan.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhanfan.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhanfan.common.utils.PageUtils;
import com.zhanfan.common.utils.Query;

import com.zhanfan.gulimall.product.dao.CategoryDao;
import com.zhanfan.gulimall.product.entity.CategoryEntity;
import com.zhanfan.gulimall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //找到所有的一级分类
        return entities.stream()
                .filter(item -> item.getParentCid() == 0)
                .peek(menu-> menu.setChildren(getChildrens(menu,entities)))
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 检查当前的菜单是否被别的地方所引用再删除
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> path = new ArrayList<>();
        List<Long> parentPath = findParentPath(catelogId, path);
        return parentPath.toArray(new Long[parentPath.size()]);
    }

    //级联更新所有的关联数据
    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());
    }

    private List<Long> findParentPath(Long catelogId,List<Long> path){
        CategoryEntity byId = this.getById(catelogId);
        if(byId.getParentCid()!=0){
            findParentPath(byId.getParentCid(),path);
        }
        path.add(catelogId);
        return path;
    }

    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream()
                .filter(item -> item.getParentCid().equals(root.getCatId()))//1.过滤得到当前子菜单
                .peek(item -> item.setChildren(getChildrens(item, all)))    //2.递归获取子菜单
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))) //3.排序
                .collect(Collectors.toList());  //4.收集成List并返回
    }
}