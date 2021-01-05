package com.zhanfan.gulimall.member.dao;

import com.zhanfan.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zhanfan
 * @email 869791827@qq.com
 * @date 2021-01-05 11:41:11
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
