class MenuApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new MenuApi();
        }
        return this.#instance;
    }

    getMenuApi() {
        let responseData = null;
        $.ajax ({
            async: false,
            type: "get",
            url: "/category/menu",
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

class MenuEvent{
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new MenuEvent();
        }
        return this.#instance;
    }

    #MenuList;

    constructor() {
        this.#MenuList = MenuApi.getInstance().getMenuApi();
        console.log(this.#MenuList)
        this.getMenuList();
    }

    getMenuList() {
        const menuImgContainer = document.querySelector(".menu-img-container");
        menuImgContainer.innerHTML = "";
        if(this.#MenuList.length > 0) {
            this.#MenuList.forEach(menu => {
                menuImgContainer.innerHTML += `
                <div class="menu-dtl">
                    <img src="/static/image/strawberry.png" class="menu-img">
                    <div>이름:${menu.pdtName}</div>
                    <div>가격:${menu.pdtPrice}</div>
                </div>
                `;
            });
        }
        
    }
}

window.onload = () => {
    new HeaderBtnEvent();
    new CategoryEvent();
    new MenuEvent();
}