/**
 * 
 */



const btn1 = document.getElementById("btn1");

const userName = document.getElementById("userName");

const passWord = document.getElementById("passWord");





btn1.addEventListener("click",function(){
    console.log("oo");

    if(userName.value.length == 0){
        alert("id입력은 필수");
        userName.focus();

        return;
    }

    if(passWord.value.length==0){
        alert("pw입력은 필수");
        passWord.focus();

        return;
    }

    document.getElementById("login_form").submit();

    

})