<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/user/include/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mypage.css">

        <main>
            <section>
                <div class="login-container">

                    <h2>로그인</h2>

                    <div class="login-info">
                        <button class="text-button" id="existing-member" onclick="toggleActiveButton('existing-member')">기존 회원이세요?</button>
                        <button class="text-button" id="non-member" onclick="toggleActiveButton('non-member')">비회원 배송조회</button>
                    </div>
                
                    <!-- 로그인 -->
                    <div class="form-container" id="existing-member-form">
                        <form action="loginOk.do" method="post">
                            <input type="text" name="user_id" placeholder="아이디" required>
                            <input type="password" name="user_password" placeholder="비밀번호" required>
                            <button class="login-btn">로그인</button>
                        </form>
                    </div>
                
                    <!-- 비회원 배송조회 -->
                    <div class="form-container" id="non-member-form">
                        <form>
                            <input type="text" placeholder="주문자명" required>
                            <input type="text" placeholder="주문번호" required>
                            <input type="password" placeholder="비회원주문 비밀번호" required>
                            <button type="submit" class="login-btn">비회원 배송조회</button>
                        </form>
                    </div>

                    <div class="signup">
                    	아직 회원이 아니신가요? <a href="join.do">회원가입</a>
                    </div>

                </div>
            </section>
        </main>

        <script>
            // 페이지 로드 시 자동으로 기존 회원 로그인 폼이 활성화되도록 설정
            window.onload = function() {

            // 로컬 스토리지에서 저장된 활성화된 버튼을 불러와서 해당 버튼 활성화
            var activeButtonId = localStorage.getItem('activeButtonId');
            if (activeButtonId) {
                toggleActiveButton(activeButtonId);
            } else {
                toggleActiveButton('order-list');  // 기본 값으로 '주문 목록' 버튼 활성화
            }
            };

            function toggleActiveButton(buttonId) {

                // 로컬 스토리지에 클릭된 버튼 ID 저장
                localStorage.setItem('activeButtonId', buttonId);

                // 모든 버튼에서 button-active 클래스 제거
                document.querySelectorAll(".text-button").forEach(button => {
                    button.classList.remove("button-active");
                });
    
                // 선택한 버튼에 button-active 클래스 추가
                document.getElementById(buttonId).classList.add("button-active");
    
                // 모든 폼을 숨김
                document.querySelectorAll(".form-container").forEach(form => {
                    form.classList.remove("active");
                });
    
                // 선택된 버튼에 따라 폼을 표시
                if (buttonId === 'existing-member') {
                    document.getElementById('existing-member-form').classList.add('active');
                } else if (buttonId === 'non-member') {
                    document.getElementById('non-member-form').classList.add('active');
                }
            }
    
            // 초기 상태에서 기존 회원 폼을 표시
            document.getElementById('existing-member').classList.add('button-active');
            document.getElementById('existing-member-form').classList.add('active');
        </script>

<%@ include file="/WEB-INF/views/user/include/footer.jsp" %>	