class Api {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new Api();
        }
        return this.#instance;
    }

    getRegisterApi(user) {
        let responseData = null;

        $.ajax({
            async: false,
            type: "post",
            url: "/api/account/register",
            contentType: "application/json",
            data: JSON.stringify(user),
            dataType: "json",
            success: (response) => {
                responseData = response.data;
            },
            error: (error) => {
                console.log(error);
            }
        })
        return responseData;
    }
}

class Event {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new Event();
        }
        return this.#instance;
    }

    #responseData;

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
            this.#responseData = Api.getInstance().getRegisterApi(user);
        }

    }
}