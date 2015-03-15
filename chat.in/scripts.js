
var username = null;
var messagesList = [];

function run(){

    var allMessages = restore();
    createAllMessages(allMessages);
}

function createAllMessages(allMessages){
    for(var i = 0; i < allMessages.length; i++)
        addMsg(allMessages[i]);
}

function messageCreature(user, text){
    return{
        user: user,
        text: text,
        id: createId()
    };
}

function onSendButtonClick() {
    var msgField = document.getElementById('message-write-input');

    if(!window.username){
        alert("You must be logged in!");
        return;
    }

    if(!msgField.value)
    return;

    var message = messageCreature(username, msgField.value);
    addMsg(message);
}

function onSignInButtonClick(){
    var loginField = document.getElementById('login-input');

    logUserIn(loginField.value);
}

function logUserIn(value){
    if(!value) {
        alert("Input username!");
        return;
    }
    if(window.username){
        changeUserName(value);
        return;
    }
    window.username = value;
    var user = createNewUser(value);
    var users = document.getElementById('users');

    users.appendChild(user);

}

function changeUserName(name){
    var currentUserName = document.getElementById('yourName');
    currentUserName.textContent.replace((window.username).toString(), name);
}

function createNewUser(value){
    var divItem = document.createElement('div');

    divItem.classList.add('usr');
    divItem.setAttribute('id', 'yourName');
    divItem.appendChild(document.createTextNode(value));
    //var close = document.createElement('img');
    //close.src = "images/edit.png";
    //divItem.appendChild(close);

    return divItem;
}

function addMsg(message){

    messagesList.push(message);
    var item = createItem(message);
    var messages = document.getElementById('messages');
    messages.appendChild(item);

    store(messagesList);
}

function createId(){
    var id = Math.random();
    id *= Date.now();
    id = Math.floor(id);
    return id;
}

function createItem(msgStruct){
    var divItem = document.createElement('div');
    divItem.classList.add('msg');
    divItem.setAttribute('id', msgStruct.id.toString());
    var userNameSpan = divItem.appendChild(document.createElement('span'));
    userNameSpan.appendChild(document.createTextNode(msgStruct.user.toString() + ': '));
    divItem.appendChild(userNameSpan);
    divItem.appendChild(document.createTextNode(msgStruct.text));
    var close = document.createElement('img');
    close.src = "images/close.png";
    close.setAttribute("id", "remove-button");
    close.setAttribute("onclick", "removeMsg(this)");
    divItem.appendChild(close);
    return divItem;

}

function removeMsg(item){
    var parentItem = item.parentNode;
    (parentItem.parentNode).removeChild(parentItem);
    return;
}

function store(listToSave) {

    if(typeof(Storage) == "undefined") {
        alert('localStorage is not accessible');
        return;
    }

    localStorage.setItem("80Chat messages", JSON.stringify(listToSave));
}

function restore() {
    if(typeof(Storage) == "undefined") {
        alert('localStorage is not accessible');
        return;
    }

    var item = localStorage.getItem("80Chat messages");

    return item && JSON.parse(item);
}