// "YY-MM-DD-HH-MM-SS"
function getNowDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var Hours = date.getHours();
    var Minutes = date.getMinutes();
    var Seconds = date.getSeconds();

    if (Hours >= 0 && Hours <= 9) {
        Hours = "0" + Hours;
    }
    if (Minutes >= 0 && Minutes <= 9) {
        Minutes = "0" + Minutes;
    }
    if (Seconds >= 0 && Seconds <= 9) {
        Seconds = "0" + Seconds;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + "T" + Hours + seperator2 + Minutes
        + seperator2 + Seconds;
    return currentdate;
}