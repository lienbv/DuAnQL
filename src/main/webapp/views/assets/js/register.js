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
    var name = document.getElementById('exampleInputFullName1').value;
    if (is_fullname(name) == false) {
        document.getElementById('exampleInputFullName1').style.borderColor = "red";
        alert("Tên không đúng định dạng, hãy thử lại!");
        document.getElementById("button").disabled = true;
        document.getElementById("button1").disabled = true;
    } else {
        document.getElementById('exampleInputFullName1').style.borderColor = "green";
        document.getElementById("button").disabled = false;
        document.getElementById("button1").disabled = false;
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
    var phone = document.getElementById('exampleInputPhoneNume1').value;
    if (is_phone(phone) == false) {
        document.getElementById('exampleInputPhoneNume1').style.borderColor = "red";
        alert("Số điện thoại không đúng định dạng, hãy thử lại!");
        document.getElementById("button").disabled = true;
    } else {
        document.getElementById('exampleInputPhoneNume1').style.borderColor = "green";
        document.getElementById("button").disabled = false;
    }
}

// check match password
var check = function(){
    if(document.getElementById('InputNewPass1').value ==
    document.getElementById('InputNewPass2').value){
        document.getElementById('InputNewPass1').style.borderColor = "green";
        document.getElementById('InputNewPass2').style.borderColor = "green";
        document.getElementById("button").disabled = false;
    } else {
        alert("Password not matching");
        document.getElementById('InputNewPass1').style.borderColor = "red";
        document.getElementById('InputNewPass2').style.borderColor = "red";
        document.getElementById("button").disabled = true;
    }
}

function checkNumber(){
    var sl = document.getElementById('exampleFormControlQuan').value;
    if(sl < 0){
        document.getElementById('QuanHelp').innerHTML="Số lượng không hợp lệ";
        document.getElementById('exampleFormControlQuan').style.borderColor ="red";
        document.getElementById('button1').disabled = true;
    } else {
        document.getElementById('QuanHelp').innerHTML="";
        document.getElementById('exampleFormControlQuan').style.borderColor ="green";
        document.getElementById('button1').disabled = false;
    }
}