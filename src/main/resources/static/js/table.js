/**
 * Created by Thomas on 1/03/2017.
 */
function tableCreate(){
    var body = document.body,
        tbl  = document.createElement('table');
    tbl.style.width  = '700px';
    tbl.style.border = '1px solid black';
    var header = tbl.createTHead();
    var row = header.insertRow(0);
    var cell = row.insertCell();
    cell.innerHTML = "<b>Song ID</b>";
    cell = row.insertCell();
    cell.innerHTML = "<b>Title</b>";
    cell = row.insertCell();
    cell.innerHTML = "<b>Artist</b>";
    cell = row.insertCell();
    cell.innerHTML = "<b>Actions</b>";
    cell.colSpan = 2;
    var i = 0;
    while(i < 3) {
        var tr = tbl.insertRow();
        var j = 0;
        for(var j = 0; j < 5; j++) {
            var td = tr.insertCell();
            td.style.border = '1px solid black';
            if(j < 3) {
                td.appendChild(document.createTextNode('Cell'));
            } else if(j == 3){
                td.innerHTML = "<button type=&quot;button&quot;>Play</button>";
            } else {
                td.innerHTML = "<button type=&quot;button&quot;>Stats</button>";
            }
        }

        i++;
    }
    body.appendChild(tbl);
}
tableCreate();