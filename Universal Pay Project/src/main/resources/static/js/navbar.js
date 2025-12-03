
//Wide screen dropdown menu
document.addEventListener("click", function (e) {
    let dropdown = document.querySelector(".dropdown");

    // If menu button clicked → toggle dropdown
    if (e.target.closest(".dropdown > a")) {
        e.preventDefault();
        dropdown.classList.toggle("open");
    } 
    // If clicked outside → close dropdown
    else if (!e.target.closest(".dropdown")) {
        dropdown.classList.remove("open");
    }
});

