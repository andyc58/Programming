/*
COPYRIGHT (C) 2013-2019 PROCTORIO INC.
USE OF THIS SOFTWARE IS PROTECTED BY COPYRIGHT LAWS AND INTERNATIONAL COPYRIGHT TREATIES,
AS WELL AS OTHER INTELLECTUAL PROPERTY LAWS AND TREATIES.
UNAUTHORIZED REPRODUCTION, DISPLAY, MODIFICATION, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
MAY RESULT IN SEVERE CIVIL AND CRIMINAL PENALTIES, AND WILL BE PROSECUTED TO THE FULL EXTENT PERMITTED BY LAW.
USE OF THIS SOFTWARE IS CONDITIONED ON YOUR ACCEPTANCE OF OUR TERMS OF SERVICE, FOUND AT PROCTORIO.COM/TOS.
OPEN SOURCE LICENSES CAN BE FOUND IN THE LICENSE.TXT FILE OR ONLINE AT PROCTORIO.COM/LICENSES.
*/
function bf12ff9d246f47faa936f43a48f301e6(b,f){return"("+function(c,a){var d=document.getElementById(a);d.value=c;var b=setInterval(function(){if("undefined"!=typeof tinyMCE||"undefined"!=typeof tinyRCE){clearInterval(b);var e=setInterval(function(){"undefined"!=typeof tinyMCE&&"undefined"!=typeof tinyMCE.get(a)&&null!=tinyMCE.get(a)?(clearInterval(e),tinyMCE.get(a).setContent(c),d.dataset.pio="done"):"undefined"!=typeof tinyRCE&&"undefined"!=typeof tinyRCE.get(a)&&null!=tinyRCE.get(a)&&(clearInterval(e),
tinyRCE.get(a).setContent(c),tinyRCE.get(a).save(),d.dataset.pio="done")},250)}},250)}+")("+JSON.stringify(b)+", "+JSON.stringify(f)+")"};
