package com.monsterlin.dao;

import com.monsterlin.bean.Satin;
import com.monsterlin.bean.SatinEntity;

import java.util.List;

/**
 * author : monsterLin
 * email : monster941025@gmail.com
 * date : 2017/5/23
 * desc : 抓取数据接口
 */
public interface GrabSatinDao {
    /**
     * 分页获取数据
     * @param pageSize 每页的数量
     * @param pageNum  页码
     * @return
     */
     List<SatinEntity> getSatinData(int pageSize, int pageNum);

    /**
     * 添加数据
     * @param satinEntity
     */
     void addSatin(SatinEntity satinEntity);



}
