// Show the modal
function showCashModal() {
    document.getElementById("popup").style.display = "flex";
}

// Hide the modal
function hideModal() {
    document.getElementById("popup").style.display = "none";
}

// Close modal when clicking outside the modal box
document.addEventListener("DOMContentLoaded", () => {
    const popup = document.getElementById("popup");
    if (popup) {
        popup.addEventListener("click", hideModal);
    }
});
