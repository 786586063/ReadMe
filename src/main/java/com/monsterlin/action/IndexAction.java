package com.monsterlin.action;

import com.monsterlin.bean.SatinEntity;
import com.monsterlin.dao.GrabSatinDao;
import com.monsterlin.grab.impl.GrabSatinImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * author : monsterLin
 * email : monster941025@gmail.com
 * date : 1017/5/25
 * desc : index处理
 */
public class IndexAction extends ActionSupport {
    private List<SatinEntity> satinList;
    private int pageSum ; //总页码数

    public List<SatinEntity> getSatinList() {
        return satinList;
    }

    public void setSatinList(List<SatinEntity> satinList) {
        this.satinList = satinList;
    }


    public int getPageSum() {
        return pageSum;
    }

    public void setPageSum(int pageSum) {
        pageSum = pageSum;
    }

    /**
     * 初始化列表
     * @return
     */
    public String index() {

        GrabSatinDao grabSatinDao = new GrabSatinImpl();
        satinList = grabSatinDao.getSatinData(10, 1);

        int sumSatin = grabSatinDao.sumSatin();
        pageSum = sumSatin/10 + 1 ;

        return "pageInit";
    }


    /**
     * 分页查询
     * @return
     */
    public String listByPage() {

        HttpServletRequest request = ServletActionContext.getRequest();  //取得请求对象
        String strPageNum = request.getParameter("pageNum");
        //String strPageSize = request.getParameter("pageSize");

        GrabSatinDao grabSatinDao = new GrabSatinImpl();

        if (strPageNum != null && !"".equals(strPageNum) ) {
            int pageNum = Integer.parseInt(strPageNum);
           // int pageSize = Integer.parseInt(strPageSize);

            satinList = grabSatinDao.getSatinData(10, pageNum);

        }

        return "pageSatin";
    }



}
