// navbar-highlight.js
document.addEventListener("DOMContentLoaded", () => {
    const navLinks = document.querySelectorAll("nav ul li a");
    const currentPage = window.location.href;

    navLinks.forEach(link => {
        if (link.href === currentPage) {
            link.style.color = "#FFEB3B"; // Highlight the active link
            link.style.fontWeight = "bold";
        }
    });
});
