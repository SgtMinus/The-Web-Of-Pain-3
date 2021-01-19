function drawGraph(){
        let canvas, context;
        canvas = document.getElementById("canvas");
        context = canvas.getContext("2d");

        context.strokeStyle="#E6E6FA";
        context.fillStyle="#E6E6FA";
        context.fillRect(0,0,canvas.width,canvas.height);


        context.font = "14px Verdana";
        context.strokeStyle = "#000000";
        context.lineWidth=1;
        context.fillStyle="#6b77ff";
        context.beginPath();
        context.moveTo(155,105);
        context.lineTo(105,155);
        context.lineTo(55,155);
        context.lineTo(55,205);
        context.lineTo(155,205);
        context.fill();
        context.stroke();

        context.beginPath();
        context.moveTo(155,105);
        context.lineTo(155,155);
        context.lineTo(205,155);
        context.arc(155,155, 50, 0, 3*Math.PI/2,true);
        context.fill();
        context.stroke();

        context.strokeText("X",165,15);
        context.strokeText("Y",294,145);
        context.strokeText("R",250,145);
        context.strokeText("R/2",200,145);
        context.strokeText("-R/2",95,145);
        context.strokeText("-R",45,145);
        context.strokeText("R", 165, 60);
        context.strokeText("R/2",165,110);
        context.strokeText("-R/2",165,210);
        context.strokeText("-R",165,260);

        context.lineWidth=3;


        context.beginPath();
        context.strokeStyle = "#000000";
        context.moveTo(5,155);
        context.lineTo(305,155);
        context.lineTo(295,163);
        context.moveTo(305,155);
        context.lineTo(295,147);
        context.moveTo(155,305);
        context.lineTo(155,5);
        context.lineTo(163,15);
        context.moveTo(155,5);
        context.lineTo(147,15);
        context.moveTo(205,147);
        context.lineTo(205,163);
        context.moveTo(255,147);
        context.lineTo(255,163);
        context.moveTo(105,147);
        context.lineTo(105,163);
        context.moveTo(55,147);
        context.lineTo(55,163);
        context.moveTo(147,205);
        context.lineTo(163,205);
        context.moveTo(147,255);
        context.lineTo(163,255);
        context.moveTo(147,105);
        context.lineTo(163,105);
        context.moveTo(147,55);
        context.lineTo(163,55);
        context.stroke();

}



function drawPoints(r) {
    drawGraph();
    let currentPoints = [];
    let tableRows = document.getElementById("mainTable").rows;
    for (let i=1; i<tableRows.length; i++){
        if (Number(r)===Number(tableRows[i].cells[2].innerHTML)) currentPoints.push(tableRows[i]);
    }
    let context = document.getElementById("canvas").getContext("2d");
    context.strokeStyle = "#000000";
    context.lineWidth = 0.5;

    for (let i=0; i<currentPoints.length;i++){
        let currentColor = "";
        let hitColor = "#008000";
        let missColor = "#ff0000";
        if (currentPoints[i].cells[3].innerHTML.trim()==="YES") currentColor=hitColor; else currentColor=missColor;
        let x = 155 + Number(currentPoints[i].cells[0].innerHTML)*100/r;
        let y = 155 - Number(currentPoints[i].cells[1].innerHTML)*100/r;
        context.fillStyle = currentColor;
        context.beginPath();
        context.arc(x,y,5,0,2*Math.PI);
        context.fill();
        context.stroke()
    }

}

function drawPointsWithoutR() {
    let r = document.forms["mainForm"].elements["mainForm:selectedR"].value;
    drawPoints(r);
}


function clickCanvas(event) {
    let r = document.forms["mainForm"].elements["mainForm:selectedR"].value;
    if (r!=="") {
        let t = event.target.closest("#canvas");
        let rect = t.getBoundingClientRect();
        let x = (((event.x - rect.left) - 155-5) * r / 100);
        let y = ((155+5 - (event.y - rect.top)) * r / 100);
        document.forms["mainForm"].elements["mainForm:clickedX"].value=x;
        document.forms["mainForm"].elements["mainForm:clickedY"].value=y;
        if ((x>=-5)&&(x<=1)&&(y>=-5)&&(y<=5)&&(r>=1)&&(r<=5)) {
            document.getElementById('mainForm:clickFormButton').click();
        }
        else alert("X или Y вне ОДЗ")
    } else alert("А как же R? :c")


}

