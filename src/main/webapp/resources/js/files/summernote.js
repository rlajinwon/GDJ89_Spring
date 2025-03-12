
	$('#detail').summernote({
        height:400,
        callbacks:{
            onImageUpload:function(files){
                console.log(files[0]);//<input type="file">
                let f = new FormData(); // 파라미터 전송 
                f.append("uploadFile", files[0]);
                


                fetch('./detailFiles',{
                    method:'POST',
                    body:f  //파라미터 전송
                })
                .then(r=>r.text())
                .then(r=>{
                    $('#detail').summernote('editor.insertImage', r.trim());
                })

            }

        }
	})


