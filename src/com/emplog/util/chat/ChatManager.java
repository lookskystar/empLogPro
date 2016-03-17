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
 * �����������
 * 
 * @author lhq
 * 
 */
public class ChatManager {

	/** ���浱ǰ�����û��б� */
	public static List<User> users = new ArrayList<User>();
	
	/**
	 * �����û�id���ָ���û���ҳ��ű�session
	 * 
	 * @param userid
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ScriptSession getScriptSession(String usersessionid,HttpServletRequest request) {
		//ÿˢ��ҳ��һ�ξʹ���һ���µ�
		ScriptSession scriptSessions = null;
		//��������ҳ������ScriptSession�ļ���
		Collection<ScriptSession> sessions = new HashSet<ScriptSession>();
	    //�������Ӹ�ҳ�������˵�scriptSessions��sessions������
		sessions.addAll(ServerContextFactory.get(request.getSession().getServletContext()).getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp"));
		//sessions����֮����ֵ
		//ѭ���������
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
	 * �õ��û������б�
	 
	public void updateUsersListbak(HttpServletRequest request) {
		
		// ���û�id��ҳ��ű�session��
		this.setScriptSessionFlag(request.getSession().getId());
		//���DWR������ WebContextFactory :���ڷ��ʵ�ǰ��������������Ϣ����װ��ǰ����url��ص���Ϣ����ServerContextFactory :���ڷ��ʵ�ǰ��webӦ����������Ϣ��dwr�ڲ���װ��ServerContext��
		ServletContext sc = request.getSession().getServletContext();
		ServerContext sctx = ServerContextFactory.get(sc);
		// ��õ�ǰ��� index.jsp ҳ������нű�session
		Collection<ScriptSession> sessions = sctx.getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp");
		Util util = new Util(sessions);
		// ������Щҳ���е�һЩԪ��
		util.removeAllOptions("users");
		util.addOptions("users", users, "username");
		
		// ����ǰ̨��addAllLiEvent JS�ű���Ϊҳ�����е�liԪ�ؼӵ���¼�
		util.addFunctionCall("addAllLiEvent");
	}
	*/
	/*
	 * ע���û�
	 
	public String registerbak(String username,HttpServletRequest request){
		//�ж��Ƿ�����ͬ��usersessionid����
		for (int i = 0; i < users.size(); i++) {
			//System.out.println("users usersessionid---->"+users.get(i).getUsersessionid());
			if (users.get(i).getUsersessionid().equals(request.getSession().getId())||username.equals(users.get(i).getUsername())) {
				//System.out.println("����ͬ�û������......");
				return "�벻�ظ���¼��";
			}
		}
		//System.out.println("username--->"+username);
		User user = null;
		// ����ȡ�Ự(HttpSession)��idΪ�û�id
		user = new User(null, request.getSession().getId(), username);
		// �����û����б�
		users.add(user);
		// ���û�id��ҳ��ű�session��
		this.setScriptSessionFlag(user.getUsersessionid());
		
		//���DWR������ WebContextFactory :���ڷ��ʵ�ǰ��������������Ϣ����װ��ǰ����url��ص���Ϣ����ServerContextFactory :���ڷ��ʵ�ǰ��webӦ����������Ϣ��dwr�ڲ���װ��ServerContext��
		ServletContext sc = request.getSession().getServletContext();
		ServerContext sctx = ServerContextFactory.get(sc);
		// ��õ�ǰ��� index.jsp ҳ������нű�session
		Collection<ScriptSession> sessions = sctx.getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp");
		Util util = new Util(sessions);
		// ������Щҳ���е�һЩԪ��
		util.removeAllOptions("users");
		util.addOptions("users", users, "username");
		
		//����ǰ̨��addAllLiEvent JS�ű���Ϊҳ�����е�liԪ�ؼӵ���¼�
		util.addFunctionCall("addAllLiEvent");
		
		return user.getUsersessionid() + ":" + user.getUsername();
	}
	*/
	
	//����flag�ж��Ƿ�ע�ỹ��ֻ��ʾ�����û�
	public String updateUsersList(String username, boolean flag, HttpServletRequest request) {
		
		User user = null;
		// ����ȡ�Ự(HttpSession)��idΪ�û�id
		user = new User(null, request.getSession().getId(), username);
		if (flag) {	
			// ����ȡ�Ự(HttpSession)��idΪ�û�id 
			
			//�����û����б�
			users.add(user);	
			//���û�id��ҳ��ű�session��
			this.setScriptSessionFlag(user.getUsersessionid());
		}
		//���DWR������
		ServletContext sc = request.getSession().getServletContext();
		ServerContext sctx = ServerContextFactory.get(sc);
		
		//��õ�ǰ��� index.jsp ҳ������нű�session
		Collection<ScriptSession> sessions = sctx.getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp");
		Util util = new Util(sessions);
		// ������Щҳ���е�һЩԪ��
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
		
		//����ǰ̨��addAllLiEvent JS�ű���Ϊҳ�����е�liԪ�ؼӵ���¼�
		util.addFunctionCall("addAllLiEvent");
		return user.getUsersessionid()+":"+user.getUsername();
	}
	
	
	
	
	
	/*
	 * ���ԣ�ҳ��رյ��ú�̨�¼���ɾ����������Ա
	 */

