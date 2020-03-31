
function createBoard()
{

    var table = document.createElement("table");
    for (var i = 0; i < 8; i++) {
        var tr = document.createElement('tr');
        for (var j = 0; j < 8; j++) {
            var td = document.createElement('td');
            if (i % 2 == j % 2) {
                td.className = "White";
                td.id = "r-" + i + ",c-" + j;
            } else {
                td.className = "Black";
                td.id = "r-" + i + ",c-" + j;
            }
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
    document.body.appendChild(table);
    populateBoard();
}

function populateBoard() {
    for (var i = 0; i < 8; i++) {
        for (var j = 0; j < 8; j++) {
            var piece = document.createElement('p');
            piece.textContent = "P";
            piece.draggable = true;
            document.getElementById("r-" + i + ",c-" + j).appendChild(piece);
        }
    }
}

function addListeners(piece) {
    piece.addEventListener(ondragover, allowDrop(event));
    piece.addEventListener(ondragstart, drag().bind(this, event));
    piece.addEventListener(ondrop, drop().bind(this, event));
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.preventDefault();
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    ev.target.appendChild(document.getElementById(data));
}
