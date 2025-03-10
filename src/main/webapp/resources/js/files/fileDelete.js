
export default function fileDelete(){

const file_delete = document.querySelectorAll(".file-delete");

for(let f of file_delete){
    f.addEventListener('click',()=>{
        let check = confirm("정말 삭제하시겠습니까?")
        if(check){
            //DB에서 삭제 , HDD에서 삭제
            let num = f.getAttribute("data-file-num");
            let kind = f.getAttribute("data-kind");
            
            
            //돟기식 비동기식
            //'post'
            let url =`/${kind}/fileDelete`;
            ulr = './fileDelete';
            fetch(url,{
                method:'POST',
                headers:{
                    "Content-type":"application/x-www-form-urlencoded; charset=UTF-8"
                },
                body: `fileNum=${num}` // 'fileNum='+num
            })
            .then(r => r.text())
            .then(r => {
                if(r.trim()*1>0){
                    //1.파일갯수 count 수정 
                    // count--;
                    //2. Element 삭제
                    f.parentElement.remove()
                        

                }else{
                    alert('실패')
                }
            })
            .catch(e =>{
                alert('오류');
            })
        }


    })
}

}
