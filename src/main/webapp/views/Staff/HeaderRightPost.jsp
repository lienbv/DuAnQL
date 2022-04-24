<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="right_header">
	<div class="header_button">
		<button type="button" class="btn btn-success js-modal-btn">
			<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
				fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
                                <path fill-rule="evenodd"
					d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z" />
                            </svg>
			THÊM MỚI
		</button>
	</div>
	<div class="header_search">
		<form action="/QL_Dat_Ban_NH/seachercontroller" method="post">
			<input  type="text" value="${txtS}" name="txt" id="">
			<button type="submit" class="btn btn-dark" >
				<svg xmlns="http://www.w3.org/2000/svg" style="color: white;"
					width="16" height="16" fill="currentColor" class="bi bi-search"
					viewBox="0 0 16 16">
                                    <path
						d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                                </svg>
				TÌM KIẾM
			</button>
		</form>
	</div>
</div>