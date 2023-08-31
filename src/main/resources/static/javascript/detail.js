window.onload=function()

{

window.requestAnimationFrame(getDate)

}

function getDate()

{

window.setTimeout(function(){

window.requestAnimationFrame(getDate)

},1000/2)

var d=new Date();

var year=d.getFullYear()  //获取年

var month=d.getMonth()+1;  //获取月，从 Date 对象返回月份 (0 ~ 11)，故在此处+1

var day=d.getDay()    //获取日

var days=d.getDate() //获取日期

var hour=d.getHours()   //获取小时

var minute=d.getMinutes()  //获取分钟

var second=d.getSeconds()   //获取秒

if(month<10) month="0"+month

if(days<10) days="0"+days

if(hour<10) hour="0"+hour

if(minute<10) minute="0"+minute

if(second<10) second="0"+second

var week=new Array("Sun","Mon","Tue","Wed","Thu","Fri","Sat")

var Tools=document.getElementById("date")

var da=year+"/"+month+"/"+days+"  "+week[day]

Tools.innerHTML=da

}