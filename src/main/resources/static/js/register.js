class Api {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new Api();
        }
        return this.#instance;
    }

    getRegisterApi(user) {
        const registerBtn = document.querySelector(".register");

        // registerBtn.onclick = () => {
        //     let user = {
        //         "username" : document.querySelectorAll(".login-content input")[0].value,
        //         "password" : document.querySelectorAll(".login-content input")[1].value,
        //         "passwordChk" : document.querySelectorAll(".login-content input")[2].value
        //     }
            $.ajax({
                async: false,
                type: "post",
                url: "/api/account/register",
                contentType: "application/json",
                data: JSON.stringify(user),
                dataType: "json",
                success: (response) => {
                    console.log(response.data);
                },
                error: (error) => {
                    console.log(error);
                }
            });
        }
    // }
}

class Event {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new Event();
        }
        return this.#instance;
    }


    constructor() {
        this.registerEvent();
    }

    registerEvent() {
        const registerBtn = document.querySelector(".register");

        registerBtn.onclick = () => {
            let user = {
                "username" : document.querySelector(".username").value,
                "password" : document.querySelector(".password").value,
                "passwordChk" : document.querySelector(".pw-chk").value
            }
            console.log(user);
            Api.getInstance().getRegisterApi(user);
        }

    }
}

window.onload = () => {
    // Api.getInstance().getRegisterApi();
    new Event();
}