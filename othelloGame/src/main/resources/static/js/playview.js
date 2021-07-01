// 要素 の 取得とイベントの追加
document. getElementById('0').addEventListener( 'click', clickMe, false);
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

var myNameSpace = {};
myNameSpace.preElement = null;
myNameSpace.rcvdata = null;
myNameSpace.mycolor = null;

//盤面の二次元配列情報
var board_ar = new Array(8);
for(var y = 0; y < ban_ar.length; y++){
    board_ar[y] = new Array(8);
    for(var x = 0; x < ban_ar.length; x++){
        var id = x + y * 8;
        board_ar[y][x] = document.getElementById(id).textContent
    }
}

function clickMe(e) {
    //this.textContent = this.id;
    //縦座標と横座標の導出
    var tate = Math.floor(this.id / 8) + 1;
    var yoko = this.id % 8 + 1;

    //クリックされたマスが空白かチェック
    if(isEmptyCell(tate, yoko)){
        //返せる石があるかチェック
        if(checkCanPut(yoko, tate, mycolor)){
            //ひっくり返す操作の要求
            //ここにサーバーへ送信するコードを書く
        }else{
            //そこにはおけないと表示
            displayError();
        }
    }else{
        //そこにはおけないと表示
        displayError();
    }

    if (null != myNameSpace.preElement) {
        myNameSpace.preElement.textContent = "";
    }
    myNameSpace.preElement = this;

    document.getElementById("msg").textContent = this.id;

    postmsg(this.id);
    // document.getElementById("tmstmp").textContent = myNameSpace.rcvdata;

};

function isEmptyCell(y, x){
    if(null == board_ar[y][x]){
        return true;
    }
    return false;
}

function checkCanPut(x, y, color){
    var reverse_cnt = 0;
    //上
    reverse_cnt = reverse_cnt + line_reverse(y, x, -1, 0, color)
    //右上
    reverse_cnt = reverse_cnt + line_reverse(y, x,-1, 1, color)
    //右
    reverse_cnt = reverse_cnt + line_reverse(y, x, 0, 1, color)
    //右下
    reverse_cnt = reverse_cnt + line_reverse(y, x, 1, 1, color)
    //下
    reverse_cnt = reverse_cnt + line_reverse(y, x, 1, 0, color)
    //左下
    reverse_cnt = reverse_cnt + line_reverse(y, x, 1,-1, color)
    //左
    reverse_cnt = reverse_cnt + line_reverse(y, x, 0,-1, color)
    //左上
    reverse_cnt = reverse_cnt + line_reverse(y, x,-1,-1, color)
    
    if(reverse_cnt == 0){
        return false;
    }else{
        return true;
    }
}

function line_reverse(y_sel,x_sel,add_y,add_x, myColor){
    var line_reverse_cnt = 0; //一方向で裏返る数
    var myStone_flg = 0; // その方向に自分の色の石があったか
    var x_cur = x_sel;
    var y_cur = y_sel;
    while(true){
        x_cur = x_cur + add_x;
        y_cur = y_cur + add_y;
        //盤外に出たら終了
        if(x_cur < 0 || x_cur > 7 || y_cur < 0 || y_cur > 7) {
            break;
        }
        //その場所に石が無かったら終了
        if(ban_ar[y_cur][x_cur] == 0) {
            break;
        }
        //その場所に自分の色の石があったら、フラグ建てて終了
        if(ban_ar[y_cur][x_cur] == myColor) {
            myStone_flg = 1;
            break;
        }
        //それ以外、つまり相手の石があった場合はカウント加算
        line_reverse_cnt++;
    }
    //カウントしたもの、フラグ立っていない場合はline_reverse_cntを0へ
    if(line_reverse_cnt > 0){
        if(myStone_flg == 0){
            line_reverse_cnt = 0;
        }
    }
    //裏返せる数を返す
    return line_reverse_cnt
}

function displayError(){
    alert("その場所に石を置くことはできません。")
}

//function postmsg(id) {
    // $.post("/demo/setposition", 
    // {position: id},
    //     function (data, textStatus, jqXHR) {
    //         alert("rcv:" + timestamp);
    //     },
    //     "dataType"
    // );

    //$.post("/demo/setposition", {position: id})
        //.done(function(data) {
            // サーバからの戻りがdataに入る
            // そこからidを指定して値を取得
            //var tmp = $(data).filter('#rcvmsg');
            // alert("rcv : " + tmp.text() );

            // 設定先のidを取得して値を設定
            //ar tmp2 = $('#tmstmp');
            //tmp2.text(tmp.text());
        //})
    
//}