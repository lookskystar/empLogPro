���÷�����
1���ڵ��õ�����ע��StartMailSender�������з�װset��������applicationContext.xml�����ã�
�磺
///������������
private StartMailSender startMailSender;
	public StartMailSender getStartMailSender() {
		return startMailSender;
	}
	public void setStartMailSender(StartMailSender startMailSender) {
		this.startMailSender = startMailSender;
	}
	
	
	
	
	/////////////////////////////applicationContext.xml
		<!-- ͨ��empName��empPassword����emp������Ϣ��Ա����½��֤��--> 
		<bean id="findEmpByEmpNameAndEmpPasswordAction" class="com.emplog.action.emp.FindEmpByEmpNameAndEmpPasswordAction">
			<property name="service" ref="empService"></property>
			<!-- ���Զ��̷߳����ʼ�-->
	     	 <property name="startMailSender" ref="startMailSender" />
			
		</bean>