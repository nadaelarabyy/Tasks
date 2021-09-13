function generateImages() {
    // get level and score
    var level_local = Number(localStorage.getItem("level") == null ? 1 : localStorage.getItem("level"));
    var imagesNum_local = Number(localStorage.getItem("imageNum") == null ? 2 : localStorage.getItem("imageNum"));
    var score_local = Number(localStorage.getItem("score") == null ? 0 : localStorage.getItem("score"));
    console.log("level: ", level_local);
    console.log("score: ", score_local);
    var level = document.getElementById("Level");
    level.setAttribute('value', level_local + "");
    var score = document.getElementById("Score");
    score.setAttribute('value', score_local + "");
    var imageNum = document.getElementById("Images");
    imageNum.setAttribute('value', imagesNum_local + "");
    // let score:number = Number((document.getElementById("Score") as HTMLInputElement).value);
    // let imagesNum = (document.getElementById("Images") as HTMLInputElement).value
    // number of emojis
    var randomNum = getRandomInt(Number(imagesNum_local), Number(imagesNum_local) + Number(level_local) + 5);
    var side = getRandomInt(0, 2);
    var item = getRandomInt(0, randomNum);
    var elems = document.querySelectorAll("[class='child']");
    var leftElm = elems[0];
    var rightElm = elems[2];
    for (var i = 0; randomNum > i; i++) {
        var x = getRandomInt(0, 550);
        var h = document.getElementById("header");
        var y = getRandomInt(Number(h === null || h === void 0 ? void 0 : h.clientHeight) + 5, window.innerHeight);
        var imgL = document.createElement("img");
        var aL = document.createElement("a");
        var imgR = document.createElement("img");
        var aR = document.createElement("a");
        aL.id = "smileyL" + i;
        aR.id = "smileyR" + i;
        imgL.src = "./images/smiley.png";
        imgR.src = "./images/smiley.png";
        imgL.width = 40;
        aL.style.marginLeft = x + 'px';
        aL.style.marginTop = y + 'px';
        imgR.width = 40;
        imgL.height = 40;
        imgR.height = 40;
        aR.style.marginLeft = x + 'px';
        aR.style.marginTop = y + 'px';
        if (!(side == 0 && i == item)) {
            aL.append(imgL);
            leftElm.appendChild(aL);
        }
        if (!(side == 1 && i == item)) {
            aR.appendChild(imgR);
            rightElm.appendChild(aR);
        }
    }
    for (var j = 0; randomNum > j; j++) {
        var elmL = document.getElementById("smileyL" + j);
        var elmR = document.getElementById("smileyR" + j);
        if ((elmL == null && elmR != null) || (elmL != null && elmR == null)) {
            if (elmL != null) {
                elmL.onclick = function clickLL() {
                    localStorage.setItem('level', Number(level_local) + 1 + "");
                    localStorage.setItem('score', Number(score_local) + 1 + "");
                    localStorage.setItem('imageNum', Number(randomNum) + "");
                    location.href = "./game.html";
                };
            }
            if (elmR != null) {
                elmR.onclick = function clickRR() {
                    localStorage.setItem('level', Number(level_local) + 1 + "");
                    localStorage.setItem('score', Number(score_local) + 1 + "");
                    localStorage.setItem('imageNum', Number(randomNum) + "");
                    location.href = "./game.html";
                };
            }
        }
        else {
            if (elmL != null && elmR != null) {
                elmL.onclick = function clickL() {
                    alert("Game Over");
                    localStorage.setItem("level", "1");
                    localStorage.setItem("score", "0");
                    localStorage.setItem("imageNum", "2");
                    leftElm.setAttribute("style", "background-color:red;");
                };
                elmR.onclick = function clickR() {
                    var _a;
                    alert("Game Over");
                    localStorage.setItem("level", "1");
                    localStorage.setItem("score", "0");
                    localStorage.setItem("imageNum", "2");
                    (_a = document.getElementById("child")) === null || _a === void 0 ? void 0 : _a.remove();
                    rightElm.setAttribute("style", "background-color:red;");
                };
            }
        }
    }
}
function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min);
}
function playButton() {
    location.href = "./game.html";
}
