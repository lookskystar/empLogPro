//Ext.BLANK_IMAGE_URL�ǿհ�ͼƬ��1x1px)�ĵ�ַ��Ĭ��Ϊhttp://extjs.com/blank.gif
//���������硣����һ�㶼�аɸ�ͼƬ���ص����������������硰pic���ļ����С�
Ext.BLANK_IMAGE_URL='pic/blank.gif';
var login=function(){ //����ҳ��Ĺ��ܺ���
	Ext.QuickTips.init(); //��ʼ��������ʾ�������齨�����Զ����й�����ʾ
	Ext.lib.Ajax.defaultPostHeader+= ";charset=UTF-8"; //��ʼ������ʱ�ı���
	//״̬�������������cookie��״̬����ʽ��Ҳ����һЩ״̬�����ݱ�����cookie��
	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
	//ʵ�־��幦��
};
Ext.onReady(login);  //��ExtJs�ļ���DOM�ĵ�����֮�������login����


var panel=new Ext.Panel({  //������壬�������ֵ�¼ҳ��
	renderTo:Ext.getBody(),   //��Ⱦ��ָ����loginPanelԪ����
	layout:'border',  //����border����
	width:525,    //ָ�����
	height:290,
	//������ÿ�����齨Ĭ�ϼ��ϱ߿�ͼƬ��4���ֲ���Ҫ�߿�ȡ���߿�
	defaults:{border:false},
	items:
	[
		{
			region:"north",  //����
			height:56,
			html:'<img src="pic/head.gif">'
	    },
	    {
	    	region:"south",  //�ײ�
			height:56,
			html:'<img src="pic/foot.gif">'
	    },
	    {
	    	region:"west",  //����
			height:253,
			html:'<img src="pic/left.gif">'
	    },
	    {
	    	region:"center",  //���ң����м䲿��
			height:253,
			html:'<img src="pic/left.gif">'
	    } 
	]
});

Ext.get('loginPanel').setStyle('position','absolute').center(Ext.getBody());