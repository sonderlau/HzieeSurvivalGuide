package cn.edu.hziee.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hziee.model.User;
import cn.edu.hziee.util.DBUtil;
import cn.edu.hziee.util.Fn;

public class UserServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request,response);
		String uri = request.getRequestURI();// /lyb/login.do
		String flag = uri.substring(uri.lastIndexOf('/') + 1, uri.lastIndexOf('.'));
		switch (flag) {
		case "add":
			// 切换到添加留言页面
			RequestDispatcher rd_add = request.getRequestDispatcher("problem.jsp");
			rd_add.forward(request, response);
			break;
		}
	
	}
		

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String uri = request.getRequestURI();
	    String flag = uri.substring(uri.lastIndexOf('/') + 1, uri.lastIndexOf('.'));
	    PrintWriter out = response.getWriter();
	    
	    switch (flag) {
			case "register":
				String register_username = Fn.GBK(request.getParameter("username"));
				String register_password = Fn.GBK(request.getParameter("password"));
				String register_checkPassword = Fn.GBK(request.getParameter("checkPassword"));
				DBUtil.getInstance().insertData("user", new String[] {"username", "password", "checkPassword"}, 
						                        new String[]{register_username,register_password,register_checkPassword});
//				if(register_username == "" || register_password == "" || register_checkPassword == ""){
//					out.print("<script language='javascript'>alert('涓嶈兘杈撳叆涓虹┖锛�');window.location.href='register.jsp'</script>");
//				}else{
//					gotoPath(request,response,"/login.jsp");
//				}
				gotoPath(request,response,"/register.jsp");
				break;
			case "login":
				String login_username = request.getParameter("username");
				String login_password = request.getParameter("password");
				String login_condition = "username='" + login_username + "' and password='" + login_password + "'";
				if (DBUtil.getInstance().CheckedLogin("user", login_condition) == true) {
					Hashtable<String, String> map = DBUtil.getInstance().execSQL("user", "id", login_condition);
					request.getSession().setAttribute("user_id", map.get("id"));
					String user_id = (String) request.getSession().getAttribute("user_id");
					gotoPath(request, response,"/index.jsp");
				}else if(login_username == "" || login_password == "") {
					out.print("<script language='javascript'>alert('鐢ㄦ埛鍚嶆垨鑰呭瘑鐮佷笉鑳借緭鍏ヤ负绌猴紒');window.location.href='login.jsp'</script>");
//					gotoPath(request, response,"/login.jsp");
				}
				break;
//				HttpSession session = request.getSession();
//				User username = (User) session.getAttribute("username");
//				if(username == null){
//					gotoPath(request, response,"login.jsp");
//				}else{
//					gotoPath(request, response,"problem.jsp");
//				}
		
	    case "problem":
	    	gotoPath(request,response,"/add.jsp");
//	    	String id = request.getParameter("id");
//			String username = Fn.GBK(request.getParameter("username"));
//			String username_message = Fn.GBK(request.getParameter("username_message"));
////			String add_time = Fn.GBK(request.)
//			DBUtil.getInstance().modifyData("message", new String[] { "username", "username_message" },
//					new String[] { username, username_message }, "id=" + id);
//			Hashtable<String, String> map = DBUtil.getInstance().execSQL("message", "max(id) as maxid", "1=1");
//			String message_id = map.get("maxid");
//
//			Object userId = request.getSession().getAttribute("user_id");
//			String userId1 = String.valueOf(userId);
//			DBUtil.getInstance().insertData("user_message", new String[] { "user_id", "message_id" },
//					new String[] { userId1 + "", message_id });
//			prepare_data(request, userId1);
//			gotoPath(request,response,"/problem.jsp");
//	    	
//	    	System.out.println(username);
//	    	break;
	    case"add":
	    	String id = request.getParameter("id");
			String username = Fn.GBK(request.getParameter("username"));
			String username_message = Fn.GBK(request.getParameter("username_message"));
//			String add_time = Fn.GBK(request.)
			DBUtil.getInstance().modifyData("message", new String[] { "username", "username_message" },
					new String[] { username, username_message }, "id=" + id);
			Hashtable<String, String> map = DBUtil.getInstance().execSQL("message", "max(id) as maxid", "1=1");
			String message_id = map.get("maxid");

			Object userId = request.getSession().getAttribute("user_id");
			String userId1 = String.valueOf(userId);
			DBUtil.getInstance().insertData("user_message", new String[] { "user_id", "message_id" },
					new String[] { userId1 + "", message_id });
			prepare_data(request, userId1);
			RequestDispatcher rd_add = request.getRequestDispatcher("problem.jsp");
			rd_add.forward(request, response);		
	    	System.out.println(username);
	    	break;
	    }
	}

		public void prepare_data(HttpServletRequest request, String user_id) {
			Vector<String[]> msg_id_list = DBUtil.getInstance().getData("user_message", new String[] { "message_id" },
					"user_id=" + user_id);
			List<Vector<String[]>> list = new ArrayList<Vector<String[]>>();
			for (String[] temp : msg_id_list) {
				String message_id = temp[0];
				Vector<String[]> vec = DBUtil.getInstance().getData("message",
						new String[] { "id", "username", "username_message","add_time","manager_message"},
						"id=" + message_id);			
				list.add(vec);
	 
			}
			request.setAttribute("data", list);
		}
		public void prepare_data(HttpServletRequest request, String user_id, String condition) {

			Vector<String[]> msg_id_list = DBUtil.getInstance().getData("user_message", new String[] { "message_id" },
					"user_id=" + user_id);
			List<Vector<String[]>> list = new ArrayList<Vector<String[]>>();
			Vector<String[]> vec = DBUtil.getInstance().getData("message",
					new String[] { "id", "username", "username_message","add_time","manager_message"},condition);		
			list.add(vec);
			request.setAttribute("data", list);
		}
	
	
	private void gotoPath(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}
