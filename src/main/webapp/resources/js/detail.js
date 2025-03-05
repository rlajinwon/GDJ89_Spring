// 수정 버튼을 클릭 했을 때 콘솔에 출력
// form에 method의 값을 콘솔에 출력 
//삭제 버튼을 클릭 했을 때 콘솔에 출력
//form action의 주소값을 콘솔에 출력

const btn1 = document.getElementById("btn1");
const btn2 = document.getElementById("btn2");
const frm = document.getElementById("frm");
const btn3 = document.getElementById("btn3");
const addCart = document.getElementById("addCart");



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



// try {
//     btn3.addEventListener("click",function(){
//         frm.action="./reply";
//         frm.submit();
    
//     })
    
// } catch (error) {
    
// }


addCart.addEventListener("click",()=>{
    let num = addCart.getAttribute("data-product-num")
    let s =`hello ${num}`

    console.log(num)
    fetch(`../users/addCart?productNum=${num}`)
    .then(res => res.text())
    .then(res => {
        if(res.trim()==="성공"){
            if(confirm("장바구니에 추가되었습니다 이동하시겠습니까?")){
                location.href ="../user/carts"
            }
        }else{
            alert("장바구니 추가에 실패하였습니다")
        }
        
    })
});


// cart 테이블 선택된거 insert 후 conform 메시지 띄우기 

