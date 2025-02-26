
const pages = document.getElementsByClassName("pages");
const list_form = document.getElementById("list_form");
const pageNum = document.getElementById("pageNum");




for(let page of pages){
    page.addEventListener("click",function(){

        //data-page-num
        // console.log(page.data-page-num);

        console.log(page.getAttribute("data-page-num"));
        pageNum.value = page.getAttribute("data-page-num");



        

         list_form.submit();

    })
}




