/**  
 * ע���ʺ�  
 */  
function register(button) {   
	alert(11);
    if ($('username').value == "" || $('username').value.length <= 0) {   
        alert("�������ǳ�");   
        return;   
    }   
  
    /* �����Ƕ�һЩ��ť�Ľ��úͼ������ */  
    $('username').disabled = true;   
    button.disabled = true;   
    $('message').disabled = false;   
    $('send').disabled = false;   
    $('receiver').disabled = false;   
  
    /* ����������û���ע�ᵽ������,������û�id(������session id ����) */  
    ChatManager.updateUsersList($('username').value, true, function(data) {   
        if (data != null && data.length > 0) {   
            $('userid').value = data; // ע��ɹ�,��userid�ŵ���ǰҳ��   
        }   
    });   
}   
  
/**  
 * ҳ���ʼ��  
  
function init() {   
    dwr.engine.setActiveReverseAjax(true); // ���ת ��Ҫ   
    ChatManager.updateUsersList(null, false); // ����򿪽����ʱ��,�Ȼ�������û��б�.   
}   
 */  
/**  
 * ������Ϣ  
  
function send() {   
    var sender = dwr.util.getValue('username'); // ��÷���������   
    var receiver = dwr.util.getValue('receiver'); // ��ý�����id   
    var msg = dwr.util.getValue('message'); // �����Ϣ����   
    ChatManager.send(sender, receiver, msg); // ������Ϣ   
}   
  
window.onload = init;//ҳ�������Ϻ�ִ�г�ʼ������init  
 */