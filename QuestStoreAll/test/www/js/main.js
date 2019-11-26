const endPointUri = 'http://localhost:8080/api/UserClass/';
var data;

var aJax = $.ajax({
    xhrFields: {
        withCredentials: true
    },
    beforeSend: function (xhr) {
        xhr.setRequestHeader('Authorization', 'Basic ' + btoa('root:root'));
        xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8')
        xhr.overrideMimeType('application/json;charset=utf-8')
        // todo zostaw, moze sie przydać
        // xhr.overrideMimeType('json;charset=utf-8');
        // xhr.setRequestHeader('User-Agent', 'PostmanRuntime/7.16.3')
        // xhr.setRequestHeader('Accept-Encoding', 'gzip, deflate')
        // xhr.setRequestHeader('Accept-Encoding', 'gzip, deflate')
    },
    crossDomain: true,
    type: "GET",
    url: endPointUri,
    dataType: "json",
    success: function (myData) {
        var userClasses = [];
        $.each(myData, function (k, v) {
            userClasses.push(v);
            console.log(k, v , " <---  Wszystkie z Twojej bazy ");
        });

        console.log(userClasses[0].id , " <---- Twoje pierwsze userClasses");
        console.log(userClasses[0].name, " <---- Twoje pierwsze userClasses");
        console.log(userClasses[0].photoUrl, " <---- Twoje pierwsze userClasses");
    }
});


