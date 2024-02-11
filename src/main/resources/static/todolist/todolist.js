const API = '/api/todos'
let container = document.querySelector("#todos")



async function todos() {

    let response = await fetch(API);
    let todo_api = await response.json();
    let idx = 0;

    //<ul> 태그 초기화하기 -> innerHTML을 초기화해야 전부 초기화 되지 않는다.
    document.querySelector("#todos").innerHTML = "";


    //게시물 생성
    for (let i in todo_api) {
        let check = todo_api[idx].done;
        let todos = `<li class="${check == true ? "completed" : ""}">${todo_api[idx].content}
                            <input type="hidden" value="${todo_api[idx].id}"></li>
            `;
        container.innerHTML += todos;
        idx++;

    }
}
todos();

//등록
form.addEventListener("submit" , e => {
    e.preventDefault()
    let gettodo = document.getElementById("input")
    //gettodo에 input에서 받은 데이터를 담는다.
    let addvalue = gettodo.value
    // console.log(addvalue)
    //gettodo의 값을 addvalue에 담는다.
    gettodo.value = ""; //초기화
    add(addvalue);
    // console.log(addvalue)

})
//post할 때 json타입으로 보내기



async function add(addvalue){
    let response = await fetch("api/todos/save",
    {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            content: addvalue,
            done: false, //false
        })
    }).then((res)=> {todos()});

    // let result = await response.json();

    //then : 기다렸다가 호출된 함수를 진행하겠다는 것
}

//왼쪽 마우스 이벤트 - 취소선 생성/삭제
document.querySelector('ul').addEventListener('click', (event) => {
    var isLeftButton;

    // event = event || window.event;
    // if ("which" in event)
    //     isLeftButton= event.which == 1;

    if (event.target.className == ""){
        //취소선 생성
        event.target.className += "completed";
        chkid = event.target.childNodes[1].value

        chkchange(chkid);
    }else {
        // event.target.remove();
        // console.log(event.target)
        event.target.className = "";
        //한 번 더 클릭하면 취소선 취소
        chkid = event.target.childNodes[1].value

        chkcancle(chkid);

    }
    //fetch put (id, check) -> apicontroller에서 @putmapping
});
//취소선 취소 함수
async function chkcancle(chkid){
    await fetch("/api/todos/update",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                id : chkid,
                done: false, //false
            })
        })
}
//취소선 생성 함수
async function chkchange(chkid){
    let response= await fetch("/api/todos/update",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                id : chkid,
                done: true, //true
            })
        })
}
// 오른쪽 마우스 이벤트 - 삭제
document.querySelector('ul').addEventListener('mousedown', (event) => {
    if ((event.button === 2)||(event.which === 3)) {
        chkid = event.target.childNodes[1].value
        deletetodo(chkid);
    }
    window.oncontextmenu = function (){
        //마우스 우클릭시 메뉴창 해제
        return false;
    }
});

//리스트 삭제 함수
async function deletetodo(chkid){
    let response= await fetch("/api/todos/delete",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                id : chkid
            })
        }).then((res)=> {todos()});
}

