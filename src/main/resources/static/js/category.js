class categoryEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new categoryEvent();
        }
        return this.#instance;
    }

    getApi() {
        let responseData = null;
        $.ajax({
            async: false,
            type: "get",
            url: "category/menu",
            dataType: "json",
            success: (response) => {
                responseData = response.data;
            },
            error: (error) => {
                console.log(error)
            }
        });
    }
}

