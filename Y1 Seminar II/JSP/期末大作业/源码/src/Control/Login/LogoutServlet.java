package Control.Login;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    // 注销用
    // TODO: 删除cookie


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        for (Cookie cookie: req.getCookies()){
            if ("autoLogin".equalsIgnoreCase(cookie.getName())){
                System.out.println("登出信息获取 : " + cookie.getValue());
                // 新建一个同名 但是值为空的 cookie
                Cookie nullAutoLogin = new Cookie("autoLogin",null);
                nullAutoLogin.setMaxAge(0);
                nullAutoLogin.setPath("/");
                // 覆盖原cookie
                resp.addCookie(nullAutoLogin);

            }
        }

        utils.ErrorInfoSet.ErrorSet(req,resp,"Logout Success","成功登出","index");
        resp.setHeader("Refresh","3;URL=" + req.getContextPath()+"/index");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
