package com.example.it.hww;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.it.hww.http.HttpClient;
import com.example.it.hww.http.IHttpClient;
import com.example.it.hww.json.IUsersList;
import com.example.it.hww.json.UserGson;
import com.example.it.hww.json.UsersListParserFactory;

import java.io.InputStream;
import java.util.List;


public class UserListLoader extends AsyncTask<Context, Void, String> {

    public static final String NO_DATA = "No data";
    private IUsersList userListWithObject;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {

        final UsersListParserFactory usersListParserFactory = new UsersListParserFactory();
        IHttpClient httpClient = new HttpClient();

        userListWithObject = null;

        httpClient.request(Api.USER_URL, new HttpClient.ResponseListener() {
            @Override
            public void onResponse(InputStream inputStream) {
                try {
                    userListWithObject = usersListParserFactory.createParserForResponceWithObject(inputStream).parse();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        context = params[0];


        if (userListWithObject == null) {
            return NO_DATA;
        }

        List<UserGson> usersList = userListWithObject.getUsersList();

        if (usersList == null || usersList.isEmpty()) {
            return NO_DATA;
        }
        return usersList.get(usersList.size() -1).getName();
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }


}
