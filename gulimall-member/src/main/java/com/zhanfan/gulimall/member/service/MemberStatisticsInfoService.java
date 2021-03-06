package com.zhanfan.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhanfan.common.utils.PageUtils;
import com.zhanfan.gulimall.member.entity.MemberStatisticsInfoEntity;

import java.util.Map;

/**
 * 会员统计信息
 *
 * @author zhanfan
 * @email 869791827@qq.com
 * @date 2021-01-05 11:41:11
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

