const btn1 = document.getElementById("btn1");
const userName = document.getElementById("userName");
const passWord = document.getElementById("passWord");
const loginForm = document.getElementById("login_form");

// 로그인 버튼 클릭 이벤트
btn1.addEventListener("click", function () {
    console.log("로그인 버튼 클릭");

    if (userName.value.trim().length === 0) {
        alert("ID 입력은 필수입니다.");
        userName.focus();
        return;
    }

    if (passWord.value.trim().length === 0) {
        alert("PW 입력은 필수입니다.");
        passWord.focus();
        return;
    }

    loginForm.submit();
});

// Enter 키 이벤트 (아이디와 비밀번호 필드에서 모두 처리)
function handleEnterKey(event) {
    if (event.key === "Enter") {
        event.preventDefault(); // 기본 폼 제출 방지
        btn1.click(); // 로그인 버튼 클릭
    }
}

// userName 필드에서 엔터키 눌렀을 때
userName.addEventListener("keydown", handleEnterKey);

// passWord 필드에서 엔터키 눌렀을 때
passWord.addEventListener("keydown", handleEnterKey);