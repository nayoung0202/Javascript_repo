

let you;
let i = 0;
let j = 0;
let k = 0;

let container = document.querySelector(".game")
document.querySelector('div').addEventListener('click', (event) => {

    if (event.target.className == "rock") {
        you = "0"
    }else if(event.target.className == "scissor"){
        you = "1"
    }else if (event.target.className == "paper") {
        you = "2"
    }
    Computer_rsp(you);
});

async function game() {

    // let response = await fetch(API);
    // let todo_api = await response.json();
    let idx = 0;

    //태그 초기화
    document.querySelector(".game").innerHTML = "";
    //게시물 생성
        let game = `<li>Win Count : ${i}</li>
                           <li>Lose Count : ${j}</li>
                           <li>Draw Count : ${k}</li>`
        container.innerHTML += game;


}
game();

//컴퓨터가 낼 가위바위보 & 비교
function Computer_rsp(you){

        let rand = Math.random();
        let result = Math.floor(rand*3);

        if (you == 0 && result == 2 || you == 1 && result == 0 || you == 2 && result == 1){
            console.log("You Win!");
            i++; //내가 이긴 점수
            youwinner();

        }else if(you == 0 && result == 1 || you == 1 && result == 2 || you == 2 && result == 0){
            console.log("Computer Win!")
            j++ // 컴퓨터가 이긴 점수
            computerwinner()
        }else{
            console.log("Same!")
            k++ //비긴 점수
        }
        game()

}

function youwinner(){
   document.querySelector("#you").classList.add("winner");
   document.querySelector("#computer").classList.remove("winner");

}
function computerwinner(){
    document.querySelector("#computer").classList.add("winner");
    document.querySelector("#you").classList.remove("winner");
}
