package com.emplog.util.chat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

/**
 * 处理聊天相关
 * 
 * @author lhq
 * 
 */
public class ChatManager {

	/** 保存当前在线用户列表 */
	public static List<User> users = new ArrayList<User>();
	
	/**
	 * 根据用户id获得指定用户的页面脚本session
	 * 
	 * @param userid
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ScriptSession getScriptSession(String usersessionid,HttpServletRequest request) {
		//每刷新页面一次就创建一个新的
		ScriptSession scriptSessions = null;
		//存在连接页面所有ScriptSession的集合
		Collection<ScriptSession> sessions = new HashSet<ScriptSession>();
	    //加载连接该页面所有人的scriptSessions到sessions集合中
		sessions.addAll(ServerContextFactory.get(request.getSession().getServletContext()).getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp"));
		//sessions在这之后有值
		//循环这个集合
		for (ScriptSession session : sessions) {
			String xusersessionid = (String) session.getAttribute("usersessionid");
			if (xusersessionid != null && xusersessionid.equals(usersessionid)) {
				//scriptSessions.removeAttribute(usersessionid);
				scriptSessions = session;
				//System.out.println(scriptSessions.getAttribute("usersessionid"));
			}
		}
		return scriptSessions;
	}
	
	
	/*
	 * 得到用户在线列表
	 
	public void updateUsersListbak(HttpServletRequest request) {
		
		// 将用户id和页面脚本session绑定
		this.setScriptSessionFlag(request.getSession().getId());
		//获得DWR上下文 WebContextFactory :用于访问当前的请求上下文信息（封装当前请求url相关的信息）。ServerContextFactory :用于访问当前的web应用上下文信息（dwr内部封装的ServerContext）
		ServletContext sc = request.getSession().getServletContext();
		ServerContext sctx = ServerContextFactory.get(sc);
		// 获得当前浏览 index.jsp 页面的所有脚本session
		Collection<ScriptSession> sessions = sctx.getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp");
		Util util = new Util(sessions);
		// 处理这些页面中的一些元素
		util.removeAllOptions("users");
		util.addOptions("users", users, "username");
		
		// 调用前台的addAllLiEvent JS脚本，为页面所有的li元素加点击事件
		util.addFunctionCall("addAllLiEvent");
	}
	*/
	/*
	 * 注册用户
	 
	public String registerbak(String username,HttpServletRequest request){
		//判断是否有相同的usersessionid登入
		for (int i = 0; i < users.size(); i++) {
			//System.out.println("users usersessionid---->"+users.get(i).getUsersessionid());
			if (users.get(i).getUsersessionid().equals(request.getSession().getId())||username.equals(users.get(i).getUsername())) {
				//System.out.println("有相同用户的添加......");
				return "请不重复登录！";
			}
		}
		//System.out.println("username--->"+username);
		User user = null;
		// 这里取会话(HttpSession)的id为用户id
		user = new User(null, request.getSession().getId(), username);
		// 保存用户到列表
		users.add(user);
		// 将用户id和页面脚本session绑定
		this.setScriptSessionFlag(user.getUsersessionid());
		
		//获得DWR上下文 WebContextFactory :用于访问当前的请求上下文信息（封装当前请求url相关的信息）。ServerContextFactory :用于访问当前的web应用上下文信息（dwr内部封装的ServerContext）
		ServletContext sc = request.getSession().getServletContext();
		ServerContext sctx = ServerContextFactory.get(sc);
		// 获得当前浏览 index.jsp 页面的所有脚本session
		Collection<ScriptSession> sessions = sctx.getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp");
		Util util = new Util(sessions);
		// 处理这些页面中的一些元素
		util.removeAllOptions("users");
		util.addOptions("users", users, "username");
		
		//调用前台的addAllLiEvent JS脚本，为页面所有的li元素加点击事件
		util.addFunctionCall("addAllLiEvent");
		
		return user.getUsersessionid() + ":" + user.getUsername();
	}
	*/
	
	//根据flag判断是否注册还是只显示在线用户
	public String updateUsersList(String username, boolean flag, HttpServletRequest request) {
		
		User user = null;
		// 这里取会话(HttpSession)的id为用户id
		user = new User(null, request.getSession().getId(), username);
		if (flag) {	
			// 这里取会话(HttpSession)的id为用户id 
			
			//保存用户到列表
			users.add(user);	
			//将用户id和页面脚本session绑定
			this.setScriptSessionFlag(user.getUsersessionid());
		}
		//获得DWR上下文
		ServletContext sc = request.getSession().getServletContext();
		ServerContext sctx = ServerContextFactory.get(sc);
		
		//获得当前浏览 index.jsp 页面的所有脚本session
		Collection<ScriptSession> sessions = sctx.getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp");
		Util util = new Util(sessions);
		// 处理这些页面中的一些元素
		util.removeAllOptions("users");
		util.addOptions("users", users, "username");
		
		
		if(!flag){
			for (int i = 0; i < users.size(); i++) {
				if(users.get(i).getUsersessionid()==request.getSession().getId()){
					user.setUsername(users.get(i).getUsername());
					this.setScriptSessionFlag(user.getUsersessionid());
				}
			}
		}
		
		//调用前台的addAllLiEvent JS脚本，为页面所有的li元素加点击事件
		util.addFunctionCall("addAllLiEvent");
		return user.getUsersessionid()+":"+user.getUsername();
	}
	
	
	
	
	
	/*
	 * 测试，页面关闭调用后台事件，删除此在线人员
	 */

