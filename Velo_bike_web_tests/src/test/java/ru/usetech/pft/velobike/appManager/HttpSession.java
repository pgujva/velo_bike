package ru.usetech.pft.velobike.appManager;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;
import java.io.IOException;

public class HttpSession {
    private CloseableHttpClient httpclient;
    private ApplicationManager app;

    public HttpSession(ApplicationManager app) {
        this.app = app;
        httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    }

    public String resp() throws IOException {
        HttpGet get = new HttpGet("https://electro.velobike.ru/ajax/parkings/?_=1535358830923");
        CloseableHttpResponse response = httpclient.execute(get);
        String body = geTextFrom(response);
        return body;
    }

    private String geTextFrom(CloseableHttpResponse response) throws IOException {
        try {
            return EntityUtils.toString(response.getEntity());

        } finally {
            response.close();
        }
    }
}
