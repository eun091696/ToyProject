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
                success: (response, textStatus, request) => {
                    const successURI = request.getResponseHeader("Location");
                    location.replace(successURI + "?username=" + response.data);
                },
                error: (error) => {
                    console.log(error);
                }
            });
        }
    }
}

window.onload = () => {
    Api.getInstance().getRegisterApi();
    new HeaderBtnEvent();
}