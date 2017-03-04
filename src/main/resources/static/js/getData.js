/**
 * Created by Thomas on 1/03/2017.
 */
function getData() {
    var proxy = 'https://cors-anywhere.herokuapp.com/';
    var myURL = 'https://api.myjson.com/bins/11fzpt';
    $.ajax({
        //url: 'https://jsonplaceholder.typicode.com/posts/1',
        //url: 'http://143.129.39.150:8080/DJAppServer_war/info/yolo',
        //url: 'https://api.myjson.com/bins/11fzpt',
        url: proxy + myURL,
        method: 'GET',
        cache: false,
        //dataType: 'jsonp',
        statusCode: {
            200: function (response) {
                alert('200');
            },
            201: function (response) {
                alert('201');
            },
            400: function (response) {
                alert('400');
            },
            404: function (response) {
                alert('404');
            }
        },
        error: function() {
            console.log("error");
        }
    }).then(function(data){
        console.log(JSON.stringify(data));
    });
}
getData();