package org.example.api;
import okhttp3.*;

public class getSample {

    public void makeCall() {


        OkHttpClient client = new OkHttpClient();

        String url = "http://127.0.0.1:7000/static/sample1.png";

        Request request = new Request.Builder().get().url(url).build();

        try (Response resp = client.newCall(request).execute()) {
            if (resp.body() != null) {
                byte[] bytes = resp.body().bytes();
                System.out.println(new String(bytes));
            }
        } catch (Exception e) {
            System.out.println("error fetching bytes form server. may be --server offline");
        }
    }
}
