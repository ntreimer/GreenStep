let yearDropdown = document.getElementById("year-dropdown");

let currentYear = new Date().getFullYear();
let minimumYear = 2000;
while (currentYear >= minimumYear) {
    let dateOption = document.createElement('option');
    dateOption.th:text = currentYear;
    dateOption.th:value = currentYear;
    yearDropdown.add(dateOption);
    currentYear -= 1;
}