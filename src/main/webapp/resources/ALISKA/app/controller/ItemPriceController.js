Ext.define('ALISKA.controller.ItemPriceController', {
    extend: 'Ext.app.Controller',
    views: ['AddPrice'],
    stores: ['ItemPriceStore'],
    models: ['ItemPriceModel'],
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
        // xhr.upload.onprogress = function (event) {
        //     var percent = event.loaded / event.total;
        //     if (event.loaded < event.total) {
        //         Ext.MessageBox.updateProgress(percent, Math.round(percent * 100) + '% обработано');
        //     } else {
        //         Ext.MessageBox.wait("Обработка...", 'Загрузка CSV');
        //     }
        // };
        var url ="item/loadfile/";
        xhr.onload = xhr.onerror = function () {
            if (this.status == 200) {
                var data = JSON.parse(xhr.responseText);
                document.cookie ="companyId=" + data.msg;
                Ext.getStore('ItemOfferStore').load();
            }
        };

        xhr.open("POST", url, true);
        var formData = new FormData();
        formData.append("file", file);
        xhr.send(formData);
    }
});