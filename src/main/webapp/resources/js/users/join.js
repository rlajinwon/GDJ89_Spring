

const id = document.getElementById("id");
const userNameResult = document.getElementById("userNameResult");


id.addEventListener('change',()=>{
    
    console.log(id.value);

    fetch("./check?userName="+id.value)
    .then(res =>res.text())
    .then(res =>{
        if(res.trim()==0){
            userNameResult.innerHTML='중복된 id입니다'


        }else{
            //가입 O 
            userNameResult.innerHTML='사용 가능한 id입니다'

        }
    })


})

