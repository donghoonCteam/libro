<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <main class="app-main">
            <!--begin::App Content Header-->
            <div class="app-content-header">
                <!--begin::Container-->
                <div class="container-fluid">
                    <!--begin::Row-->
                    <div class="row">
                        <div class="col-sm-6">
                            <h3 class="mb-0">상품관리</h3>
                        </div>
                    </div>
                    <!--end::Row-->
                </div>
                <!--end::Container-->
            </div>
            <!--end::App Content Header-->
            <!--begin::App Content-->
            <div class="app-content">
                <!--begin::Container-->
                <div class="container-fluid">
                    <!--begin::Row-->
                    <div class="row g-4">
                        <!--begin::Col-->
                        <div class="col-12">
                            <!--begin::Quick Example-->
                            <div class="card card-primary card-outline mb-4">
                                <!--begin::Header-->
                                <div class="card-header">
                                    <div class="card-title">상품 정보 목록</div>
                                </div>
                                <!--end::Header-->
                                <!--begin::Form-->
                                <form>
                                    <!--begin::Body-->
                                    <div class="card-body">
                                        <div class="row g-3">

                                            <div class="row g-2">
                                                <label for="validationCustom04">카테고리</label>
                                                <div class="col-md-4">
                                                    <select class="form-select" id="category_name" name="category_name">
                                                        <option value="" disabled selected>선택</option>
                                                        <option value="시">시</option>
                                                        <option value="소설">소설</option>
                                                        <option value="자기계발서">자기계발서</option>
                                                        <option value="만화">만화</option>
                                                        <option value="예술">예술</option>
                                                        <option value="자연/과학">자연/과학</option>
                                                        <option value="학습">학습</option>
                                                        <option value="기술/공학">기술/공학</option>
                                                        <option value="수험서">수험서</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="validationCustom04">상세검색</label>
                                                <div class="col-md-4">
                                                    <select class="form-select" id="validationCustom04">
                                                        <option value="전체" selected>전체</option>
                                                        <option value="상품번호">상품번호</option>
                                                        <option value="상품명">상품명</option>
                                                        <option value="국제표준도서번호">국제표준도서번호</option>
                                                        <option value="재고">재고</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-6">
                                                    <input type="text" class="form-control" id="inputCity">
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="startDate" class="col-sm-2 col-form-label">상품 등록일</label>
                                                <div class="row">
                                                	<div class="col-md-5">
                                                   		<input type="date" class="form-control" id="startDate" name="startDate">
                                                	</div>
                                                   	<div class="col-md-5">
                                                   		<input type="date" class="form-control" id="endDate" name="endDate">
                                                	</div>
                                                </div>
                                            </div>
                                            
                                            <div class="row g-2">
                                                <label>진열상태</label>
                                                <div class="col">
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="product_status" id="inlineRadio1" value="all" checked>
                                                        <label class="form-check-label" for="inlineRadio1">전체</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="product_status" id="inlineRadio2" value="E">
                                                        <label class="form-check-label" for="inlineRadio2">진열</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="product_status" id="inlineRadio3" value="D">
                                                        <label class="form-check-label" for="inlineRadio3">미진열</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="product_status" id="inlineRadio4" value="S">
                                                        <label class="form-check-label" for="inlineRadio3">품절</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                        </div>
                                    </div>
                                    <!--end::Body-->
                                    <!--begin::Footer-->
                                    <div class="card-footer">
                                        <button type="button" class="btn btn-primary">Search</button>
                                        <button type="button" class="btn float-end">Reset</button>
                                    </div> <!--end::Footer-->
                                </form>
                                <!--end::Form-->
                            </div>
                            <!--end::Quick Example-->
                        </div>
                    </div> <!--end::Row-->
                </div> <!--end::Container-->
            </div> <!--end::App Content-->

            <div class="app-content"> <!--begin::Container-->
                <div class="container-fluid"> <!-- Timelime example  -->
                    <div class="row">
                        <div class="col-12"> <!-- The icons -->
                            <div class="col-12">
                                <div class="card card-primary card-outline mb-4">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>상품번호</th>
                                                <th>대표상품사진</th>
                                                <th>카테고리</th>
                                                <th>상품명</th>
                                                <th>저자</th>
                                                <th>국제표준도서번호</th>
                                                <th>판매가</th>
                                                <th>재고</th>
                                                <th>진열상태</th>
                                                <th>등록일</th>
                                                <th>등록id</th>
                                                <th>수정일</th>
                                                <th>수정id</th>
                                                <th>수정/삭제</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${list}" var="vo">
	                                            <tr>
	                                                <td onclick="location.href='productDetail.do';">${vo.product_no}</td>
	                                                <td>이미지</td>
	                                                <td>${vo.category_name}</td>
	                                                <td>${vo.product_name}</td>
	                                                <td>${vo.product_author}</td>
	                                                <td>${vo.product_isbn}</td>
	                                                <td>${vo.product_price}원</td>
	                                                <td>${vo.product_stock}</td>
	                                                <td>${vo.product_status}</td>
	                                                <td>${vo.product_created_at}</td>
	                                                <td>${vo.product_create_id}</td>
	                                                <td>${vo.product_update_at}</td>
	                                                <td>${vo.product_update_id}</td>
	                                                <td>
	                                                    <button class="btn btn-primary" onclick="location.href='productModify.do?product_no=${vo.product_no}'">수정</button>
	                                                    <button class="btn btn-primary" onclick="document.deletefrm.submit();">삭제</button>
	                                                    <form name="deletefrm" action="productDelete.do" method="post">
															<input type="hidden" name="product_no" value="${vo.product_no}">
														</form>
	                                                </td>
	                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <!--begin::Pagination-->
                                    <div aria-label="Page navigation example">
                                        <ul class="pagination">
                                            <li class="page-item">
                                             	<c:if test="${paging.startPage > 1 }">
	                                            	<a class="page-link" href="product.do?nowPage=${paging.startPage-1}" aria-label="Previous">
	                                            		<span aria-hidden="true">&laquo;</span>
	                                            	</a>
                                            	</c:if>
                                           	</li>
                                            <li class="page-item">
                                            	<c:forEach begin="${paging.startPage }" end="${paging.endPage}" var="cnt">
													<c:if test="${paging.nowPage eq cnt }">
														<b>${cnt}</b>
													</c:if>
													<c:if test="${paging.nowPage ne cnt }">
                                            			<a class="page-link" href="product.do?nowPage=${cnt}">${cnt}</a>
													</c:if>
												</c:forEach>
                                           	</li>
                                            <li class="page-item">
                                            	<c:if test="${paging.endPage < paging.lastPage }">
		                                            <a class="page-link" href="product.do?nowPage=${paging.endPage+1}" aria-label="Next">
		                                            	<span aria-hidden="true">&raquo;</span>
		                                            </a>
	                                            </c:if>
                                            </li>
                                        </ul>
                                    </div>
                                    <!--end::Pagination-->
                                </div>
                            </div>
                        </div> <!-- /.col -->
                    </div> <!-- /.row -->
                </div> <!--end::Container-->
            </div>
        </main>
				
<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>