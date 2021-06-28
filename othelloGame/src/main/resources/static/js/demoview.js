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
document. getElementById('10').addEventListener( 'click', clickMe, false);
document. getElementById('11').addEventListener( 'click', clickMe, false);
document. getElementById('12').addEventListener( 'click', clickMe, false);
document. getElementById('13').addEventListener( 'click', clickMe, false);
document. getElementById('14').addEventListener( 'click', clickMe, false);
document. getElementById('15').addEventListener( 'click', clickMe, false);
document. getElementById('16').addEventListener( 'click', clickMe, false);
document. getElementById('17').addEventListener( 'click', clickMe, false);
document. getElementById('18').addEventListener( 'click', clickMe, false);
document. getElementById('19').addEventListener( 'click', clickMe, false);
document. getElementById('20').addEventListener( 'click', clickMe, false);
document. getElementById('21').addEventListener( 'click', clickMe, false);
document. getElementById('22').addEventListener( 'click', clickMe, false);
document. getElementById('23').addEventListener( 'click', clickMe, false);
document. getElementById('24').addEventListener( 'click', clickMe, false);
document. getElementById('25').addEventListener( 'click', clickMe, false);
document. getElementById('26').addEventListener( 'click', clickMe, false);
document. getElementById('27').addEventListener( 'click', clickMe, false);
document. getElementById('28').addEventListener( 'click', clickMe, false);
document. getElementById('29').addEventListener( 'click', clickMe, false);
document. getElementById('30').addEventListener( 'click', clickMe, false);
document. getElementById('31').addEventListener( 'click', clickMe, false);
document. getElementById('32').addEventListener( 'click', clickMe, false);
document. getElementById('33').addEventListener( 'click', clickMe, false);
document. getElementById('34').addEventListener( 'click', clickMe, false);
document. getElementById('35').addEventListener( 'click', clickMe, false);
document. getElementById('36').addEventListener( 'click', clickMe, false);
document. getElementById('37').addEventListener( 'click', clickMe, false);
document. getElementById('38').addEventListener( 'click', clickMe, false);
document. getElementById('39').addEventListener( 'click', clickMe, false);
document. getElementById('40').addEventListener( 'click', clickMe, false);
document. getElementById('41').addEventListener( 'click', clickMe, false);
document. getElementById('42').addEventListener( 'click', clickMe, false);
document. getElementById('43').addEventListener( 'click', clickMe, false);
document. getElementById('44').addEventListener( 'click', clickMe, false);
document. getElementById('45').addEventListener( 'click', clickMe, false);
document. getElementById('46').addEventListener( 'click', clickMe, false);
document. getElementById('47').addEventListener( 'click', clickMe, false);
document. getElementById('48').addEventListener( 'click', clickMe, false);
document. getElementById('49').addEventListener( 'click', clickMe, false);
document. getElementById('50').addEventListener( 'click', clickMe, false);
document. getElementById('51').addEventListener( 'click', clickMe, false);
document. getElementById('52').addEventListener( 'click', clickMe, false);
document. getElementById('53').addEventListener( 'click', clickMe, false);
document. getElementById('54').addEventListener( 'click', clickMe, false);
document. getElementById('55').addEventListener( 'click', clickMe, false);
document. getElementById('56').addEventListener( 'click', clickMe, false);
document. getElementById('57').addEventListener( 'click', clickMe, false);
document. getElementById('58').addEventListener( 'click', clickMe, false);
document. getElementById('59').addEventListener( 'click', clickMe, false);
document. getElementById('60').addEventListener( 'click', clickMe, false);
document. getElementById('61').addEventListener( 'click', clickMe, false);
document. getElementById('62').addEventListener( 'click', clickMe, false);
document. getElementById('63').addEventListener( 'click', clickMe, false);
document. getElementById('64').addEventListener( 'click', clickMe, false);

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
        })
    
}