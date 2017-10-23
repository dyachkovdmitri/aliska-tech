Ext.define('ALISKA.controller.MainController', {
    extend: 'Ext.app.Controller',
    views: ['MainPanel', 'GetOfferPanel', 'AddPrice'],
    stores: ['ItemOfferStore', 'ItemPriceStore'],
    models: ['ItemOfferModel', 'ItemPriceModel'],
    controllers: ['ItemOfferController', 'ItemPriceController'],
    init: function () {
        // this.control({
        //     'getOfferPanel': {
        //         fileupload: this.uploadFileAction()
        //     },
        //     'addPrice': {
        //         fileupload2: this.uploadPriceAction()
        //     }
        // });
    }
    //
    // uploadFileAction: function (fb) {
    //     var self = this;
    //     var file = fb.fileInputEl.dom.files[0];
    //     if (!(/\.(xlsx)$/i).test(file.name)) {
    //         Ext.Msg.alert("Неверный формат!", "Возможна загрузка файлов только формата xlsx");
    //         return;
    //     }
    //     self.uploadFile(file,false);
    //     fb.fileInputEl.dom.value = '';
    // },
    //
    // uploadPriceAction: function (fb) {
    //     var self = this;
    //     var file = fb.fileInputEl.dom.files[0];
    //     if (!(/\.(xlsx)$/i).test(file.name)) {
    //         Ext.Msg.alert("Неверный формат!", "Возможна загрузка файлов только формата xlsx");
    //         return;
    //     }
    //     self.uploadPrice(file, true);
    //     fb.fileInputEl.dom.value = '';
    // },
    //
    // uploadFile: function (file, isPrice) {
    //     var xhr = new XMLHttpRequest();
    //     // xhr.upload.onprogress = function (event) {
    //     //     var percent = event.loaded / event.total;
    //     //     if (event.loaded < event.total) {
    //     //         Ext.MessageBox.updateProgress(percent, Math.round(percent * 100) + '% обработано');
    //     //     } else {
    //     //         Ext.MessageBox.wait("Обработка...", 'Загрузка CSV');
    //     //     }
    //     // };
    //     var url = isPrice?"item/loadfile/":"customerRequest/loadfile/";
    //     xhr.onload = xhr.onerror = function () {
    //         if (this.status == 200) {
    //             var data = JSON.parse(xhr.responseText);
    //             document.cookie = isPrice?"companyId=" + data.msg:"customerRequestId=" + data.msg;
    //             Ext.getStore('ItemOfferStore').load();
    //         }
    //     };
    //
    //     xhr.open("POST", url, true);
    //     var formData = new FormData();
    //     formData.append("file", file);
    //     xhr.send(formData);
    // }
});