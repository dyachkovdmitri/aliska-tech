Ext.define('ALISKA.controller.ItemPriceController', {
    extend: 'Ext.app.Controller',
    views: ['AddPrice', 'PricePanel'],
    stores: ['ItemPriceStore'],
    models: ['ItemPriceModel'],
    init: function () {
        this.control({
            'pricePanel': {
                fileupload: this.uploadPriceAction
            }

        });
    },

    uploadPriceAction: function (fb) {
        var self = this;
        var file = fb.fileInputEl.dom.files[0];
        self.uploadPrice(file);
        fb.fileInputEl.dom.value = '';
    },

    uploadPrice: function (file) {
        var xhr = new XMLHttpRequest();
        var url = "item/loadfile/";
        xhr.onload = xhr.onerror = function () {
            if (this.status == 200) {
                var data = JSON.parse(xhr.responseText);
                document.cookie = "priceId="+data.msg;
                console.log(xhr.responseText);
                Ext.getStore('ItemPriceStore').load();
            }
        };
        var makeId = function () {
            var text = "";
            var possible = "0123456789";
            for (var i = 0; i < 6; i++)
                text += possible.charAt(Math.floor(Math.random() * possible.length));

            return text;
        };

        if (!document.cookie.includes("customerAliskaId")) {
            document.cookie = "customerAliskaId=" + makeId();
        }

        xhr.open("POST", url, true);
        var formData = new FormData();
        formData.append("file", file);
        xhr.send(formData);
    }
});