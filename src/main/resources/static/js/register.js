class Api {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new Api();
        }
        return this.#instance;
    }

    constructor() {
        this.getRegisterApi();
    }

    getRegisterApi() {
        const registerBtn = document.querySelector(".register");

        registerBtn.onclick = () => {
            let user = {
                "username" : document.querySelector(".username").value,
                "password" : document.querySelectorAll(".login-content input")[1].value,
                "passwordChk" : document.querySelectorAll(".login-content input")[2].value
            }
            $.ajax({
                async: false,
                type: "post",
                url: "/api/account/register",
                contentType: "application/json",
                data: JSON.stringify(user),
                dataType: "json",
                success: (response) => {
                    console.log(response.data);
                    console.log("실행되요");
                },
                error: (error) => {
                    console.log(error);
                }
            });
        }
    }
}

// class Event {
//     static #instance = null;
//     static getInstance() {
//         if(this.#instance == null) {
//             this.#instance = new Event();
//         }
//         return this.#instance;
//     }


//     constructor() {
//         this.registerEvent();
//     }

//     registerEvent() {
//         const registerBtn = document.querySelector(".register");

//         registerBtn.onclick = () => {
//             let user = {
//                 "username" : document.querySelector(".username").value,
//                 "password" : document.querySelector(".password").value,
//                 "passwordChk" : document.querySelector(".pw-chk").value
//             }
//             new Api();
//             console.log(new Api());
//         }

//     }
// }

window.onload = () => {
    Api.getInstance().getRegisterApi();
    // new Event();
}