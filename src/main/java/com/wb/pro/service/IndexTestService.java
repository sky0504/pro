package com.wb.pro.service;

import com.wb.pro.mapper.IndexTestMapper;
import com.wb.pro.vo.IndexTestVo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: WangBin
 * @create: 2020-02-01 11:26
 **/
@Service
public class IndexTestService {
    @Autowired
    private IndexTestMapper mapper;

    /**
     * 获取数据列表
     *
     * @return
     */
    public List<IndexTestVo> getIndexTestVoList() {
        return mapper.getIndexTestVoList();
    }

    public List<IndexTestVo> getIndexTestVoListPage(int start, int pageSize) {
        return mapper.getIndexTestVoListPage(new RowBounds(start, pageSize));
    }
}
