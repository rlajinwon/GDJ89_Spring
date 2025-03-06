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


    addCart.addEventListener("click", ()=>{
        let num = addCart.getAttribute("data-product-num")
        let s = `hello ${num}`
    
        fetch(`../users/addCart?productNum=${num}`)
        .then(res => res.text())
        .then(res => {
            console.log("서버 응답: ", res); 
            if(res.trim()=="1"){   //parseInt("1"), "1"+1
                let r = confirm("장바구니로 이동??")
                if(r){
                    location.href='../users/carts';
                }
            }else {
                alert('장바구니 등록 실패')
            }
        }).catch(r=>{
            alert('장바구니 등록 실패')
        })
    })


// cart 테이블 선택된거 insert 후 conform 메시지 띄우기 

