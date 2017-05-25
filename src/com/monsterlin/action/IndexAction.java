package com.monsterlin.action;

import com.monsterlin.bean.SatinEntity;
import com.monsterlin.dao.GrabSatinDao;
import com.monsterlin.impl.GrabSatinImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * author : monsterLin
 * email : monster941025@gmail.com
 * date : 2017/5/25
 * desc : index处理
 */
public class IndexAction extends ActionSupport {
    private List<SatinEntity> satinList;

    public List<SatinEntity> getSatinList() {
        return satinList;
    }

    public void setSatinList(List<SatinEntity> satinList) {
        this.satinList = satinList;
    }

    /**
     * 初始化列表
     * @return
     */
    public String listInit() {

        GrabSatinDao grabSatinDao = new GrabSatinImpl();
        satinList = grabSatinDao.getSatinData(20, 1);

        return "success";
    }


    /**
     * 分页查询
     * @return
     */
    public String listByPage() {

        HttpServletRequest request = ServletActionContext.getRequest();  //取得请求对象
        String strPageNum = request.getParameter("pageNum");
        String strPageSize = request.getParameter("pageSize");

        GrabSatinDao grabSatinDao = new GrabSatinImpl();

        if (strPageNum != null && !"".equals(strPageNum) && strPageSize != null && !"".equals(strPageSize)) {
            int pageNum = Integer.parseInt(strPageNum);
            int pageSize = Integer.parseInt(strPageSize);

            satinList = grabSatinDao.getSatinData(pageSize, pageNum);

        }

        return "success";
    }
}
