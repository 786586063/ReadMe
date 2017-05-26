package com.monsterlin.impl;

import com.monsterlin.bean.SatinEntity;
import com.monsterlin.dao.GrabSatinDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import static com.monsterlin.dao.HibernateSessionFactory.getSession;

/**
 * author : monsterLin
 * email : monster941025@gmail.com
 * date : 2017/5/23
 * desc : 抓取数据实现类
 */
public class GrabSatinImpl implements GrabSatinDao {

    @Override
    public List<SatinEntity> getSatinData(int pageSize, int pageNum) {
        List<SatinEntity> list = new ArrayList<SatinEntity>();
        Session session = getSession();
        try{
            String hql = "from SatinEntity order by date desc ";     //hql是从对象中进行查询，使用Books而不是表Books
            Query q = session.createQuery(hql);
            q.setFirstResult((pageNum-1)*pageSize);   //过滤前面的pageNum-1页的数据
            q.setMaxResults(pageSize);   //取出当前页的数据来
            list = q.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return list;
    }

    @Override
    public void addSatin(SatinEntity satinEntity) {
        Session session = getSession();
        Transaction tran = session.beginTransaction();  //开启事务
        try{
            session.save(satinEntity);
            tran.commit();   //执行事务
        }catch(Exception ex){
            tran.rollback();  //回滚事务
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public int sumSatin() {
        String hql = "select count(*) from SatinEntity ";
        Query q = getSession().createQuery(hql);
        int count = ((Long) q.iterate().next()).intValue(); //查询数量，返回数量值
        return count;

    }

    @Override
    public int pageSum(int satinSum) {
        int pageSum = satinSum/10 + 1 ;
        return pageSum;
    }


}
