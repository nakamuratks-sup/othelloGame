
function start() {

    var choice = document.getElementsByName('attack');

    let checkValue = '';

    for (let i = 0; i < 2; i++) {
        if (choice.item(i).checked) {
            checkValue = choice.item(i).value;
            console.log(checkValue);
        }
    }


}