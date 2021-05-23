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

function clickMe(e) {
    this.textContent = this.id;
    if (null != myNameSpace.preElement) {
        myNameSpace.preElement.textContent = "";
    }
    myNameSpace.preElement = this;

    document.getElementById("msg").textContent = this.id;
};
