package controller;

import com.google.gson.*;

import data.UserDetails;
import dao.UsersDao;

public class HTTPRequestHandler {
    public static String handleRequest(String path, String request) throws Exception {
        String response = "";
        long id = 0;
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(request).getAsJsonObject();
        
        //Here it could be expanded for another commands like: select, update etc.
        if (path.equals("/webappform/insertUser")) {
            //Users object is prepared
            UserDetails userReg = new UserDetails(jsonObject);
            //Dao is called to insert user details into DB and ID is expected for newly created user
            id = UsersDao.insertUser(userReg);
        }
        
        if (id > 0) {
            response = "User is registered with ID: " + id;
        } else {
            response = "Error occured while inserting";
        }
        return response;
    }
}
