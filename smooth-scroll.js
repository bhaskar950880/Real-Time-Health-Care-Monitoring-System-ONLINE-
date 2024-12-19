// smooth-scroll.js
document.addEventListener("DOMContentLoaded", () => {
    const links = document.querySelectorAll("nav ul li a[href^='#']");

    links.forEach(link => {
        link.addEventListener("click", (e) => {
            e.preventDefault();
            const target = document.querySelector(link.getAttribute("href"));
            target.scrollIntoView({
                behavior: "smooth",
                block: "start",
            });
        });
    });
});