	public String deleteUsersList(String username, boolean flag,
			HttpServletRequest request) {
		User user = null;
		user = new User(null, request.getSession().getId(), username);

		if (flag) {
			// ����ȡ�Ự(HttpSession)��idΪ�û�id

			// �����û����б�
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
			// ���û�id��ҳ��ű�session��
			this.setScriptSessionFlag(user.getUsersessionid());
		}
		// ���DWR������
		ServletContext sc = request.getSession().getServletContext();
		ServerContext sctx = ServerContextFactory.get(sc);
		// ��õ�ǰ��� index.jsp ҳ������нű�session
		Collection<ScriptSession> sessions = sctx
				.getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp");

		Util util = new Util(sessions);
		// ������Щҳ���е�һЩԪ��
		util.removeAllOptions("users");
		util.addOptions("users", users, "username");
		util.removeAllOptions("receiver");
		util.addOptions("receiver", users, "useressionid", "username");
		return null;
	}

	
	/*
	 * ���ԣ�ɾ����������Ա,����Sprictsessionid
	*/
	public String deleteUsersByReceiver(String receiver,HttpServletRequest request) {
			//�����û����б�
			for (int i = 0; i < users.size(); i++) {
				
				if (receiver.equals(users.get(i).getUsersessionid())) {
					System.out.println("ɾ��....."+users.get(i).getUsersessionid());
					users.remove(i);
				}
			}	
			for (int i = 0; i < users.size(); i++) {
				System.out.println("1-->" + users.get(i).getUsersessionid() + ":"+ users.get(i).getUsername());
			}
			//���û�id��ҳ��ű�session��
			this.setScriptSessionFlag(request.getSession().getId());
			//���DWR������
			ServletContext sc = request.getSession().getServletContext();
			ServerContext sctx = ServerContextFactory.get(sc);
			//��õ�ǰ��� index.jsp ҳ������нű�session
			Collection<ScriptSession> sessions = sctx.getScriptSessionsByPage("/empLogssh2/web/chat/chat.jsp");
			Util util = new Util(sessions);
			//������Щҳ���е�һЩԪ��
			util.removeAllOptions("users");
			util.addOptions("users", users, "username");
			util.removeAllOptions("receiver");
			util.addOptions("receiver", users, "useressionid", "username");
			return null;
	}

	
	
	
	
	

	/**
	 * ���û�id��ҳ��ű�session��
	 * 
	 * @param userid
	 */
	public void setScriptSessionFlag(String usersessionid) {
		//System.out.println("setScriptSessionFlag----usersessionid--->"+usersessionid);
		WebContextFactory.get().getScriptSession()
				.setAttribute("usersessionid", usersessionid);
	}



	/**
	 * ������Ϣ
	 * 
	 * @param sender
	 *            ������
	 * @param receiverid
	 *            ������id
	 * @param msg
	 *            ��Ϣ����
	 * @param request
	 */
	public boolean send(String sender, String receiver, String msg,
			HttpServletRequest request) {
//		System.out.println("sender---->:" + sender);	
//		System.out.println("request.getSession().getId()--->:"+request.getSession().getId());
//		System.out.println("msg---->:" + msg);
		   try {
			   ScriptSession session = this.getScriptSession(receiver, request);
				// ����н����ߣ��ѽ����߷���ҳ���
				Util util = new Util(session);
				//System.out.println("receiverid---->:" + receiver);
				String context = "<strong style='color:red;'>" + sender + "</strong>--��--><strong style='color:blue;'>��</strong>˵��" + msg;
				util.addFunctionCall("addChatMsg", context, receiver);
				return true;
		} catch (Exception e) {
			deleteUsersByReceiver(receiver,request);
			return false;
		}
	}

	/*
	 * test ǰ̨��ʱ���̨���͵Ĳ���
	//
	// public String sessionId=null;
	// public String receiveLinkMsg(String sessionId){
	// //System.out.println("ÿ3���ӡ���..........."+sessionId);
	// this.sessionId=sessionId;
	// //��ʱִ�е������ڲ��ࣩ
	// TimerTask task = new TimerTask(){
	// @Override
	// public void run() {
	// //�ڴ˴����ڵ���Ҫִ������Ĵ��� ...
	// ChatManager chatManager=new ChatManager();
	// System.out.println("��̨��ӡÿһ����.....");
	//
	// }
	// };
	//
	//
	// // ����һ����ʱ��
	// Timer timer = new Timer();
	// // ���ô�ĳһʱ�̿�ʼִ�У�Ȼ��ÿ���೤ʱ���ظ�ִ��
	// // ���ô�30ʱ�俪ʼִ�У�Ȼ��ÿ�� 60����ִ��
	// timer.schedule(task, 5 * 1000, 60 * 1000);
	//
	// System.out.println("ÿ3���ӡ���..........."+sessionId);
	// if(sessionId==""){
	// System.out.println("Ҫɾ�������ˡ�����");
	// }
	//
	// return "ÿ3���ӡ���..........."+sessionId;
	// }
	*/
	
	// ͨ��usersessionId�õ�name
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
	
	//����name��
	public boolean findByName(String name) {

		for (int i = 0; i < users.size(); i++) {
			if (name.equals(users.get(i).getUsername())) {
				return true;
			}
		}
		return false;
	}
}
