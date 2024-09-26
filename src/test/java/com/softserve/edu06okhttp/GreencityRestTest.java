package com.softserve.edu06okhttp;

import com.google.gson.Gson;
import okhttp3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GreencityLogin {
    private int userId;
    private String accessToken;
    private String refreshToken;
    private String name;
    private boolean ownRegistrations;

    public GreencityLogin(int userId, String accessToken, String refreshToken, String name, boolean ownRegistrations) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.name = name;
        this.ownRegistrations = ownRegistrations;
    }

    public int getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getName() {
        return name;
    }

    public boolean isOwnRegistrations() {
        return ownRegistrations;
    }

    @Override
    public String toString() {
        return "GreencityLogin{" +
                "userId=" + userId +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", name='" + name + '\'' +
                ", ownRegistrations=" + ownRegistrations +
                '}';
    }
}

class GreencityAllEvents {
    private int totalElements;
    private int currentPage;
    private int totalPages;
    private int number;
    private boolean hasPrevious;
    private boolean hasNext;
    private boolean first;
    private boolean last;

    public GreencityAllEvents(int totalElements, int currentPage, int totalPages, int number, boolean hasPrevious, boolean hasNext, boolean first, boolean last) {
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.number = number;
        this.hasPrevious = hasPrevious;
        this.hasNext = hasNext;
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return "GreencityAllEvents{" +
                "totalElements=" + totalElements +
                ", currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", number=" + number +
                ", hasPrevious=" + hasPrevious +
                ", hasNext=" + hasNext +
                ", first=" + first +
                ", last=" + last +
                '}';
    }
}

class HabitTranslation {
    private String description;
    private String habitItem;
    private String languageCode;
    private String name;
    private String descriptionUa;
    private String nameUa;
    private String habitItemUa;

    public HabitTranslation(String description, String habitItem, String languageCode,
                            String name, String descriptionUa, String nameUa, String habitItemUa) {
        this.description = description;
        this.habitItem = habitItem;
        this.languageCode = languageCode;
        this.name = name;
        this.descriptionUa = descriptionUa;
        this.nameUa = nameUa;
        this.habitItemUa = habitItemUa;
    }

    @Override
    public String toString() {
        return "\n\t\tHabitTranslation{" +
                "description='" + description + '\'' +
                ", habitItem='" + habitItem + '\'' +
                ", languageCode='" + languageCode + '\'' +
                ", name='" + name + '\'' +
                ", descriptionUa='" + descriptionUa + '\'' +
                ", nameUa='" + nameUa + '\'' +
                ", habitItemUa='" + habitItemUa + '\'' +
                '}';
    }
}

class ShoppingListItems {
    private int id;
    private String text;
    private String status;

