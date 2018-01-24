package com.ay.user.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.ay.user.R;
import com.ay.user.comman.Constants;
import com.ay.user.ui.activity.base.BaseActivity;
import com.ay.user.views.NaviTitleView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import butterknife.BindView;

/**
 * Created by ${lgy} on 2017/11/2911:22
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ProductDetailActivity extends BaseActivity {
    @BindView(R.id.navi_view)
    NaviTitleView naviView;
    @BindView(R.id.web_view)
    WebView webView;

    private String title;

    private String content;

    @Override
    public int getContentViewId() {
        return R.layout.activity_product_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        } else {
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        }
        webView.setBackgroundColor(0);
    }

    @Override
    public void initData() {
        super.initData();
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");
        webView.loadDataWithBaseURL(null, Constants.html_des+ getHtmlNewContent(content)+Constants.html_des_end, "text/html", "utf-8", null);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }
    /**
     * 解决图片太大不能适配屏幕
     *
     * @param htmltext
     * @return
     */
    public static String getHtmlNewContent(String htmltext) {
        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width", "100%").attr("height", "auto");
        }
        return doc.toString();
    }
}
