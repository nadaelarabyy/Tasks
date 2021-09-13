function playButton(){
    location.href = "./game.html";    
}
function generateImages(){
var level = localStorage.getItem("level")==null?1:localStorage.getItem("level");
var imagesNum = localStorage.getItem("imageNum")==null?2:localStorage.getItem("imageNum");
var sections = ["left","right"]
var sectionNum;
// var sectionNum=1
var randomNum = getRandomInt(imagesNum,imagesNum+level*2)
var pickedphoto = getRandomInt(0,randomNum)


console.log("images number: "+randomNum)
for (let index = 0; index < randomNum; index++) {
    var img=document.createElement("img");
    var a = document.createElement("a")
    sectionNum = getRandomInt(0,2)
    console.log(sectionNum)
    // sectionNum=0
    var section = document.getElementById(sections[sectionNum]);
    var x,y=0;

    if(sectionNum==0){
        x = getRandomInt(0,(window.innerWidth/2)-50)
        y = getRandomInt(0,window.innerHeight)
    }
    else{
        var w = document.getElementById("left")
        x = getRandomInt((window.innerWidth/2)+50,(window.innerWidth/2)+section.clientWidth -50)
        y = getRandomInt(0,window.innerHeight)
    }
    if(index === pickedphoto){
        img.src="images/winky.png"
        img.width="40" 
        img.height="40"
        a.id = "winky"
        
    }
    else{
        img.src = "images/smiley.png"
        img.width="40" 
        img.height="40"
        a.id = "smiley"
        
    }
    img.id="picture"
    img.style.position="fixed"
    img.style.left= x+'px';
    img.style.top= y+'px';
    
    a.appendChild(img)
    section.appendChild(a);
}
var elms = document.querySelectorAll("[id='smiley']");
for(var i = 0; i < elms.length; i++){
    elms[i].onclick = function click2() {
        alert("Game Over:((");
        localStorage.removeItem("level");
        localStorage.removeItem("imageNum");
        
    };
}
var alink = document.getElementById("winky")
alink.onclick = function click() {
    alert("Moving to level "+level)
    alink.href = "./game.html"
    level=Number(level)+1;
    localStorage.setItem("level", level);
    localStorage.setItem("imageNum", randomNum);
    console.log(level)
    
};




}
function getRandomInt(min, max) {
min = Math.ceil(min);
max = Math.floor(max);
return Math.floor(Math.random() * (max - min) + min); //The maximum is exclusive and the minimum is inclusive
}