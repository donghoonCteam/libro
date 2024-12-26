<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
        <title>L i b r o</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/mypage.css">
    </head>
    <body style="padding-top: 0;">

    <main>
        <section>
            <div class="addr_form-container">
                <h2>배송지 변경</h2>
                <form>
                    <!-- 기본 정보 -->
                    <div class="addr_form-group">
                        <input type="text" name="address_book_name" placeholder="성명" value="${vo.address_book_name}">
                    </div>
                    <div class="addr_form-group">
                        <div style="display: flex; justify-content: space-between; margin-bottom: 15px;">
                            <input type="text" id="userPostCode" name="addr" value="54930" style="width: 70%;">
                            <button class="addr_btn" onclick="searchAddress();" >우편번호</button>
                        </div>
                        <input type="text" id="userAddress" name="addr" style="margin-bottom: 15px;" value="전북특별자치도 전주시 덕진구 백제대로 572">
                        <input type="text" id="userDtlAddress" name="addr" value="5층">
                    </div>
                    <div class="addr_form-group">
                        <div style="display: flex; justify-content: space-between;">
                            <select id="phonePrefix" name="phonePrefix" style="width: 30%;">
                                <option value="010">010</option>
                                <option value="011">011</option>
                                <option value="016">016</option>
                                <option value="016">017</option>
                                <option value="016">018</option>
                                <option value="016">019</option>
                            </select>&nbsp;_&nbsp;
                            <input type="text" id="phoneMiddle" name="phoneMiddle" style="width: 35%;" value="1234">&nbsp;_&nbsp;
                            <input type="text" id="phoneLast" name="phoneLast" style="width: 35%;" value="5678">
                        </div>
                    </div>
                    <div class="addr_form-group">
                        <textarea placeholder="배송메세지를 입력해 주세요." rows="10" cols="58">${vo.ordered_note}</textarea>
                    </div>

                    <!-- 버튼 -->
                    <div class="addr_form-footer">
                        <button onclick="location.href='addr.html'">취소</button>
                        <button type="submit" onclick="location.href='addr.html'">변경하기</button>
                    </div>
                </form>
            </div>
        </section>
    </main>

	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function searchAddress() {
			new daum.Postcode({
				oncomplete: function(data) { // 선택시 입력값 세팅
				document.getElementById("userAddress").value = data.address; // 주소 넣기
				document.getElementById("userPostCode").value = data.zonecode; // 우편번호 넣기
				var inputDtlAddr = document.getElementById("userDtlAddress"); // 주소란 읽기전용 설정
				inputDtlAddr.readOnly = false;
				}
			}).open();
		}
		
		function cancelAddress() {
			var inputPostCode = document.getElementById("userPostCode");
			inputPostCode.value = "" // 우편번호 초기화
			var inputAddr = document.getElementById("userAddress");
			inputAddr.value = "" // 주소란 초기화
			var inputDtlAddr = document.getElementById("userDtlAddress");
			inputDtlAddr.value = "" // 상세주소란 초기화
			inputDtlAddr.readOnly = true; // 상세주소란 읽기전용 해제
		}
	</script>
	
	<script>
		// vo.user_phone 값 (서버에서 전달되는 값)
		const userPhone = "${vo.address_book_phone}"; // 예: "010,1234,5678"
		
		if (userPhone) {
			const phoneParts = userPhone.split(",");
			if (phoneParts.length === 3) {
				// 각 필드에 값 설정
				document.getElementById("phonePrefix").value = phoneParts[0];
				document.getElementById("phoneMiddle").value = phoneParts[1];
				document.getElementById("phoneLast").value = phoneParts[2];
			}
		}
	</script>
	
	<script>
		// 체크박스 상태에 따라 hidden 필드 값 업데이트
		document.getElementById('addr_save').addEventListener('change', function () {
			const hiddenInput = document.getElementById('hidden_addr_save');
			hiddenInput.value = this.checked ? 'Y' : 'N';
		});
	</script>

    </body>
</html>





