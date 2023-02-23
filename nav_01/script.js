let menu = document.querySelector('#menu-icon');
let close = document.querySelector('#close-icon');
let navbar = document.querySelector('.navbar');

menu.onclick = () => {
    menu.classList.toggle('fa-x');
    // menu.classList.toggle('hide');
    navbar.classList.toggle('open');

}
