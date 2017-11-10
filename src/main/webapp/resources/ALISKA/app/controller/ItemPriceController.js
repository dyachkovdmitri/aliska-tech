Ext.define('ALISKA.controller.ItemPriceController', {
    extend: 'Ext.app.Controller',
    views: ['AddPrice'],
    stores: ['ItemPriceStore','PriceStore'],
    models: ['ItemPriceModel','PriceModel'],
    init: function () {
        this.control({
            'addPrice': {
                fileupload: this.uploadPriceAction
            }
        });
    },

    uploadPriceAction: function (fb) {
        var self = this;
        var file = fb.fileInputEl.dom.files[0];
        // if (!(/\.(xlsx)$/i).test(file.name)) {
        //     Ext.Msg.alert("Неверный формат!", "Возможна загрузка файлов только формата xlsx");
        //     return;
        // }
        self.uploadPrice(file);
        fb.fileInputEl.dom.value = '';
    },

    uploadPrice: function (file) {
        var xhr = new XMLHttpRequest();
        var url ="item/loadfile/";
        xhr.onload = xhr.onerror = function () {
            if (this.status == 200) {
                var data = JSON.parse(xhr.responseText);
                document.cookie ="companyId=" + data.msg;
                Ext.getStore('ItemOfferStore').load();
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