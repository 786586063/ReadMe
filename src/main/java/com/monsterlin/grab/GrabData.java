package com.monsterlin.grab;

import com.monsterlin.bean.SatinEntity;
import com.monsterlin.constant.URLContent;
import com.monsterlin.dao.GrabSatinDao;
import com.monsterlin.grab.impl.GrabSatinImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author : monsterLin
 * email : monster941025@gmail.com
 * date : 2017/5/23
 * desc :  抓取测试
 * TODO： 此类需要进一步优化
 */
public class GrabData {

    /**
     * 抓取糗事百科并且装入数据库
     * @throws IOException
     */
    public static void grabDataFromQSBK()throws IOException {
   // public static void main(String [] args)throws IOException {


        /**
         * 20
         *
         * title : 来源
         *
         * h2 : 用户名
         *
         * div.content : 内容
         *
         * img[alt] : 头像  前20
         *
         * a.contentHerf: 详情页 href : http://www.qiushibaike.com + href
         *
         * 时间显示的为抓取的时间
         */

        Document doc;
        SimpleDateFormat df;
        String grabDate;

        GrabSatinDao grabSatinDao;

        List<String> authorImgList, authorList, contentList, contentUrlList;


        doc = Jsoup.connect(URLContent.QIUSHIBAIKE).get();
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        grabDate = df.format(new Date());
        System.out.println("本次抓取时间：" + grabDate);

        authorImgList = new ArrayList<>();
        Elements authorImgElements = doc.select("img[alt]");
        for (int i = 0; i < 20; i++) {
            authorImgList.add(authorImgElements.get(i).attr("src"));
        }

        authorList = new ArrayList<>();
        Elements authorElements = doc.select("h2");
        for (int i = 0; i < authorElements.size(); i++) {
            authorList.add(authorElements.get(i).text());
        }


        contentList = new ArrayList<>();
        Elements contentElements = doc.select("div.content");
        for (int i = 0; i < contentElements.size(); i++) {
            contentList.add(contentElements.get(i).text());
        }


        contentUrlList = new ArrayList<>();
        Elements contentUrlElements = doc.select("a.contentHerf");
        for (int i = 0; i < contentUrlElements.size(); i++) {
            contentUrlList.add("http://www.qiushibaike.com" + contentUrlElements.get(i).attr("href"));
        }

        System.out.println("-------------------------------");

        System.out.println("抓取用户名数量：" + authorList.size() + "\n"
                + "抓取头像数量：" + authorImgList.size() + "\n"
                + "抓取内容数量：" + contentList.size() + "\n"
                + "抓取内容url数量：" + contentUrlList.size());


        /**
         * 依次将抓取的数据注入到数据库中
         */
        grabSatinDao = new GrabSatinImpl();

        for (int i = 0; i < 20; i++) {
            String authorImg = authorImgList.get(i);
            String author = authorList.get(i);
            String content = contentList.get(i);
            String contentUrl = contentUrlList.get(i);

            SatinEntity satinEntity = new SatinEntity();

            satinEntity.setAuthor(author);
            satinEntity.setAuthorImg(authorImg);
            satinEntity.setContent(content);
            satinEntity.setFromUrl(contentUrl);
            satinEntity.setSource("糗事百科");
            satinEntity.setDate(grabDate);

            grabSatinDao.addSatin(satinEntity);

        }

        System.out.println("-------------------------------");

        System.out.println("成功抓取数据并装入数据库");


    }
}
