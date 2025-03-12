// 수정 버튼을 클릭 했을 때 콘솔에 출력
// form에 method의 값을 콘솔에 출력 
//삭제 버튼을 클릭 했을 때 콘솔에 출력
//form action의 주소값을 콘솔에 출력

const btn1 = document.getElementById("btn1");
const btn2 = document.getElementById("btn2");
const frm = document.getElementById("frm");
const btn3 = document.getElementById("btn3");
const addCart = document.getElementById("addCart");
const btn_add = document.getElementById("btn_add");
const commentsListResult = document.getElementById("commentsListResult");
const pages = document.getElementsByClassName("pages");
const commentDelete = document.querySelectorAll(".commentDelete");
// modal_change 추가 




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






//-----------------------------------등록버튼




btn_add.addEventListener("click", function() {

    console.log(comment_input.value);

    console.log(addCart.getAttribute("data-product-num"));
    
    addComments();
 


});

function makeForm(pn,contents){
    let f =new FormData();
    f.append("productNum", pn);
    f.append("boardContents",contents);
    return f;
}
function makeParam(pn, contents){

    let p = new URLSearchParams();
    p.append("productNum", pn);
    p.append("boardContents", contents)

    return p;
}

    getList();

function getList(){
    let pn = addCart.getAttribute("data-product-num");
    fetch(`getCommentsList?productNum=${pn}`)
    .then(r => r.text())
    .then(r =>{
        commentsListResult.innerHTML=r;

    })
    .catch(e=> console.log(e))

    
}







// Enter 키 이벤트
function handleEnterKey(event) {
    if (event.key === "Enter") {
        event.preventDefault(); // 기본 폼 제출 방지
        btn_add.click(); //  버튼 클릭
    }
}

// userName 필드에서 엔터키 눌렀을 때
comment_input.addEventListener("keydown", handleEnterKey);





function addComments(){

    let pn = addCart.getAttribute("data-product-num");

    let p = makeForm(pn, comment_input.value)
    



    fetch('./commentAdd', {
        method:'POST',
        // headers:{
        //     "Content-type":"application/x-www-form-urlencoded; charset=UTF-8"
        // },
        // body:"productNum="+addCart.getAttribute("data-product-num")
        body:p
    }).then(r=>r.text())
    .then(r=>{
        getList();
        if(r.trim()*1>0){

        }else{

        }
        
    })
    .catch(e=>{
        alert("에러 발생")
    })



}


//Delete
//바닐라 스크립트? 
commentsListResult.addEventListener('click',async(e)=>{
    if(e.target.classList.contains('commentDelete')){
        let p = e.target.getAttribute("data-page-num");
        
        let f = new FormData();
        f.append("boardNum", p)

        await fetch("./commentDelete",{
            method:"POST",
            body:f
        })
        .then(r=> r.text())
        .then(r=>{
            if(r.trim()*1>0){
                alert('삭제성공')
            }else{
                alert('삭제 실패')
            }
        })
        
        .catch(e=>{
            alert('오류입니다')
        })
        
    }
    getList(1)

})


//update
commentsListResult.addEventListener('click', async (e)=>{
    if(e.target.classList.contains("commentUpdate")){
        let ud = e.target; //button
        let ud_s = ud.parentElement.previousElementSibling.previousElementSibling;
    
        let c = ud_s.innerHTML;
        // ud_s.innerHTML="<textarea></textarea>";

        prompt("입력")

        // document.getElementById('message-text').value=c;
        // c=ud.getAttribute("data-update-boardNum") 더 작성


    }

})





// modal_change
//매퍼-DAO
//
// modal_change.addEventListener('click',()=>{
// let m =document.getElementById('message-text').value

// let f =new FormData();
// f.append("boardContents",m)

// fetch('./commentUpdate',{
//     method:'POST',

// })

// })














// for(let f of file_delete){
//     f.addEventListener('click',()=>{
//         let check = confirm("정말 삭제하시겠습니까?")
//         if(check){
//             //DB에서 삭제 , HDD에서 삭제
//             let num = f.getAttribute("data-file-num");
//             let kind = f.getAttribute("data-kind");
            
            
//             //돟기식 비동기식
        
//             let url =`/${kind}/commentDelete`;
//             url = './commentDelete';
//             fetch(url,{
//                 method:'POST',
//                 headers:{
//                     "Content-type":"application/x-www-form-urlencoded; charset=UTF-8"
//                 },
//                 body: `fileNum=${num}` // 'fileNum='+num
//             })
//             .then(r => r.text())
//             .then(r => {
//                 if(r.trim()*1>0){
//                     //1.파일갯수 count 수정 
//                     // count--;
//                     //2. Element 삭제
//                     f.parentElement.remove()
                        

//                 }else{
//                     alert('실패')
//                 }
//             })
//             .catch(e =>{
//                 alert('오류');
//             })
//         }


//     })
// }   