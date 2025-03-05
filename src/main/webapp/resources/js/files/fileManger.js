const add = document.getElementById("add");
const files = document.getElementById("files");
const del = document.getElementsByClassName("del");

let count = files.getAttribute("data-files-size")

count++;

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



