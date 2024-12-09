<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/include/header.jsp" %>

        <main class="app-main">
            <!--begin::App Content Header-->
            <div class="app-content-header">
                <!--begin::Container-->
                <div class="container-fluid">
                    <!--begin::Row-->
                    <div class="row">
                        <div class="col-sm-6">
                            <h3 class="mb-0">리뷰관리</h3>
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
                                    <div class="card-title">리뷰 정보 목록</div>
                                </div>
                                <!--end::Header-->
                                <!--begin::Form-->
                                <form>
                                    <!--begin::Body-->
                                    <div class="card-body">
                                        <div class="row g-3">

                                            <div class="row g-2">
                                                <label for="validationCustom04">상세검색</label>
                                                <div class="col-md-4">
                                                    <select class="form-select" id="validationCustom04">
                                                        <option value="전체" selected>전체</option>
                                                        <option value="상품주문번호">상품주문번호</option>
                                                        <option value="주문번호">주문번호</option>
                                                        <option value="상품번호">상품번호</option>
                                                        <option value="상품명">상품명</option>
                                                        <option value="상품가격">별점</option>
                                                        <option value="수량">내용</option>
                                                        <option value="주문자명">작성자/ID</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-6">
                                                    <input type="text" class="form-control" id="inputCity">
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="inputDate" class="col-sm-2 col-form-label">리뷰 작성일</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                    <input type="date" class="form-control" id="inputDate">
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
                                                <th colspan='2'>상품정보</th>
                                                <th colspan='6'>리뷰정보</th>
                                                <th>주문정보</th>
                                            </tr>
                                            <tr>
                                                <th>상품번호</th>
                                                <th>상품명</th>
                                                <th>별점</th>
                                                <th>사진</th>
                                                <th>내용</th>
                                                <th>작성일</th>
                                                <th>수정일</th>
                                                <th>작성자명/ID</th>
                                                <th>상품주문번호</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td onclick="location.href='#';">465128315</td>
                                                <td onclick="location.href='#';">소년이온다</td>
                                                <td>5</td>
                                                <td>이미지</td>
                                                <td>
                                                    <p>소설 속 동호는 실제 인물은 아니지만, 상당히 진짜 이야기가 아닐까 싶을정도로 잘 썼다.</p>
                                                    <p>물론, 그 모델이 된 인물이 5.18당시 문재학군.</p>
                                                    <p>작별하지 않는다는 화려한 문체와 환상적인 이미지의 소설이라면, 소년이 온다는 현실적인 느낌이 드는 소설.</p>
                                                    <p>인간의 개인적 아픔의 관점에서 사실감 있게 썼다.</p>
                                                    <p>특히, 마지막 부분. 어머니의 관점에서 서술하는 부분은 눈물없이 읽기 힘들정도 ㅠ</p>
                                                    </td>
                                                <td>2024-12-04</td>
                                                <td></td>
                                                <td>홍길동</td>
                                                <td onclick="location.href='#';">465128315</td>
                                            </tr>
                                            <tr>
                                                <td onclick="location.href='#';">465128315</td>
                                                <td onclick="location.href='#';">소년이온다</td>
                                                <td>5</td>
                                                <td>이미지</td>
                                                <td>
                                                    <p>소설 속 동호는 실제 인물은 아니지만, 상당히 진짜 이야기가 아닐까 싶을정도로 잘 썼다.</p>
                                                    <p>물론, 그 모델이 된 인물이 5.18당시 문재학군.</p>
                                                    <p>작별하지 않는다는 화려한 문체와 환상적인 이미지의 소설이라면, 소년이 온다는 현실적인 느낌이 드는 소설.</p>
                                                    <p>인간의 개인적 아픔의 관점에서 사실감 있게 썼다.</p>
                                                    <p>특히, 마지막 부분. 어머니의 관점에서 서술하는 부분은 눈물없이 읽기 힘들정도 ㅠ</p>
                                                    </td>
                                                <td>2024-12-04</td>
                                                <td></td>
                                                <td>홍길동</td>
                                                <td onclick="location.href='#';">465128315</td>
                                            </tr>
                                            
                                        </tbody>
                                    </table>
                                    <!--begin::Pagination-->
                                    <div aria-label="Page navigation example">
                                        <ul class="pagination">
                                            <li class="page-item"> <a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a> </li>
                                            <li class="page-item"> <a class="page-link" href="#">1</a> </li>
                                            <li class="page-item"> <a class="page-link" href="#">2</a> </li>
                                            <li class="page-item"> <a class="page-link" href="#">3</a> </li>
                                            <li class="page-item"> <a class="page-link" href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a> </li>
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