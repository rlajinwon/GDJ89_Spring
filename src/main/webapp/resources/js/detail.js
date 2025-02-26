// 수정 버튼을 클릭 했을 때 콘솔에 출력
// form에 method의 값을 콘솔에 출력 
//삭제 버튼을 클릭 했을 때 콘솔에 출력
//form action의 주소값을 콘솔에 출력

const btn1 = document.getElementById("btn1");
const btn2 = document.getElementById("btn2");
const frm = document.getElementById("frm");
const btn3 = document.getElementById("btn3");


btn1.addEventListener("click",function(){
    console.log(frm.method); //get
    console.log(frm.getAttribute("method")); //null
    frm.action = "./update";
    console.log("수정")
    frm.submit();
});

btn2.addEventListener("click",function(){
    console.log(frm.action); //url
    console.log(frm.getAttribute("action")); //uri
    console.log("삭제");
    frm.action="./delete";
    frm.method = "POST";


    if(confirm("삭제한다?")){
        frm.submit();
    }else{

    }

});

btn3.addEventListener("click", function(){

    console.log("댓글");
    frm.action="/qna/add";
    frm.submit();
})
