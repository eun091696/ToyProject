class Api {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new Api();
        }
        return this.#instance;
    }

    getUserApi() {
        $.ajax ({
            async: false,
            type: "get",
            url: "/api/account/login",
            dataType: "json",
            success: (response) => {
                console.log(response.data);
            },
            error: (error) => {
                console.log(error);
            }
        });
    }
}

window.onload = () => {
    new HeaderBtnEvent();
}