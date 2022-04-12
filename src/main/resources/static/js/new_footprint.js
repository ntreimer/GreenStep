//let yearDropdown = document.getElementById("year-dropdown");
//
//let currentYear = new Date().getFullYear();
//let minimumYear = 2000;
//while (currentYear >= minimumYear) {
//    let dateOption = document.createElement('option');
//    dateOption.th:text = currentYear;
//    dateOption.th:value = currentYear;
//    yearDropdown.add(dateOption);
//    currentYear -= 1;
//}

function calculateFootprint(e) {
    e.preventDefault();
    let year = Number(document.getElementById("year").value);
    let electricity = Number(document.getElementById("electricity").value);
    let naturalGas = Number(document.getElementById("natural-gas").value);
    let heatingOil = Number(document.getElementById("heating-oil").value);
    let coal = Number(document.getElementById("coal").value);
    let propane = Number(document.getElementById("propane").value);
    let total = document.getElementById("footprint-total");
    let totalYear = document.getElementById("total-year");

    totalYear.value = year;
    total.value = electricity + naturalGas + heatingOil + coal + propane;
}