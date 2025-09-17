
document.addEventListener('DOMContentLoaded', function() {
                            
    const divMenu = document.getElementsByClassName('menu-responsive')[0];
    const divMenuX = document.getElementsByClassName('exit-responsive')[0];
    const header = document.getElementsByClassName('header-second-box')[0];

    divMenu.addEventListener('click', function() {
        header.classList.toggle('slide-in-right');
        divMenuX.classList.toggle('mostrar-exit-responsive');

    });

    

    divMenuX.addEventListener('click', function() {
        header.classList.toggle('slide-in-right');
        divMenuX.classList.toggle('mostrar-exit-responsive');
    });

})