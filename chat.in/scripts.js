function run(){
}

function onSendButtonClick() {
    var msgField = document.getElementById('message-write-input');

    addMsg(msgField.value);
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
    var user = createNewUser(value);
    var users = document.getElementById('users');
    users.appendChild(user);

}

function createNewUser(value){
    var divItem = document.createElement('div');

    divItem.classList.add('usr');
    divItem.appendChild(document.createTextNode(value));
    //var close = document.createElement('img');
    //close.src = "images/edit.png";
    //divItem.appendChild(close);

    return divItem;
}

function addMsg(value){
    if(!value) {
        return;
    }

    var item = createItem(value);
    var messages = document.getElementById('messages');
    messages.appendChild(item);
}

function createItem(value){
    var divItem = document.createElement('div');

    divItem.classList.add('msg');
    divItem.appendChild(document.createTextNode(value));
    var close = document.createElement('img');
    close.src = "images/close.png";
    divItem.appendChild(close);

    return divItem;
}