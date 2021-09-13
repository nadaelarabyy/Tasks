function generateImages():void {
    // get level and score
    let level_local:number = Number(localStorage.getItem("level")==null?1:localStorage.getItem("level"));
    var imagesNum_local:number = Number(localStorage.getItem("imageNum")==null?2:localStorage.getItem("imageNum"));
    
    var score_local:number = Number(localStorage.getItem("score")==null?0:localStorage.getItem("score"));
    console.log("level: ",level_local)
    console.log("score: ",score_local)
    
    let level = (document.getElementById("Level") as HTMLInputElement);
    level.setAttribute('value',level_local+"");
    let score = (document.getElementById("Score") as HTMLInputElement);
    score.setAttribute('value',score_local+"");
    let imageNum = (document.getElementById("Images") as HTMLInputElement);
    imageNum.setAttribute('value',imagesNum_local+"");
    
    // let score:number = Number((document.getElementById("Score") as HTMLInputElement).value);
    // let imagesNum = (document.getElementById("Images") as HTMLInputElement).value

    // number of emojis
    let randomNum:number = getRandomInt(Number(imagesNum_local),Number(imagesNum_local)+Number(level_local)+5)
    let side:number = getRandomInt(0,2);
    let item:number = getRandomInt(0,randomNum);

    let elems = document.querySelectorAll("[class='child']");
    let leftElm = elems[0]
    let rightElm = elems[2]
    for( var i=0;randomNum>i;i++){
        let x:number = getRandomInt(0,550)
        let h = document.getElementById("header");
        let y:number = getRandomInt(Number(h?.clientHeight)+5,window.innerHeight)
        var imgL=document.createElement("img");
        var aL = document.createElement("a");
        var imgR=document.createElement("img");
        var aR = document.createElement("a");
        aL.id="smileyL"+i;
        aR.id="smileyR"+i;
        imgL.src="./images/smiley.png";
        imgR.src="./images/smiley.png";
        imgL.width=40;
        aL.style.marginLeft= x+'px';
        aL.style.marginTop= y+'px';
        imgR.width=40;
        imgL.height=40;
        imgR.height=40;
        aR.style.marginLeft= x+'px';
        aR.style.marginTop= y+'px';
        if(!(side==0 && i==item)){
            aL.append(imgL)
            leftElm.appendChild(aL)
        }
        if(!(side==1 && i==item)){
            aR.appendChild(imgR);
            rightElm.appendChild(aR);
        }
    }


    for(var j=0;randomNum>j;j++){
        let elmL = document.getElementById("smileyL"+j);
        let elmR = document.getElementById("smileyR"+j);
        if((elmL==null && elmR!=null) || (elmL!=null && elmR == null)){
            if(elmL!=null){
                elmL.onclick = function clickLL() {
                    localStorage.setItem('level',Number(level_local)+1+"");
                    localStorage.setItem('score',Number(score_local)+1+"");
                    localStorage.setItem('imageNum',Number(randomNum)+"");
                    location.href = "./game.html"
                    
                }
    
        }
            if(elmR!=null){
                elmR.onclick = function clickRR() {
                    localStorage.setItem('level',Number(level_local)+1+"");
                    localStorage.setItem('score',Number(score_local)+1+"");
                    localStorage.setItem('imageNum',Number(randomNum)+"");
                    
                    location.href = "./game.html"
                }    
            }
        
        }
        else{
            if(elmL!=null && elmR!=null){
            elmL.onclick = function clickL() {

                alert("Game Over");
                localStorage.setItem("level","1");
                localStorage.setItem("score","0");
                localStorage.setItem("imageNum","2");
                leftElm.setAttribute("style","background-color:red;")
                
            }
            elmR.onclick = function clickR() {
                alert("Game Over");
                localStorage.setItem("level","1");
                localStorage.setItem("score","0");
                localStorage.setItem("imageNum","2");
                document.getElementById("child")?.remove();
                rightElm.setAttribute("style","background-color:red;")
            }
        }

        }
    
    }





    
}

function getRandomInt(min:number, max:number) :number {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min); 
}
function playButton(){
    location.href = "./game.html";    
}
