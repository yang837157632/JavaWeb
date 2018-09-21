/**
 * 验证用户的输入是否为空
 */
function check() {
	var num1 = document.getElementById("num1").value;
	var num2 = document.getElementById("num2").value;
	if (num1 == "" || num2 == "") {
		window.alert("输入不能为空");
		return false;
	}

	// js正则表达式
	// var reg=/^[0-9]\d*9(\.[0-9]+)?$|^0$/gi;
	var reg = /^[1-9]\d*(\.[0-9]+)?$|^0$/i;
	// 0.XXX不能输入？？？
	if (!reg.test(num1)) {
		window.alert(num1.constructor + "\n" + num1 + "不是一个数");
		return false;
	}

	if (!reg.test(num2)) {
		window.alert(num2.constructor + "\n" + num2 + "不是一个数");
		return false;
	}
}