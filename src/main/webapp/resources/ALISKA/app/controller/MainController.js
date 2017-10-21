var requestOrder = 0;
Ext.define('ALISKA.controller.MainController', {
    extend: 'Ext.app.Controller',
    views: ['MainPanel','GetOfferPanel', 'AddPrice'],
    stores: ['ItemOfferStore'],
    models: ['ItemOfferModel'],
    init: function() {
        this.control({
            'getOfferPanel': {
                fileupload: this.uploadFileAction
            }
        });
    },
    uploadFileAction: function (fb) {
        var self = this;
        var file = fb.fileInputEl.dom.files[0];
        if (!(/\.(xlsx)$/i).test(file.name)) {
            Ext.Msg.alert("Неверный формат!", "Возможна загрузка файлов только формата xlsx");
            return;
        }
        self.uploadFile(file);
        fb.fileInputEl.dom.value = '';
    },

    uploadFile: function(file) {
        var xhr = new XMLHttpRequest();
        // xhr.upload.onprogress = function (event) {
        //     var percent = event.loaded / event.total;
        //     if (event.loaded < event.total) {
        //         Ext.MessageBox.updateProgress(percent, Math.round(percent * 100) + '% обработано');
        //     } else {
        //         Ext.MessageBox.wait("Обработка...", 'Загрузка CSV');
        //     }
        // };

        xhr.onload = xhr.onerror = function () {
            if (this.status == 200) {
                var data = JSON.parse(xhr.responseText);
                document.cookie = "customerRequestId="+data.msg;
                // Ext.getStore('ItemOfferStore').requestOrderId=322;
                // console.log(Ext.getStore('ItemOfferStore'));
                // localStorage.setItem('requestOrder', 322);
                Ext.getStore('ItemOfferStore').load();
            }
        };

        xhr.open("POST", "customerRequest/loadfile/", true);
        var formData = new FormData();
        formData.append("file", file);
        xhr.send(formData);
    }
});