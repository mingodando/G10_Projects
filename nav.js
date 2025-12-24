// const          -> declares a variable that cannot be reassigned (you can't do currentPage = ... later)
// fileName       -> variable name (you chose this name)
// =              -> assignment operator (stores the value on the right into the variable on the left)
// window         -> browser-provided object representing the current tab/window
// .location      -> property containing URL info (href, pathname, etc.)
// .pathname      -> string of the URL path only (example: "/Website%20Page%20HTML/about.html")
// .split("/")    -> string method: splits a string into an array using "/" as the separator
// .pop()         -> array method: removes and returns the last array item (here: the filename)
const fileName = window.location.pathname.split("/").pop();

// currentPage    -> variable name for the page we treat as "current"
// fileName && ...-> logical AND: returns the second part only if the first part is "truthy"
// fileName.length-> number of characters in the string (0 means empty string "")
// > 0            -> comparison operator
// ? :            -> ternary operator (inline if/else):
//                  condition ? valueIfTrue : valueIfFalse
// "index.html"   -> string literal (your chosen default home page filename)
const currentPage = fileName && fileName.length > 0 ? fileName : "index.html";

// NEW: Print the detected page name to the console
console.log("Detected curent page: ", currentPage);

// document       -> browser-provided object representing the HTML document (the page)
// .querySelectorAll(...) -> finds ALL matching elements using a CSS selector string
// ".nav a"       -> CSS selector meaning: "any <a> inside an element with class='nav'"
// navLinks       -> variable holding the results (a NodeList: list-like collection)
const navLinks = document.querySelectorAll(".nav-links a ");

// .forEach(...)  -> runs a function once per item in a list
// (link) => { }  -> arrow function:
//                  link is the parameter name (each time, it’s one <a> element)
//                  { } is the function body block
navLinks.forEach((link) => {
  // link          -> the current <a> element from the loop
  // .classList     -> a special object that manages the element's classes
  // .remove(...)   -> removes a class name if present (does nothing if not present)
  // "active"       -> class name string literal
  link.classList.remove("active");

  // href           -> variable name
  // link.getAttribute("href") -> reads the literal HTML attribute value from the element
  // "href"         -> attribute name string literal
  const href = link.getAttribute("href");

  // isHomeAlias    -> variable name ("is this link the home link?")
  // ( ... || ... ) -> OR operator: true if either side is true
  // ===            -> strict equality (must match value AND type)
  // &&             -> AND operator: true only if both sides are true
  // This expression becomes true only when:
  // - currentPage is "index.html" OR currentPage is "" (some setups)
  // - and this link’s href is exactly "index.html"
  //
  // NOTE: In your HTML, your Home link is "index.html", so this keeps it consistent.
  const isHomeAlias =
    (currentPage === "index.html" || currentPage === "") && href === "index.html";

  // if (...) { ... } -> conditional statement:
  // if condition is true, run the block
  // href === currentPage -> checks if this link points to the current filename
  // || isHomeAlias       -> OR: also allow the home alias match
  if (href === currentPage || isHomeAlias) {
    // .add(...) adds a class name to the element’s class list
    console.log("Matching link found! Activating:", href)
    link.classList.add("active");
  }
});
