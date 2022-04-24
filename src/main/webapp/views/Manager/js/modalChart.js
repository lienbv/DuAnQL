const btnshow = document.querySelector('.js-modal-btn');
const btnClose = document.querySelector('.js_btn-close');
const modal = document.querySelector('.js_modal_chart');
const modalContainer = document.querySelector('.js_modal_chart--container');

function showModal() {
    modal.classList.add('open');
}

function hideModal() {
    modal.classList.remove('open');
}

btnshow.addEventListener('click', showModal);
btnClose.addEventListener('click', hideModal);
modalContainer.addEventListener('click', function (event) {
    event.stopPropagation();
})