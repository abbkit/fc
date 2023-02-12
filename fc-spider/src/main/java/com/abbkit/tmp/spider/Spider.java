package com.abbkit.tmp.spider;

import com.abbkit.tmp.spider.po.TDiseaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Spider {


    public static void main(String[] args) throws Exception {
        String url="https://www.chinacdc.cn/jkzt/crb/";
        List<TDiseaseEntity> tDiseaseEntities = Spider.run(url);
        log.info(tDiseaseEntities.toString());
    }


    public static List<TDiseaseEntity> run(String url) throws Exception{
        String html = getGet(url, 30_000, 30_000);
        List<String> aList=new ArrayList<>(); // 甲类
        List<String> bList=new ArrayList<>(); // 乙类
        List<String> cList=new ArrayList<>(); // 丙类
        List<String> dList=new ArrayList<>(); // 其他


        Document document = Jsoup.parse(html);
        //甲类
        Elements elements = document.selectXpath("/html/body/div[3]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/ul");
        for (Element element : elements) {
            Elements li = element.select("li");
            for (Element liElement : li) {
                Element textElement = liElement.select("a").get(0);
                String text = textElement.text();
                aList.add(text);
            }
        }

        //乙类
        elements = document.selectXpath("/html/body/div[3]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/ul");
        for (Element element : elements) {
            Elements li = element.select("li");
            for (Element liElement : li) {
                Element textElement = liElement.select("a").get(0);
                String text = textElement.text();
                bList.add(text);
            }
        }

        //丙类
        elements = document.selectXpath("/html/body/div[3]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/ul");
        for (Element element : elements) {
            Elements li = element.select("li");
            for (Element liElement : li) {
                Element textElement = liElement.select("a").get(0);
                String text = textElement.text();
                cList.add(text);
            }
        }


        //其他
        elements = document.selectXpath("/html/body/div[3]/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/ul");
        for (Element element : elements) {
            Elements li = element.select("li");
            for (Element liElement : li) {
                Element textElement = liElement.select("a").get(0);
                String text = textElement.text();
                dList.add(text);
            }
        }

        List<TDiseaseEntity> diseaseEntityList=new ArrayList<>();
        String category="甲类";
        model(aList, category,diseaseEntityList);

        category="乙类";
        model(bList, category,diseaseEntityList);

        category="丙类";
        model(cList, category,diseaseEntityList);

        category="其他";
        model(dList, category,diseaseEntityList);

        return diseaseEntityList;
    }

    private static void model(List<String> aList, String category,List<TDiseaseEntity> diseaseEntityList) {
        for (String one : aList) {
            TDiseaseEntity diseaseEntity=new TDiseaseEntity();
            diseaseEntity.setCategory(category);
            diseaseEntity.setName(one);
            diseaseEntityList.add(diseaseEntity);
        }
    }


    /**
     * 获取 GET请求
     *
     * @return 请求结果
     */
    public static String getGet(String url, Integer connectTimeout, Integer readTimeout) throws IOException {

        URL u;
        HttpURLConnection connection;
        u = new URL(url);
        connection = (HttpURLConnection) u.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);

        // 获取请求返回的数据流
        InputStream is = connection.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 封装输入流is，并指定字符集
        int i;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();

    }


}
