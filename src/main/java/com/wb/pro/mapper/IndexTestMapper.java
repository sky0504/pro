package com.wb.pro.mapper;

import com.wb.pro.vo.IndexTestVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 测试数据库Mapper
 *
 * @author: WangBin
 * @create: 2020-02-01 09:19
 **/
@Mapper
public interface IndexTestMapper {
    /**
     * 获取内容列表
     *
     * @return
     */
    List<IndexTestVo> getIndexTestVoList();

    /**
     * 带分页的获取列表
     * @param rowBounds
     * @return
     */
    List<IndexTestVo> getIndexTestVoListPage(RowBounds rowBounds);
}
