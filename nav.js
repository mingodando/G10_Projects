const currentPage = window.location.pathname.split("/").pop() || "main.html";

// Const = "Create a variable that can't be reassigned later"
// Current Page = The variable name

//WINDOW
/*
window = built-in object
window.location = info about the current URL
window.location.pathname = the current URL path
.split("/") = split the string into an array
.pop() = get the last item in the array
|| = if the last item is empty, return the string "main.html"
*/

const navLinks = document.querySelectorAll(".nav a");

/*
document = built-in object, represents HTML page
querySelectorAll = Finds elements using a CSS selector
.nav a = Selects all links inside the .nav element
*/

navLinks.forEach((link) => {
// forEach = loop through each item in the array
// link = short way to write a function. "For each nav link, call this function, and name the current item link.

  const linkPage = link.getAttribute("href");
  // link = the actual <a> link
  // getAttribute("href") = read what you typed in HTML, example: "main.html"
  // linkPage = filename that the link points to

  if (linkPage === currentPage) {
  // If statement to check if the file name is the same as the current page
    link.classList.add("active");
    // Add an active class to the link, this way HTML changes the browser to have the class 'active', then the CSS
    //rule can run
  }
});
