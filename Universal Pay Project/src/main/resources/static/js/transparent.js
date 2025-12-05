document.addEventListener("DOMContentLoaded", function() {
    const openBtn = document.getElementById("openFormBtn");
    const closeBtn = document.getElementById("closeFormBtn");
    const overlay = document.getElementById("formOverlay");

    if (!openBtn || !closeBtn || !overlay) {
        console.error("Modal elements not found!");
        return;
    }

    openBtn.addEventListener("click", () => {
        overlay.style.display = "flex";
    });

    closeBtn.addEventListener("click", () => {
        overlay.style.display = "none";
    });

    overlay.addEventListener("click", (e) => {
        if (e.target === overlay) overlay.style.display = "none";
    });
});

//Cash In Function
document.addEventListener("DOMContentLoaded", function() {
    const openBtn = document.getElementById("openCshInBtn");
    const closeBtn = document.getElementById("cshInClose");
    const overlay = document.getElementById("cshInOverlay");

    if (!openBtn || !closeBtn || !overlay) {
        console.error("Modal elements not found!");
        return;
    }

    openBtn.addEventListener("click", () => {
        overlay.style.display = "flex";
    });

    closeBtn.addEventListener("click", () => {
        overlay.style.display = "none";
    });

    overlay.addEventListener("click", (e) => {
        if (e.target === overlay) overlay.style.display = "none";
    });
});
