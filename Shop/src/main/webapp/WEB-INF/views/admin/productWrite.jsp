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
                            <h3 class="mb-0">상품등록</h3>
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
                                <!--begin::Form-->
                                <form>
                                    <!--begin::Body-->
                                    <div class="card-body">
                                        <div class="row g-3">

                                            <div class="row g-2">
                                                <label>표시여부</label>
                                                <div class="col">
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" checked>
                                                        <label class="form-check-label" for="inlineRadio1">진열</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                                                        <label class="form-check-label" for="inlineRadio2">미진열</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3">
                                                        <label class="form-check-label" for="inlineRadio3">품절</label>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="validationCustom04">카테고리</label>
                                                <div class="col-md-4">
                                                    <select class="form-select" id="validationCustom04">
                                                        <option value="" disabled selected>선택</option>
                                                        <option value="전체">시</option>
                                                        <option value="상품주문번호">소설</option>
                                                        <option value="주문번호">자기계발서</option>
                                                        <option value="상품번호">만화</option>
                                                    </select>
                                                </div>
                                            </div>
                                            
                                            <div class="row g-2">
                                                <label for="inputPrice" class="col-sm-2 col-form-label">가격</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <input type="text" class="form-control" id="inputPrice">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="inputStock" class="col-sm-2 col-form-label">재고</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <input type="text" class="form-control" id="inputStock">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="inputProduct" class="col-sm-2 col-form-label">상품명</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <input type="text" class="form-control" id="inputProduct">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="inputISBN" class="col-sm-2 col-form-label">국제표준도서번호</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <input type="text" class="form-control" id="inputISBN">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="inputpage" class="col-sm-2 col-form-label">쪽수</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <input type="text" class="form-control" id="inputpage">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="inputProductInfo" class="col-sm-2 col-form-label">상품소개</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <textarea class="form-control" id="inputProductInfo" aria-label="With textarea"></textarea>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="inputWriter" class="col-sm-2 col-form-label">저자</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <input type="text" class="form-control" id="inputWriter">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="inputWriterInfo" class="col-sm-2 col-form-label">저자소개</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <textarea class="form-control" id="inputWriterInfo" aria-label="With textarea"></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="row g-2">
                                                <label for="topfile" class="col-sm-2 col-form-label">대표상품사진</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <input type="file" class="form-control" id="topfile">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-2">
                                                <label for="files" class="col-sm-2 col-form-label">기타사진</label>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <input type="file" class="form-control" id="files">
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <!--end::Body-->
                                    <!--begin::Footer-->
                                    <div class="card-footer">
                                        <button type="button" class="btn btn-primary">Register</button>
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
        </main>
				
<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>