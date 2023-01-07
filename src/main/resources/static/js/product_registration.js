class ImgEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new ImgEvent();
        }
        return this.#instance;
    }

    constructor() {
        this.imgEvent();
    }

    imgEvent() {
        const fileDOM = document.querySelector("#file");
        const previews = document.querySelectorAll(".image-box");

        fileDOM.addEventListener('change', () => {
            const reader = new FileReader();
            reader.onload = ({ target }) => {
              previews[0].src = target.result;
            };
            reader.readAsDataURL(fileDOM.files[0]);
          });
    }
}

class ProductApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new ProductApi();
        }
        return this.#instance;
    }

    postProductApi(product) {
        let responseData = null;
        $.ajaxZ({
            async: false,
            type: "post",
            url: "/product/registration",
            contentType: "application/json",
            data: JSON.stringify(product),
            dataType: "json",
            success: (response) => {
                responseData = response.data;
                console.log(responseData);
            },
            error: (error) => {
                console.log(error);
            }
        })
    }
}

class registEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new registEvent();
        }
        return this.#instance;
    }

    constructor() {
        this.registBtnEvent();
    }

    registBtnEvent() {
        const productBtn = document.querySelector(".product-btn");
        productBtn.onclick = () => {
            let product = {
                pdtName: document.querySelector(".product-inputs").value,
                pdtPrice: document.querySelector(".product-price").value
            }
            ProductApi().getInstance().postProductApi(product);
        }
    }
}

window.onload = () => {
    new HeaderBtnEvent();
    new CategoryEvent();
    new ImgEvent();
    new registEvent;
}