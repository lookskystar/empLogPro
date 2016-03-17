调用方法：
1、在调用的类中注入StartMailSender（在类中封装set方法，在applicationContext.xml中配置）
如：
///调用类中配置
private StartMailSender startMailSender;
	public StartMailSender getStartMailSender() {
		return startMailSender;
	}
	public void setStartMailSender(StartMailSender startMailSender) {
		this.startMailSender = startMailSender;
	}
	
	
	
	
	/////////////////////////////applicationContext.xml
		<!-- 通过empName和empPassword查找emp基本信息（员工登陆验证）--> 
		<bean id="findEmpByEmpNameAndEmpPasswordAction" class="com.emplog.action.emp.FindEmpByEmpNameAndEmpPasswordAction">
			<property name="service" ref="empService"></property>
			<!-- 测试多线程发送邮件-->
	     	 <property name="startMailSender" ref="startMailSender" />
			
		</bean>