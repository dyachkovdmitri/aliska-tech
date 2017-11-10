Ext.define('ALISKA.controller.ItemOfferController', {
    extend: 'Ext.app.Controller',
    views: ['GetOfferPanel'],
    stores: ['ItemOfferStore'],
    models: ['ItemOfferModel'],
    //controllers:['ItemOfferController'],
    init: function () {
        this.control({
            'getOfferPanel': {
                fileupload: this.uploadFileAction
            }
        });
    },

    uploadFileAction: function (fb) {
        var self = this;
        var file = fb.fileInputEl.dom.files[0];
        // if (!(/\.(xlsx)$/i).test(file.name)) {
        //     Ext.Msg.alert("Неверный формат!", "Возможна загрузка файлов только формата xlsx");
        //     return;
        // }
        self.uploadFile(file);
        fb.fileInputEl.dom.value = '';
    },

    uploadFile: function (file) {
        var xhr = new XMLHttpRequest();
        var url = "customerRequest/loadfile/";
        xhr.onload = xhr.onerror = function () {
            if (this.status == 200) {
                var data = JSON.parse(xhr.responseText);
                document.cookie = "customerRequestId=" + data.msg;

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
        //console.log(Ext.getCmp("checkboxBrand").getValue());
        formData.append("brandImportant", Ext.getCmp("checkboxBrand").getValue());
        formData.append("accuracy", Ext.getCmp("accuracyNumber").getValue());
        formData.append("priceItemId", Ext.getCmp("priceItemId").getValue());
        xhr.send(formData);
    }
});