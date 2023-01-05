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

window.onload = () => {
    new HeaderBtnEvent();
    new CategoryEvent();
    new ImgEvent();
}