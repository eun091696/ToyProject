class HeaderBtnEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new BtnEvent()
        }
        return this.#instance;
    }

    constructor() {
        this.LoginBtnEvent();
        this.RegisterBtn();
    }

    LoginBtnEvent() {
        const loginBtn = document.querySelector(".login-btn");
        loginBtn.onclick = () => {
            location.href = "/login";
        }
    }

    RegisterBtn() {
        const registerBtn = document.querySelector(".register-btn");
        registerBtn.onclick = () => {
            location.href = "/register";
        }
    }

    LogoImgBtn() {
        const LogoImgBtn = document.querySelector(".logo-img");
        LogoImgBtn.onclick = () => {
            location.href = "/";
        }
    }
}