const btnLogin = document.querySelector('.js-modal-btn');
const btnClose1 = document.querySelector('.btn-close');
const btnClose2 = document.querySelector('.btn-close2');
const modal = document.querySelector('.js-modal-login');
const modalContainer = document.querySelector('.js-modal-login_container');

function showModal() {
    modal.classList.add('open');
}

function hideModal() {
    modal.classList.remove('open');
}

btnLogin.addEventListener('click', showModal);
btnClose1.addEventListener('click', hideModal);
btnClose2.addEventListener('click', hideModal);
modalContainer.addEventListener('click', function (event) {
    event.stopPropagation();
})

//forgot
const btnOnFG = document.querySelector('.btn_forgot');
const btnOffFG = document.querySelector('.closeFG');
const modalFG = document.querySelector('.modal-forgot');
const modalContainerFG = document.querySelector('.modal-forgot_container');

function showModalFG() {
    modalFG.classList.add('open');
}

function hideModalFG() {
    modalFG.classList.remove('open');
}

btnOnFG.addEventListener('click', showModalFG);
btnOffFG.addEventListener('click', hideModalFG);
modalContainerFG.addEventListener('click', function (event) {
    event.stopPropagation();
})

// guest
const btnOnGuest = document.querySelector('.js_btnOpen_guest');
const btnOffGuest = document.querySelector('.exitGuest');
const modalGuest= document.querySelector('.js_modal_guest');
const modalContainerGuest = document.querySelector('.js_modal_guest_container');

function showModalGuest() {
    modalGuest.classList.add('open');
}

function hideModalGuest() {
    modalGuest.classList.remove('open');
}

btnOnGuest.addEventListener('click', showModalGuest);
btnOffGuest.addEventListener('click', hideModalGuest);
modalContainerGuest.addEventListener('click', function (event) {
    event.stopPropagation();
})

