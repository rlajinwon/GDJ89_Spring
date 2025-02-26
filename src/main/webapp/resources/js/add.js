
const productName = document.getElementById("productName");
const productRate = document.getElementById("productRate");
const productDate = document.getElementById("productDate");

const product_btn = document.getElementById("product_btn");

product_btn.addEventListener("click",function(){

    if(productName.value==""){
        alert("상품명 입력 필수");
        productName.focus();

        return;
    }
    if(productRate.value==""){
        alert("이자율 입력 필수");
        productRate.focus();

        return;

    }
    if(productDate.value==""){
        alert("만기일 입력 필수");
        productDate.focus();

        return;
    }
    document.getElementById("product_add").submit();

    

})
