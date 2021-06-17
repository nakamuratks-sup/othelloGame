// 要素 の 取得とイベントの追加
document. getElementById('1').addEventListener( 'click', clickMe, false);
document. getElementById('2').addEventListener( 'click', clickMe, false);
document. getElementById('3').addEventListener( 'click', clickMe, false);
document. getElementById('4').addEventListener( 'click', clickMe, false);
document. getElementById('5').addEventListener( 'click', clickMe, false);
document. getElementById('6').addEventListener( 'click', clickMe, false);
document. getElementById('7').addEventListener( 'click', clickMe, false);
document. getElementById('8').addEventListener( 'click', clickMe, false);
document. getElementById('9').addEventListener( 'click', clickMe, false);

var myNameSpace = {};
myNameSpace.preElement = null;
myNameSpace.rcvdata = null;

function clickMe(e) {
    this.textContent = this.id;
    if (null != myNameSpace.preElement) {
        myNameSpace.preElement.textContent = "";
    }
    myNameSpace.preElement = this;

    document.getElementById("msg").textContent = this.id;

    postmsg(this.id);
    // document.getElementById("tmstmp").textContent = myNameSpace.rcvdata;
    jsonPost();
};

function postmsg(id) {
    // $.post("/demo/setposition", 
    // {position: id},
    //     function (data, textStatus, jqXHR) {
    //         alert("rcv:" + timestamp);
    //     },
    //     "dataType"
    // );

    $.post("/demo/setposition", {position: id})
        .done(function(data) {
            // サーバからの戻りがdataに入る
            // そこからidを指定して値を取得
            var tmp = $(data).filter('#rcvmsg');
            // alert("rcv : " + tmp.text() );

            // 設定先のidを取得して値を設定
            var tmp2 = $('#tmstmp');
            tmp2.text(tmp.text());
        });
};

// サーバへjsonで送るサンプル
function jsonPost(){
    $("#jsr1").text("");
    $("#jsr1").text("");

    var json1 = {
        bangou: "1",
        name: "山田",
    };

    $.ajax({
        url: "/sample/json",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(json1),
        dataType: "json",
    })
    .done(function (date1, textStatus, jqXHR) {
        $("#jsr1").text(jqXHR.status);
        $("#jsr2").text(JSON.stringify(date1));
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        $("#jsr1").text(jqXHR.status);
    })
    .always(function () { }) ;
};
