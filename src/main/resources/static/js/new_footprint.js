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

function calculateFootprint(event) {
    event.preventDefault();
    let year = Number(document.getElementById("year").value);
    let electricity = 0.000368 * Number(document.getElementById("electricity").value);
    let naturalGas = 0.000183 * Number(document.getElementById("natural-gas").value);
    let heatingOil = 0.00962 * Number(document.getElementById("heating-oil").value);
    let coal = 0.0288 * Number(document.getElementById("coal").value);
    let propane = 0.00584 * Number(document.getElementById("propane").value);
    let total = document.getElementById("footprint-total");
//    let totalYear = document.getElementById("total-year");

//    totalYear.value = year;
    total.value = Math.round(electricity + naturalGas + heatingOil + coal + propane);
}