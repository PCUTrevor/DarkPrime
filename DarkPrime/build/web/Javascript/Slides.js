/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
var index = 0;
carousel();

function carousel()
{
    var x = document.getElementsByClassName("slides");
    
    for(var i = 0; i < x.length; i++)
    {
        x[i].style.display = "none";
    }
    
    index++;
    if(index > x.length) {index = 0;}
    x[index - 1].style.display = "block";
    setTimeOut(carousel, 2000);
}*/

var slideIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
      x[i].style.display = "none"; 
    }
    slideIndex++;
    if (slideIndex > x.length) {slideIndex = 1} 
    x[slideIndex-1].style.display = "block"; 
    setTimeout(carousel, 2000); // Change image every 2 seconds
}