package Control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JSONBack extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("application/x-json");
        resp.setHeader("Cache-Control","no-cache");


        //* 增加复用性

        String jsonFeedback = (String) req.getSession().getAttribute("JSONFeedback");

        if (jsonFeedback != null){
            resp.getWriter().write(jsonFeedback);
        }



    }


}
