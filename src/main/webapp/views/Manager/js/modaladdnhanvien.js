const btnshow = document.querySelector('.js-modal-btn');
const btnClose = document.querySelector('.js_btn-close');
const modal = document.querySelector('.js_modal_add');
const modalContainer = document.querySelector('.js_modal_add_container');

function showModal() {
	modal.classList.add('open');
}

function hideModal() {
	modal.classList.remove('open');
}

btnshow.addEventListener('click', showModal);
btnClose.addEventListener('click', hideModal);
modalContainer.addEventListener('click', function(event) {
	event.stopPropagation();
})

// validate
// check name
function is_fullname(fullname) {
	var nameregex = /^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s\W|_]+$/;
	if (fullname.match(nameregex)) {
		return true;
	}
	else {
		return false;
	}
}

function checkFormName() {
	var name = document.getElementById('exampleInputName').value;
	if (is_fullname(name) == false) {
		document.getElementById('exampleInputName').style.borderColor = "red";
		document.getElementById('nameHelp').innerHTML = "Tên không đúng định dạng";
		document.getElementById('btn_save').disabled = true;
	} else {
		document.getElementById('exampleInputName').style.borderColor = "green";
		document.getElementById('nameHelp').innerHTML = "";
		document.getElementById('btn_save').disabled = false;
	}
}

// check số điện thoại
function is_phone(phonenumber) {
	var phoneregex = /^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/;
	if (phonenumber.match(phoneregex)) {
		return true;
	}
	else {
		return false;
	}
}

function checkFormPhone() {
	var phone = document.getElementById('exampleInputPhone').value;
	if (is_phone(phone) == false) {
		document.getElementById('exampleInputPhone').style.borderColor = "red";
		document.getElementById('emailHelp').innerHTML = "Số điện thoại không đúng định dạng";
		document.getElementById('btn_save').disabled = true;
	} else {
		document.getElementById('exampleInputPhone').style.borderColor = "green";
		document.getElementById('emailHelp').innerHTML = "";
		document.getElementById('btn_save').disabled = false;
	}
}

//check number
function checkNumber(){
    var number = document.getElementById('exampleInputQuantity').value;
    if(number < 0){
        document.getElementById('exampleInputQuantity').style.borderColor = "red";
        document.getElementById('quantityHelp').innerHTML = "Số lượng không hợp lệ";
        document.getElementById('submit').disabled = true;
    } else {
        document.getElementById('exampleInputQuantity').style.borderColor = "green";
        document.getElementById('quantityHelp').innerHTML = "";
        document.getElementById('submit').disabled = false;
    }
}

