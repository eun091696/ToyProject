class CategoryApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new CategoryApi();
        }
        return this.#instance;
    }

    getCategoryApi() {
        let responseData = null;
        $.ajax ({
            async: false,
            type: "get",
            url: "/category/names",
            dataType: "json",
            success: (response) => {
                responseData = response.data;
            },
            error: (error) => {
                console.log(error)
            }
        });
        return responseData;
    }
}

class CategoryEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new CategoryEvent();
        }
        return this.#instance;
    }

    #responseCategoryData;

    constructor() {
        this.#responseCategoryData = CategoryApi.getInstance().getCategoryApi();
        this.getCategoryNames();
    }

    getCategoryNames() {
        const category = document.querySelector(".category");
        category.innerHTML = "";
        if(this.#responseCategoryData != null) {
            this.#responseCategoryData.forEach(categoryName => {
                category.innerHTML += `
                <li><a href="">${categoryName.category_name}</a></li>
                `;
            });
        }
    }
}

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
        this.LogoImgBtn();
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