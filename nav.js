const currentPage = window.location.pathname.split("/").pop() || "main.html";
const navLinks = document.querySelectorAll(".nav a");

navLinks.forEach((link) => {
  const linkPage = link.getAttribute("href");
  if (linkPage === currentPage) {
    link.classList.add("active");
  }
});