	public String deleteUsersList(String username, boolean flag,
			HttpServletRequest request) {
		User user = null;
		user = new User(null, request.getSession().getId(), username);

		if (flag) {
			// 这里取会话(HttpSession)的id为用户id

			// 保存用户到列表
			for (int i = 0; i < users.size(); i++) {
//				System.out.println("1-->" + users.get(i).getUserid() + ":"
//						+ users.get(i).getUsername());
				if (users.get(i).getUsersessionid() == request.getSession()
						.getId()) {
					users.remove(i);
				}
			}
//			for (int i = 0; i < users.size(); i++) {
//				System.out.println("2-->" + users.get(i).getUsersessionid()
//						+ ":" + users.get(i).getUsername());
//			}
			// 将用户id和页面脚本session绑定
			this.setScriptSessionFlag(user.getUsersessionid());
		}
		// 获得DWR上下文
		ServletContext sc = request.getSession().getServletContext();
		ServerContext sctx = ServerContextFactory.get(sc);
		// 获得当前浏览 index.jsp 页面的所有脚本session
		Collection<ScriptSession> sessions = sctx
				.getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp");

		Util util = new Util(sessions);
		// 处理这些页面中的一些元素
		util.removeAllOptions("users");
		util.addOptions("users", users, "username");
		util.removeAllOptions("receiver");
		util.addOptions("receiver", users, "useressionid", "username");
		return null;
	}

	
	/*
	 * 测试，删除此在线人员,根据Sprictsessionid
	*/
	public String deleteUsersByReceiver(String receiver,HttpServletRequest request) {
			//保存用户到列表
			for (int i = 0; i < users.size(); i++) {
				
				if (receiver.equals(users.get(i).getUsersessionid())) {
					System.out.println("删除....."+users.get(i).getUsersessionid());
					users.remove(i);
				}
			}	
			for (int i = 0; i < users.size(); i++) {
				System.out.println("1-->" + users.get(i).getUsersessionid() + ":"+ users.get(i).getUsername());
			}
			//将用户id和页面脚本session绑定
			this.setScriptSessionFlag(request.getSession().getId());
			//获得DWR上下文
			ServletContext sc = request.getSession().getServletContext();
			ServerContext sctx = ServerContextFactory.get(sc);
			//获得当前浏览 index.jsp 页面的所有脚本session
			Collection<ScriptSession> sessions = sctx.getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp");
			Util util = new Util(sessions);
			//处理这些页面中的一些元素
			util.removeAllOptions("users");
			util.addOptions("users", users, "username");
			util.removeAllOptions("receiver");
			util.addOptions("receiver", users, "useressionid", "username");
			return null;
	}

	
	
	
	
	

	/**
	 * 将用户id和页面脚本session绑定
	 * 
	 * @param userid
	 */
	public void setScriptSessionFlag(String usersessionid) {
		//System.out.println("setScriptSessionFlag----usersessionid--->"+usersessionid);
		WebContextFactory.get().getScriptSession()
				.setAttribute("usersessionid", usersessionid);
	}



	/**
	 * 发送消息
	 * 
	 * @param sender
	 *            发送者
	 * @param receiverid
	 *            接收者id
	 * @param msg
	 *            消息内容
	 * @param request
	 */
	public boolean send(String sender, String receiver, String msg,
			HttpServletRequest request) {
//		System.out.println("sender---->:" + sender);	
//		System.out.println("request.getSession().getId()--->:"+request.getSession().getId());
//		System.out.println("msg---->:" + msg);
		   try {
			   ScriptSession session = this.getScriptSession(receiver, request);
				// 如果有接收者，把接受者放入页面的
				Util util = new Util(session);
				//System.out.println("receiverid---->:" + receiver);
				String context = "<strong style='color:red;'>" + sender + "</strong>--对--><strong style='color:blue;'>你</strong>说：" + msg;
				util.addFunctionCall("addChatMsg", context, receiver);
				return true;
		} catch (Exception e) {
			deleteUsersByReceiver(receiver,request);
			return false;
		}
	}

	/*
	 * test 前台定时想后台发送的测试
	//
	// public String sessionId=null;
	// public String receiveLinkMsg(String sessionId){
	// //System.out.println("每3秒打印这个..........."+sessionId);
	// this.sessionId=sessionId;
	// //定时执行的任务（内部类）
	// TimerTask task = new TimerTask(){
	// @Override
	// public void run() {
	// //在此代码内调用要执行任务的代码 ...
	// ChatManager chatManager=new ChatManager();
	// System.out.println("后台打印每一分钟.....");
	//
	// }
	// };
	//
	//
	// // 创建一个定时器
	// Timer timer = new Timer();
	// // 设置从某一时刻开始执行，然后每隔多长时间重复执行
	// // 设置从30时间开始执行，然后每个 60秒中执行
	// timer.schedule(task, 5 * 1000, 60 * 1000);
	//
	// System.out.println("每3秒打印这个..........."+sessionId);
	// if(sessionId==""){
	// System.out.println("要删除数据了。。。");
	// }
	//
	// return "每3秒打印这个..........."+sessionId;
	// }
	*/
	
	// 通过usersessionId得到name
	public String getUserSessionIdByName(String name) {
		String usersessionid = null;
		for (int i = 0; i < users.size(); i++) {
			if (name.equals(users.get(i).getUsername())) {
				usersessionid = users.get(i).getUsersessionid();
			}
		}
		//System.out.println("usersessionid---->"+usersessionid);
		return usersessionid;
	}
	
	//根据name找
	public boolean findByName(String name) {

		for (int i = 0; i < users.size(); i++) {
			if (name.equals(users.get(i).getUsername())) {
				return true;
			}
		}
		return false;
	}
}
