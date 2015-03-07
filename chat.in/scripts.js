function run(){
    var chatContainer = document.getElementById('send-button');

    chatContainer.addEventListener('buttonClick', delegateEvent);
}

function delegateEvent(evtObj) {
    if(evtObj.type == 'buttonClick' && evtObj.target.classList.contains('btn-send')) {
        onSendButtonClick(evtObj);
    }
}

function onSendButtonClick(){
    var messageText = document.getElementById('message-write-input');
    sendMessage(messageText);

}

function sendMessage(value) {
    if (!value) {
        return;
    }

    var msg = createMessage(value);
    var messages = document.getElementById('messages');

    messages.appendChild(msg);
}

function createMessage(text){
    var divMsg = document.createElement('div');

    divMsg.classList.add('msg');
    divMsg.appendChild(document.createTextNode(text));
}
