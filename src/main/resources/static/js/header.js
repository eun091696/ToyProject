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
                console.log(responseData)
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
                <li ><a href="${categoryName.category_url}">${categoryName.category_name}</a></li>
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
        this.headerBtnEvent();
    }

    headerBtnEvent() {
        const loginBtn = document.querySelector(".login-btn");
        if(loginBtn != null) {
            loginBtn.onclick = () => {
            location.href = "/login";
            }
        }

        const registerBtn = document.querySelector(".register-btn");
        if(registerBtn != null) {registerBtn.onclick = () => {
            location.href = "/register";
            }
        }

        const logoutBtn = document.querySelector(".logout-btn");
        if(logoutBtn != null) {
            logoutBtn.onclick = () => {
            location.href = "/logout";
            }
        }

        const cartBtn = document.querySelector(".cart-btn");
        if(cartBtn != null) {
            cartBtn.onclick = () => {
                location.href = "/cart";
            }
        }

        const LogoImgBtn = document.querySelector(".logo-img");
        LogoImgBtn.onclick = () => {
            location.href = "/";
        }

        const productRegisterBtn = document.querySelector(".productRegister-btn");
        if(productRegisterBtn != null) {
            productRegisterBtn.onclick = () => {
                location.href = "/product/registration";
            }
        }
    }
}