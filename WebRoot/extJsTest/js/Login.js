//Ext.BLANK_IMAGE_URL是空白图片（1x1px)的地址，默认为http://extjs.com/blank.gif
//这依赖网络。我们一般都市吧该图片下载到本地来，这里存放早“pic”文件夹中。
Ext.BLANK_IMAGE_URL='pic/blank.gif';
var login=function(){ //登入页面的功能函数
	Ext.QuickTips.init(); //初始化工具提示，这样组建就能自动进行工具提示
	Ext.lib.Ajax.defaultPostHeader+= ";charset=UTF-8"; //初始化传输时的编码
	//状态管理，这里采用了cookie的状态管理方式，也就是一些状态的数据保存在cookie中
	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
	//实现具体功能
};
Ext.onReady(login);  //在ExtJs文件或DOM文档载入之后才运行login函数


var panel=new Ext.Panel({  //定义面板，用来布局登录页面
	renderTo:Ext.getBody(),   //渲染到指定的loginPanel元素中
	layout:'border',  //采用border布局
	width:525,    //指定宽高
	height:290,
	//容器中每个子组建默认加上边框，图片中4部分不需要边框，取消边框
	defaults:{border:false},
	items:
	[
		{
			region:"north",  //顶部
			height:56,
			html:'<img src="pic/head.gif">'
	    },
	    {
	    	region:"south",  //底部
			height:56,
			html:'<img src="pic/foot.gif">'
	    },
	    {
	    	region:"west",  //中左
			height:253,
			html:'<img src="pic/left.gif">'
	    },
	    {
	    	region:"center",  //中右，即中间部分
			height:253,
			html:'<img src="pic/left.gif">'
	    } 
	]
});

Ext.get('loginPanel').setStyle('position','absolute').center(Ext.getBody());