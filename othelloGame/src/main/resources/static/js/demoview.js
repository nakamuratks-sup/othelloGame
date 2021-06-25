// 要素 の 取得とイベントの追加
document.getElementById("1").addEventListener("click", clickMe, false);
document.getElementById("2").addEventListener("click", clickMe, false);
document.getElementById("3").addEventListener("click", clickMe, false);
document.getElementById("4").addEventListener("click", clickMe, false);
document.getElementById("5").addEventListener("click", clickMe, false);
document.getElementById("6").addEventListener("click", clickMe, false);
document.getElementById("7").addEventListener("click", clickMe, false);
document.getElementById("8").addEventListener("click", clickMe, false);
document.getElementById("9").addEventListener("click", clickMe, false);

// クリックしたセルの色を変える
$(".cell").on("click", function () {
  $(this).toggleClass("isActive");
});
// javascript版 うごかない
// var cellelem = document.getElementById('cell').addEventListener('click', function(){
//     this.classList.toggle('isActive');
//   },false);

// 名前空間を疑似的に作り変数名の競合を避ける
var myNameSpace = {};
myNameSpace.preElement = null;
myNameSpace.rcvdata = null;

// マスをクリックしたときの処理
function clickMe(e) {
  this.textContent = this.id;
  if (null != myNameSpace.preElement) {
    // 前回クリックしたマスのテキストを空にする
    myNameSpace.preElement.textContent = "";
  }
  // 今回クリックしたマスの情報を保存
  myNameSpace.preElement = this;

  document.getElementById("msg").textContent = this.id;

  // 通常のHTMLによるサーバ通信サンプル
  postmsg(this.id);

  // jsonによるサーバ通信サンプル
  jsonPost(this.id);

  // getTableImage();
}

// サーバへHTMLで送るサンプル
function postmsg(id) {
  // $.post("/demo/setposition",
  // {position: id},
  //     function (data, textStatus, jqXHR) {
  //         alert("rcv:" + timestamp);
  //     },
  //     "dataType"
  // );

  $.post("/demo/setposition", { position: id }).done(function (data) {
    // サーバからの戻りがdataに入る
    // データ形式はHTML、receive.htmlファイルがそれ
    // そこからidを指定して値を取得
    var tmp = $(data).filter("#rcvmsg");
    // alert("rcv : " + tmp.text() );

    // 設定先のidを取得して値を設定
    var tmp2 = $("#tmstmp");
    tmp2.text(tmp.text());
  });
}

// サーバへjsonで送るサンプル
function jsonPost(id) {
  // 表示先のエリアを初期化
  $("#jsr1").text("");
  $("#jsr2").text("");

  // 送信用jsonデータ
  var jsonlist1 = [
    {
      bangou: id,
      name: "山田",
    },
    {
      bangou: id,
      name: "佐藤",
    },
  ];

  var json1 = {
    bangou: id,
    name: "山田",
  };

  // ajaxによる非同期通信処理
  $.ajax({
    url: "/sample/json",
    type: "POST",
    contentType: "application/json",
    // data: JSON.stringify(jsonlist1),
    // テーブル情報をjson化したものをサーバへ送る
    data: JSON.stringify(getTableImage()),
    dataType: "json",
  })
    .done(function (date1, textStatus, jqXHR) {
      // 正常応答時処理
      // レスポンスコード表示
      $("#jsr1").text(jqXHR.status);
      // jsonデータを文字列にして表示
      $("#jsr2").text(JSON.stringify(date1));

      // 変数をidとして別のテーブルid指定する
      // $(`#${id}a`).text(`${id}`);
      setTableImage(date1);
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
      // 異常応答時処理
      // レスポンスコード表示
      $("#jsr1").text(jqXHR.status);
    })
    .always(function () {});
}

// tableをjson化する
function getTableImage() {
  var counter = 0;
  var line = [];
  // table要素内のtrの中のtdタグidとテキスト内容を配列に詰め込む
  $("#tbl1 tr td").map(function (index, val) {
    line[counter] = {
      bangou: val.id,
      name: $(val).text(),
    };
    counter += 1;
  });

  // 作成内容をコンソールに表示
  console.log(line);
  console.log(JSON.stringify(line));
  return line;
}

// json配列の内容をテーブルに展開
function setTableImage(params) {
  var size = params.length;
  for (cnt = 0; cnt < size; cnt++) {
    // $(`#${id}a`).text(`${id}`);
    var num = params[cnt].bangou;
    var name = params[cnt].name;
    $(`#${num}a`).text(`${name}`);
  }
}