    public ShoppingListItems(int id, String text, String status) {
        this.id = id;
        this.text = text;
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n\t\t\tShoppingListItems{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

class Page {

    private int defaultDuration;
    private int amountAcquiredUsers;
    private HabitTranslation habitTranslation;
    //
    private int id;
    private String image;
    private int complexity;
    List<String> tags;
    private List<ShoppingListItems> shoppingListItems;

    public Page(int defaultDuration, int amountAcquiredUsers, HabitTranslation habitTranslation,
                int id, String image, int complexity, List<String> tags,
                List<ShoppingListItems> shoppingListItems) {
        this.defaultDuration = defaultDuration;
        this.amountAcquiredUsers = amountAcquiredUsers;
        this.habitTranslation = habitTranslation;
        this.id = id;
        this.image = image;
        this.complexity = complexity;
        this.tags = tags;
        this.shoppingListItems = shoppingListItems;
    }

    @Override
    public String toString() {
        return "\n\tPage{" +
                "defaultDuration=" + defaultDuration +
                ", amountAcquiredUsers=" + amountAcquiredUsers +
                ", habitTranslation=" + habitTranslation +
                ", \n\t\tid=" + id +
                ", image='" + image + '\'' +
                ", complexity=" + complexity +
                ", \n\t\ttags=" + tags +
                ", shoppingListItems=" + shoppingListItems +
                '}';
    }
}

class GreencityAllHabits {
    List<Page> page;

    public GreencityAllHabits(List<Page> page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "GreencityAllHabits{" +
                "page=" + page +
                '}';
    }
}


// ---------- ---------- ---------- ---------- ---------- ---------- ---------- ----------

public class GreencityRestTest {

    @Test
    public void checkGreencity() throws Exception {
        Gson gson = new Gson();
        //
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody;
        Request request;
        Response response;
        GreencityLogin greencityLogin;
        GreencityAllEvents greencityAllEvents;
        String resultJson;
        String token;
        //
        // Login
        String jsonBody =  new StringBuilder()
                .append("{")
                .append("\"email\":\"tyv09754@zslsz.com\",")
                .append("\"password\":\"Qwerty_1\"")
                .append("}").toString();

        requestBody = RequestBody.create(jsonBody,
                MediaType.parse("application/json; charset=utf-8"));
        request = new Request.Builder()
                .url("https://greencity-user.greencity.cx.ua/ownSecurity/signIn")
                .addHeader("Content-Type", "application/json")
                .post(requestBody)
                .build();
        response = client.newCall(request).execute();
        resultJson = response.body().string();
        greencityLogin = gson.fromJson(resultJson, GreencityLogin.class);
        token = greencityLogin.getAccessToken();
        //
        System.out.println("resultJson = " + resultJson);
        System.out.println("greencityLogin = " + greencityLogin);
        System.out.println("token = " + token);
        //
        Assertions.assertTrue(response.isSuccessful());
        Assertions.assertEquals(response.code(),200);
        //
        // Get all Events
        HttpUrl.Builder urlBuilder = HttpUrl
                .parse("https://greencity.greencity.cx.ua/events")
                .newBuilder();
        urlBuilder.addQueryParameter("time", "FUTURE");
        urlBuilder.addQueryParameter("cities", "string");
        urlBuilder.addQueryParameter("statuses", "OPEN");
        urlBuilder.addQueryParameter("tags", "string");
        urlBuilder.addQueryParameter("title", "string");
        urlBuilder.addQueryParameter("type", "ONLINE");
        urlBuilder.addQueryParameter("page", "0");
        urlBuilder.addQueryParameter("size", "5");
        String url = urlBuilder.build().toString();
        //
        System.out.println("\turl = " + url);
        //
        request = new Request
                .Builder()
                .url(url)
                .addHeader("Accept", "*/*")
                .addHeader("Authorization", "Bearer " + token)
                .get()
                .build();
        response = client.newCall(request).execute();
        resultJson = response.body().string();
        greencityAllEvents = gson.fromJson(resultJson, GreencityAllEvents.class);
        //
        Assertions.assertTrue(response.isSuccessful());
        Assertions.assertEquals(200, response.code());
        //
        System.out.println("resultJson: " + resultJson);
        System.out.println("greencityAllEvents: " + greencityAllEvents);
        //
        // Get all Habits
        urlBuilder = HttpUrl
                .parse("https://greencity.greencity.cx.ua/habit")
                .newBuilder();
        urlBuilder.addQueryParameter("page", "0");
        urlBuilder.addQueryParameter("size", "5");
        urlBuilder.addQueryParameter("sort", "asc");
        url = urlBuilder.build().toString();
        //
        System.out.println("\turl = " + url);
        //
        request = new Request
                .Builder()
                .url(url)
                .addHeader("Accept", "*/*")
                .addHeader("Authorization", "Bearer " + token)
                .get()
                .build();
        response = client.newCall(request).execute();
        resultJson = response.body().string();
        GreencityAllHabits greencityAllHabits = gson.fromJson(resultJson, GreencityAllHabits.class);
        //
        Assertions.assertTrue(response.isSuccessful());
        Assertions.assertEquals(200, response.code());
        //
        System.out.println("resultJson: " + resultJson);
        System.out.println("greencityAllHabits: " + greencityAllHabits);
    }
}
