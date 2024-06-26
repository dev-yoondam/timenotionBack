// heart-image 요소를 선택합니다.
const heartImage = document.getElementById("heart-image");
let checkFollow = true; // 팔로우를 한 상태가 default

// 클릭한 이미지의 부모 요소인 p 태그를 선택합니다.
const getFollowUser = document.getElementById("get-user-id").textContent.trim();
//1 또는 0  ; 1이면 true ,0이면 false 상태
const getFollowStaus = document.getElementById("get-user-status").textContent.trim();
console.log("getFollowUser: ", getFollowUser);


// 팔로우 상태를 로컬 스토리지에 저장하는 함수
function saveFollowStatus(status) {
    localStorage.setItem("followStatus", status);
}

// 팔로우 상태를 로컬 스토리지에서 가져오는 함수
function getFollowStatus() {
    return localStorage.getItem("followStatus");
}

// heart-image를 클릭했을 때 실행할 함수를 정의합니다.
heartImage.addEventListener("click", async function(event) {
    event.preventDefault(); // 기본 클릭 이벤트 방지

    if (heartImage.classList.contains('red')) {
        // 언팔로우시
        heartImage.classList.remove('red');
        alert("해당 회원을 언팔로우했습니다.");
        saveFollowStatus(getFollowUser, "NOT_FOLLOWING");
        checkFollow = false;
    } else {
        // 팔로우 시
        heartImage.classList.add('red');
        alert("해당 회원을 팔로우했습니다.");
        saveFollowStatus(getFollowUser, "FOLLOWING");
        checkFollow = true;
    }

    try {
        // followerId를 서버로 전송합니다.
        const response = await fetch(`/yourLife/userpage/${getFollowUser}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ followerId: getFollowUser, checkFollow: checkFollow })
        });

        if (!response.ok) {
            throw new Error("followerId 전송 실패");
        }

        console.log("followerId 전송 성공");
    } catch (error) {
        console.error(error.message);
    }

   location.reload();


});

// 페이지 로딩시 로컬 스토리지에서 팔로우 상태를 가져와서 이미지 색상 설정
window.addEventListener("DOMContentLoaded", function() {


    const followStatus = getFollowStatus();
    if (getFollowStaus ==1) {
        heartImage.classList.add('red');
    } else {
        heartImage.classList.remove('red');
    }
});
