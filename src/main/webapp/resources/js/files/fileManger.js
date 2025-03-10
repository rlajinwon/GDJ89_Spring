// import fileDelete from "/resources/js/files/fileDelete.js";

const add = document.getElementById("add");
const files = document.getElementById("files");
const del = document.getElementsByClassName("del");

let count = files.getAttribute("data-files-size")


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
            url = './fileDelete';
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




files.addEventListener('click',function(e){
    if(e.target.classList.contains('del')){
        e.target.parentElement.remove();
        count--;
        
    }
})




add.addEventListener("click",function(){

    if(count > 5){
        alert('파일은 5개 까지');
        return;
    }
    
    //----부모 
    let div = document.createElement("div");


    //--------label 추가
    let label = document.createElement("label");
    let attr = document.createAttribute("class");

    attr.value="form-label";

    label.setAttributeNode(attr);


    attr = document.createAttribute("for")
    attr.value = "attach"+count

    label.setAttributeNode(attr);




    div.append(label);

    //----- input 추가
    label =document.createElement("input");
    attr = document.createAttribute("type");
    attr.value = "file";
    label.setAttributeNode(attr);

    attr = document.createAttribute("class");

    attr.value ="form-control";
    label.setAttributeNode(attr);

    attr = document.createAttribute("name")
    attr.value="attaches";
    label.setAttributeNode(attr);
    
    attr = document.createAttribute("id");
    attr.value="attach" + count; 

    label.setAttributeNode(attr);


    div.append(label);


//---button 추가

    label = document.createElement("button");
    label.innerText = 'X';

    label.type="button";



    
    label.classList.add('btn','btn-outline-danger','del')
    div.append(label)

    files.append(div);



    count ++;


})



