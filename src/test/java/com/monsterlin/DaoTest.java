package com.monsterlin;

import com.monsterlin.bean.AdminEntity;
import com.monsterlin.bean.SatinEntity;
import com.monsterlin.dao.GrabSatinDao;
import com.monsterlin.dao.HibernateSessionFactory;
import com.monsterlin.grab.impl.GrabSatinImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * author : monsterLin
 * email : monster941025@gmail.com
 * date : 2017/5/24
 * desc :  业务类单元测试
 */
public class DaoTest {

    Session session = null ;
    Transaction tran = null ;

    @Before
    public void init(){
         session = HibernateSessionFactory.getSession();
         tran = session.beginTransaction();  //开启事务
    }

    @Test
    public void testGetSatinData(){
        GrabSatinDao dao=new GrabSatinImpl();
        List<SatinEntity> satinEntityList=dao.getSatinData(20, 1);  //得到图书列表
        for(int i=0;i<satinEntityList.size();i++){
            SatinEntity satinEntity=satinEntityList.get(i);
            System.out.println(satinEntity.getAuthor());
        }
    }

    @Test
    public void testAddSatin(){
        try {

            SatinEntity satinEntity = new SatinEntity();
            satinEntity.setAuthor("test");
            satinEntity.setAuthorImg("https://pic.qiushibaike.com/system/avtnew/1167/11678685/medium/2017052015351347.JPEG");
            satinEntity.setContent("test");
            satinEntity.setFromUrl("https://www.baidu.com");
            satinEntity.setSource("糗事百科");

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sf.format(new Date());
            satinEntity.setDate(date);

            session.save(satinEntity);
            tran.commit();

        }catch (Exception ex){
            tran.rollback();
            ex.printStackTrace();
        }

    }

    @Test
    public void testAddAdmin() {
        try {
            AdminEntity admin = new AdminEntity();
            admin.setUsername("test");
            admin.setUserpass("test");
            session.save(admin);
            tran.commit();   //执行事务
        } catch (Exception ex) {
            tran.rollback();  //回滚事务
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }


    @Test
    public void testPage(){
        GrabSatinDao grabSatinDao = new GrabSatinImpl();
        int sumSatin = grabSatinDao.sumSatin();
        int sumPage = sumSatin/20 + 1 ;

        System.out.println("总页码为："+sumPage);
    }

}