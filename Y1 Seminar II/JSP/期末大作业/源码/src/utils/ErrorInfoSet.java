package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorInfoSet {

    /**
     *
     * @param req 请求
     * @param resp 返回相应
     * @param code 错误代码
     * @param message 错误信息
     * @param address 跳转的地址 无需加入前缀
     * @throws IOException 错误
     */
    public static void ErrorSet(HttpServletRequest req, HttpServletResponse resp,String code,String message,String address) throws IOException {


        req.getSession().setAttribute("errorAddress",address);
        req.getSession().setAttribute("errorCode",code);
        req.getSession().setAttribute("errorMsg",message);
        resp.sendRedirect(req.getContextPath() + "/Error.jsp");
    }
}
