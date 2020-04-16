//package cn.edu.hziee.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.Map;
//import java.util.Vector;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.alibaba.fastjson.JSON;
//
//import cn.edu.hziee.util.DBUtil;
//import cn.edu.hziee.util.Fn;
//import cn.edu.hziee.model.Message;
//
//public class MessageServlet extends HttpServlet {
//
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String uri = request.getRequestURI();
//		String flag = uri.substring(uri.lastIndexOf('/') + 1, uri.lastIndexOf('.'));
//		switch (flag) {
//			case "add":
//				// 添加留言
//				RequestDispatcher rd = request.getRequestDispatcher("/add.jsp");
//				rd.forward(request, response);
//				break;
//		}
//	}
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		String id = request.getParameter("id");
//		String username = Fn.GBK(request.getParameter("username"));
//		String username_message = Fn.GBK(request.getParameter("username_message"));
////		String add_time = Fn.GBK(request.)
//		DBUtil.getInstance().modifyData("message", new String[] { "username", "username_message" },
//				new String[] { username, username_message }, "id=" + id);
////		String manager_message = Fn.GBK(request.getParameter("manager_message"));
//		
//		
////		DBUtil du = new DBUtil();
////		String tableName = "message";
////		String[] field = new String[]{"username","username_message","add_time"};
////		String[] value = new String[]{username,username_message,add_time+""};
////		du.insertData(tableName, field, value);
////		
//////		List<String> list = new ArrayList<String>();
//////		list.add(Fn.GBK(username));
//////		list.add(Fn.GBK(username_message));
//////		list.add(Fn.date(add_time));
////////		String json = JSON.toJSONString(list);
//////		out.println(list);
//////		request.setAttribute("list", list);
////
//////		System.out.println(list);
//
//		Hashtable<String, String> map = DBUtil.getInstance().execSQL("message", "max(id) as maxid", "1=1");
//		String message_id = map.get("maxid");
//
//		Object userId = request.getSession().getAttribute("user_id");
//		String userId1 = String.valueOf(userId);
//		DBUtil.getInstance().insertData("user_message", new String[] { "user_id", "message_id" },
//				new String[] { userId1 + "", message_id });
//		prepare_data(request, userId1);
//	}
//	
//
//	public void prepare_data(HttpServletRequest request, String user_id) {
//		Vector<String[]> msg_id_list = DBUtil.getInstance().getData("user_message", new String[] { "message_id" },
//				"user_id=" + user_id);
//		List<Vector<String[]>> list = new ArrayList<Vector<String[]>>();
//		for (String[] temp : msg_id_list) {
//			String message_id = temp[0];
//			Vector<String[]> vec = DBUtil.getInstance().getData("message",
//					new String[] { "id", "username", "username_message","add_time","manager_message"},
//					"id=" + message_id);			
//			list.add(vec);
// 
//		}
//		request.setAttribute("data", list);
//	}
//	public void prepare_data(HttpServletRequest request, String user_id, String condition) {
//
//		Vector<String[]> msg_id_list = DBUtil.getInstance().getData("user_resume", new String[] { "message_id" },
//				"user_id=" + user_id);
//		List<Vector<String[]>> list = new ArrayList<Vector<String[]>>();
//		Vector<String[]> vec = DBUtil.getInstance().getData("resume",
//				new String[] { "id", "username", "username_message","add_time","manager_message"},condition);		
//		list.add(vec);
//		request.setAttribute("data", list);
//	}
//}
